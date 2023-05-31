#include "String.h"

String::String(const std::string &str) { this->_val = str; }
std::string String::val() { return this->_val; }
void String::set_val(const std::string &str) { this->_val = str; }
json_object::_type String::type() { return this->STRING; }
std::string String::to_string()
{
    std::string str;
    int index = 0;
    char base = '\0';
    while (index < (int) this->_val.length())
    {
        switch (this->_val.at(index))
        {
        case '\'':
        case '"':
            if (base != '\0')
            {
                if (base != this->_val.at(index))
                {
                    throw std::runtime_error("String to_string failed due to base character comparison");
                }
            }
            else
            {
                base = this->_val[index];
            }
        default:
            str += this->_val.at(index);
        }
        index++;
    }
    switch (base)
    {
    case '\'':
        base = '"';
        break;
    case '"':
    case '\0':
        base = '\'';
        break;
    default:
        throw std::runtime_error("String to_string failed due to unknown base character");
    }
    str.insert(0, std::string(1, base));
    str.append(std::string(1, base));
    return str;
}

// STATIC
json_object *String::parse(const char *input, int length, char base)
{
    // Debug
    // std::cout << "String Parse" << std::endl << "Before : " << json_object::_index << std::endl;

    // Initialize
    std::string str;
    // str += base;
    json_object::_index++;
    int offset = 0;

    // Main Loop
    while (json_object::_index + offset < json_object::_index + length - 1)
    {
        switch (input[json_object::_index + offset])
        {
        case '\\':
            // Control Characters
            switch (input[json_object::_index + offset + 1])
            {
            case '\'':
                if (base == '\'')
                    throw std::runtime_error("String parse failed due to base comparison");
                str += '\'';
                break;
            case '"':
                if (base == '"')
                    throw std::runtime_error("String parse failed due to base comparison");
                str += '"';
                break;
            default:
                throw std::runtime_error("String parse failed due to control character");
            }
            offset++;
            break;
        case '\'':
        case '\"':
            if (input[json_object::_index + offset] == base)
                throw std::runtime_error("String parse failed due to length mismatch");
        default:
            str += input[json_object::_index + offset];
        }
        offset++;
    }

    // JSON Format Validation
    if (input[json_object::_index + offset] != base)
        throw std::runtime_error("String parse failed due to wrong JSON format");

    // Finalize
    // str += base;
    json_object::_index += offset + 1;

    // Debug
    // std::cout << "After : " << json_object::_index << std::endl;

    // Return
    return new String(str);
}