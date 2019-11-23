#include "String.h"

String::String(const std::string &str) { this->_val = str; }
std::string String::val() { return this->_val; }
void String::set_val(const std::string &str) { this->_val = str; }
json_object::_type String::type() { return this->STRING; }
std::string String::to_string() { return this->_val; }

// STATIC
json_object *String::parse(const char *input, int length, char base)
{
    // Initialize
    std::string str;
    str += base;
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
    str += base;
    json_object::_index += offset + 1;

    // Return
    return new String(str);
}