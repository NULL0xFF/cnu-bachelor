#include "Integer.h"

/* Private */
Integer::Integer(int value) { this->_val = value; }
/* Public */
int Integer::val() { return this->_val; }
void Integer::set_val(const int &value) { this->_val = value; }
json_object *Integer::parse(const char *input, int length)
{
    bool signFlag = false;
    if (input[json_object::_index] == '-')
    {
        signFlag = true;
        json_object::_index++;
    }
    int value = 0;
    int bit = 0;
    for (int i = (signFlag) ? 1 : 0; i < length; i++)
    {
        switch (input[json_object::_index])
        {
        case '0':
            bit = 0;
            break;
        case '1':
            bit = 1;
            break;
        case '2':
            bit = 2;
            break;
        case '3':
            bit = 3;
            break;
        case '4':
            bit = 4;
            break;
        case '5':
            bit = 5;
            break;
        case '6':
            bit = 6;
            break;
        case '7':
            bit = 7;
            break;
        case '8':
            bit = 8;
            break;
        case '9':
            bit = 9;
            break;
        default:
            throw std::runtime_error("Integer parse failed");
        }
        value = (value * 10) + bit;
        json_object::_index++;
    }
    if (signFlag)
        value = -value;
    return new Integer(value);
}
json_object::_type Integer::type() { return this->INT; }
std::string Integer::to_string() { return std::to_string(this->_val); }