#include "json_object.h"
#include "json_dict.h"
#include "json_list.h"
#include "data/String.h"
#include "data/Integer.h"

// JSON Input Index Field
int json_object::_index = 0;

/**
 * Pass input string as character pointer using
 * c_str() function and length with length() function
 */
json_object *json_object::parse(const std::string &str)
{
    /**
     * (re)Initialize static field as this field shared
     * inside program until program stops.
     */
    json_object::_index = 0;
    return json_object::parse(str.c_str(), str.length());
}
/**
 * Parse input char pointer(was a string) with JSON format
 * and return json_object as parsed json object's type
 * defined as enum _type
 */
json_object *json_object::parse(
    const char *input, // char pointer which was a string
    int length         // length of string used to limit char pointer
)
{
    /* Initialize Variables */
    json_object *obj = nullptr; // A object to be returned when parsing has done
    int innerCallNumber = 0;    // DICT and LIST parsing stack variable
    int offset = 0;             // Offset variable to calculate parsed string's length

SWITCH:
    switch (input[json_object::_index])
    {
    case ' ':
    case '\n':
    case '\t':
    case '\r':
        // Whitespace
        json_object::_index++;
        goto SWITCH;
    case '{':
        // DICT
        offset++;
        innerCallNumber = 0;
        while (true)
        {
            if (input[json_object::_index + offset] == '}')
            {
                if (innerCallNumber == 0)
                {
                    offset++;
                    break;
                }
                else
                {
                    innerCallNumber--;
                }
            }
            else if (input[json_object::_index + offset] == '{')
            {
                innerCallNumber++;
            }
            offset++;
        }
        obj = json_dict::parse(input, offset);
        break;
    case '[':
        // LIST
        offset++;
        innerCallNumber = 0;
        while (true)
        {
            if (input[json_object::_index + offset] == ']')
            {
                if (innerCallNumber == 0)
                {
                    offset++;
                    break;
                }
                else
                {
                    innerCallNumber--;
                }
            }
            else if (input[json_object::_index + offset] == '[')
            {
                innerCallNumber++;
            }
            offset++;
        }
        obj = json_list::parse(input, offset);
        break;
    case '-':
        offset++;
    case '0' ... '9':
        // INT
        while (true)
        {
            if (input[json_object::_index + offset] < '0' || '9' < input[json_object::_index + offset])
                break;
            offset++;
        }
        obj = Integer::parse(input, offset);
        break;
    case '\'':
    case '\"':
        // STRING
        offset++;
        while (true)
        {
            offset++;
            if (input[json_object::_index + offset] == input[json_object::_index])
                break;
        }
        obj = String::parse(input, offset, input[json_object::_index]);
        break;
    }

    // JSON Format Validation
    if (json_object::_index != length)
        throw std::runtime_error("json_object parse failed due to wrong JSON format");

    // Finalize
    json_object::_index++;

    return obj;
}