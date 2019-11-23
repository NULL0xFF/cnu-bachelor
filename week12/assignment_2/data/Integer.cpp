#include "Integer.h"

Integer::Integer(int value) { this->_val = value; }
int Integer::val() { return this->_val; }
void Integer::set_val(const int &value) { this->_val = value; }
json_object::_type Integer::type() { return this->INT; }
std::string Integer::to_string() { return std::to_string(this->_val); }

// STATIC
json_object *Integer::parse(const char *input, int length)
{
    // Check Sign
    bool signFlag = false;
    if (input[json_object::_index] == '-')
    {
        signFlag = true;
        json_object::_index++;
    }

    // Initialize
    int offset = 0, value = 0, bit = 0;
    while (json_object::_index + offset < json_object::_index + length)
    {
        switch (input[json_object::_index])
        {
        case '0' ... '9':
            bit = input[json_object::_index] - 48;
            value = value * 10;
            value += bit;
            break;
        default:
            throw std::runtime_error("Integer parse failed due to wrong JSON Format");
        }
        offset++;
    }

    // Finalize
    if (signFlag)
        value = -value;
    json_object::_index += offset;

    // Return
    return new Integer(value);
}