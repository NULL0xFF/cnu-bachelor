#include "json_object.h"
#include "data/String.h"

int json_object::_index = 0;

json_object *json_object::parse(const char *input, int length)
{
    // Initialize
    json_object *obj;
    int i = 0, j = 1;
    bool sign = false;
    // Loop
    while (i < length)
    {
        sign = false;
        switch (input[i])
        {
        case '{':
            // DICT
            break;
        case '[':
            // LIST
            break;
        case '\n':
            // WHITESPACE
            break;
        case '\'':
        case '\"':
            // STRING
            while (input[j] != input[i])
                j++;
            obj = String::parse((input + i), ((j - i) + 1), input[i]);
            break;
        case '-':
            sign = true;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            // INTEGER
            break;
        default:
            throw new std::runtime_error("parse error");
        }
        // Iteration

    }

    // Return
    return obj;
}

json_object *json_object::parse(const std::string &str)
{
    return parse(str.c_str(), str.length());
}