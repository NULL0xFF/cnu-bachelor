#include "json_object.h"
#include "data/String.h"
#include "data/Integer.h"

/* Protected */
int json_object::_index = 0;
json_object *json_object::parse(const char *input, int length)
{
    // Initialize
    json_object::_index = 0;
    bool flag;

    /* WHITESPACE REMOVAL */
    while (true)
    {
        flag = false;
        switch (input[json_object::_index])
        {
        case ' ':
        case '\n':
        case '\r':
        case '\t':
            // WHITESPACE
            json_object::_index++;
            break;
        default:
            flag = true;
            break;
        }
        if (flag)
            break;
    }
    /* END OF REMOVAL */

    json_object *obj;
    int index;
    while (json_object::_index < length)
    {
        index = 0;
        switch (input[json_object::_index])
        {
        case '{':
            // DICT
            throw std::runtime_error("json_object json_dict parse not implemented");
            break;
        case '[':
            // LIST
            throw std::runtime_error("json_object json_list parse not implemented");
            break;
        case '-':
            index++;
        case '0' ... '9':
            // INT
            flag = true;
            while (flag)
            {
                switch (input[json_object::_index + index])
                {
                case '0' ... '9':
                    index++;
                    break;
                default:
                    flag = false;
                }
            }
            std::cout << index << std::endl;
            obj = Integer::parse(input, index);
            /* WHITESPACE REMOVAL */
            while (true)
            {
                flag = false;
                switch (input[json_object::_index])
                {
                case ' ':
                case '\n':
                case '\r':
                case '\t':
                    // WHITESPACE
                    json_object::_index++;
                    break;
                default:
                    flag = true;
                    break;
                }
                if (flag)
                    break;
            }
            /* END OF REMOVAL */
            break;
        case '\"':
        case '\'':
            // STRING
            index++;
            while (true)
            {
                if (input[json_object::_index] == input[json_object::_index + index])
                    break;
                index++;
            }
            obj = String::parse(input, index + 1, input[json_object::_index]);
            /* WHITESPACE REMOVAL */
            while (true)
            {
                flag = false;
                switch (input[json_object::_index])
                {
                case ' ':
                case '\n':
                case '\r':
                case '\t':
                    // WHITESPACE
                    json_object::_index++;
                    break;
                default:
                    flag = true;
                    break;
                }
                if (flag)
                    break;
            }
            /* END OF REMOVAL */
            break;
        default:
            throw std::runtime_error("json_object parse failed");
        }
    }
    return obj;
}
/* Public */
json_object *json_object::parse(const std::string &str)
{
    return json_object::parse(str.c_str(), str.length());
}