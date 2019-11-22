#include "String.h"

/* Private */
String::String(const std::string &str) { this->_val = str; }
/* Public */
std::string String::val() { return this->_val; }
void String::set_val(const std::string &str) { this->_val = str; }
json_object *String::parse(const char *input, int length, char base)
{
    std::string str;
    str = str + base;
    int index = 1;
    while (index < length)
    {
        switch (input[json_object::_index + index])
        {
        case '\\':
            // CONTROL CHARACTER
            index++;
            switch (input[json_object::_index + index])
            {
            case '"':
                if (base == '"')
                    throw std::runtime_error("String control base exception");
                str = str + '"';
                break;
            case '\'':
                if (base == '\'')
                    throw std::runtime_error("String control base exception");
                str = str + '\'';
                break;
            case '\\':
                str = str + '\\';
                break;
            case '/':
                str = str + '/';
                break;
            case 'b':
                str = str + '\b';
                break;
            case 'f':
                str = str + '\f';
                break;
            case 'n':
                str = str + '\n';
                break;
            case 'r':
                str = str + '\r';
                break;
            case 't':
                str = str + '\t';
                break;
            case 'u':
                // UNICODE
                throw std::runtime_error("String control unicord not implemented");
            }
            break;
        default:
            str = str + input[json_object::_index + index];
        }
        index++;
    }
    json_object::_index = json_object::_index + length;
    return new String(str);
}
json_object::_type String::type() { return this->STRING; }
std::string String::to_string()
{
    return this->_val;
}
