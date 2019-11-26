#include "json_object.h"
#include "json_dict.h"
#include "json_list.h"
#include "data/String.h"
#include "data/Integer.h"

int json_object::_index = 0;

json_object *json_object::parse(const std::string &str) { return json_object::parse(str.c_str(), str.length()); }
json_object *json_object::parse(const char *input, int length)
{
    // Initialize
    json_object::_index = 0;
    json_object *obj = nullptr;
    int index = 0, innerIndex;

    // Case By Case
    switch (input[json_object::_index])
    {
    case '{':
        // List
        index++;
        innerIndex = 0;
        while (true)
        {
            if (input[json_object::_index + index] == '}')
            {
                if (innerIndex == 0)
                {
                    index++;
                    break;
                }
                else
                {
                    innerIndex--;
                }
            }
            else if (input[json_object::_index + index] == '{')
            {
                innerIndex++;
            }
            index++;
        }
        obj = json_dict::parse(input, index);
        break;
    case '[':
        // List
        index++;
        innerIndex = 0;
        while (true)
        {
            if (input[json_object::_index + index] == ']')
            {
                if (innerIndex == 0)
                {
                    index++;
                    break;
                }
                else
                {
                    innerIndex--;
                }
            }
            else if (input[json_object::_index + index] == '[')
            {
                innerIndex++;
            }
            index++;
        }
        obj = json_list::parse(input, index);
        break;
    case '-':
        index++;
    case '0' ... '9':
        // Integer
        while (true)
        {
            if (input[json_object::_index + index] < '0' || '9' < input[json_object::_index + index])
                break;
            index++;
        }
        obj = Integer::parse(input, index);
        break;
    case '\'':
    case '\"':
        // String
        index++;
        while (true)
        {
            index++;
            if (input[json_object::_index + index] == input[json_object::_index])
                break;
        }
        obj = String::parse(input, index, input[json_object::_index]);
        break;
    }

    // JSON Format Validation
    if (json_object::_index != length)
        throw std::runtime_error("json_object parse failed due to wrong JSON format");

    // Finalize
    json_object::_index++;

    return obj;
}