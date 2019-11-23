#include "json_list.h"
#include "data/Integer.h"
#include "data/String.h"

json_list::json_list() {}
json_object *json_list::operator[](int key) const { return this->v[key]; }
json_object::_type json_list::type() { return this->LIST; }
std::string json_list::to_string()
{
    std::string str("[");
    int index;
    for (index = 0; index < this->v.size(); index++)
    {
        str += v[index]->to_string();
        if (index + 1 < this->v.size())
            str += ", ";
    }
    str += "]";
    return str;
}

// STATIC
json_object *json_list::parse(const char *input, int length)
{
    // Initialize
    json_list *list = new json_list();
    json_object *value;
    int baseIndex = json_object::_index, index, listIndex;
    json_object::_index++;

    // Main Loop
    while (json_object::_index < baseIndex + length - 1)
    {
        index = 0;
        switch (input[json_object::_index])
        {
        case ' ':
        case '\n':
        case '\t':
        case '\r':
            // Whitespace
            json_object::_index++;
            break;
        case ',':
            // Next Element
            if (list->v.size() == 0)
                throw std::runtime_error("json_list parse failed due to wrong JSON format");
            json_object::_index++;
            break;
        case '[':
            // List
            index++;
            listIndex = 0;
            while (true)
            {
                if (input[json_object::_index + index] == ']')
                {
                    if (listIndex == 0)
                    {
                        index++;
                        break;
                    }
                    else
                    {
                        index++;
                        listIndex--;
                        break;
                    }
                }
                else if (input[json_object::_index + index] == '[')
                {
                    listIndex++;
                }
                index++;
            }
            value = json_list::parse(input, index);
            list->v.push_back(value);
            break;
        case ']':
            if (listIndex == 0)
                throw std::runtime_error(std::to_string(json_object::_index));
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
            value = Integer::parse(input, index);
            list->v.push_back(value);
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
            value = String::parse(input, index, input[json_object::_index]);
            list->v.push_back(value);
            break;
        }
    }

    // JSON Format Validation
    if (input[json_object::_index] != ']')
        throw std::runtime_error("json_list parse failed due to wrong JSON format");

    // Finalize
    json_object::_index++;

    // Return
    return list;
}