#include "json_dict.h"
#include "json_list.h"
#include "data/String.h"
#include "data/Integer.h"

json_dict::json_dict() {}
void json_dict::put(json_object *key, json_object *val)
{
    int index = this->find(key);
    if (index == -1)
    {
        this->v.push_back(std::make_pair(key, val));
        return;
    }
    else
    {
        this->v[index].second = val;
        return;
    }
    throw std::runtime_error("json_dict put failed");
}
int json_dict::find(json_object *key)
{
    int index = 0;
    for (auto it = v.begin(); it != v.end(); it++)
    {
        // Iterate next element when iterator->first's type is not equals to key's type
        if (key->type() != it->first->type())
        {
            index++;
            continue;
        }
        // As it->first and key's types are equal, check whether their val is equal.
        switch (it->first->type())
        {
        case DICT:
        case LIST:
            break;
        case STRING:
            if (((String *)it->first)->val().compare(((String *)key)->val()) == 0)
                return index;

            break;
        case INT:
            if (((Integer *)it->first)->val() == ((Integer *)key)->val())
                return index;

            break;
        default:
            throw std::runtime_error("json_dict find failed due to undefined type");
        }
        index++;
    }

    // Key not found
    return -1;
}

// Static
json_object *json_dict::parse(const char *input, int length)
{
    // Debug
    // std::cout << "Dict Parse Before : " << json_object::_index << std::endl;

    // Initialize
    json_dict *dict = new json_dict();
    json_object *key = nullptr, *value = nullptr;
    int baseIndex = json_object::_index, index, dictIndex, listIndex;
    bool pairFlag = false;
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
            if (dict->v.size() == 0)
                throw std::runtime_error("json_dict parse failed due to wrong JSON format (case ',', v.size())");
            if (pairFlag)
                throw std::runtime_error("json_dict parse failed due to wrong JSON format (case ',', pairFlag)");
            json_object::_index++;
            break;
        case ':':
            // Pair Flag
            if (!pairFlag)
                throw std::runtime_error("json_dict parse failed due to wrong JSON format (case ':')");
            json_object::_index++;
            break;
        case '{':
            // DICT
            index++;
            dictIndex = 0;
            while (true)
            {
                if (input[json_object::_index + index] == '}')
                {
                    if (dictIndex == 0)
                    {
                        index++;
                        break;
                    }
                    else
                    {
                        dictIndex--;
                    }
                }
                else if (input[json_object::_index + index] == '{')
                {
                    dictIndex++;
                }
                index++;
            }
            if (!pairFlag)
            {
                key = json_dict::parse(input, index);
                pairFlag = true;
            }
            else
            {
                value = json_dict::parse(input, index);
                dict->put(key, value);
                pairFlag = false;
            }
            break;
        case '}':
            throw std::runtime_error("json_dict parse failed due to wrong JSON format (case '}')");
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
                        listIndex--;
                    }
                }
                else if (input[json_object::_index + index] == '[')
                {
                    listIndex++;
                }
                index++;
            }
            if (!pairFlag)
            {
                key = json_list::parse(input, index);
                pairFlag = true;
            }
            else
            {
                value = json_list::parse(input, index);
                dict->put(key, value);
                pairFlag = false;
            }
            break;
        case ']':
            throw std::runtime_error("json_dict parse failed due to wrong JSON format (case ']')");
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
            if (!pairFlag)
            {
                key = Integer::parse(input, index);
                pairFlag = true;
            }
            else
            {
                value = Integer::parse(input, index);
                dict->put(key, value);
                pairFlag = false;
            }
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
            if (!pairFlag)
            {
                key = String::parse(input, index, input[json_object::_index]);
                pairFlag = true;
            }
            else
            {
                value = String::parse(input, index, input[json_object::_index]);
                dict->put(key, value);
                pairFlag = false;
            }
            break;
        default:
            throw std::runtime_error("json_dict parse failed due to wrong JSON format (unknown char)");
        }
    }

    // Pair Check
    if (pairFlag)
        throw std::runtime_error("json_dict parse failed due to wrong JSON format (pair not made)");

    // JSON Format Validation
    if (input[json_object::_index] != '}')
        throw std::runtime_error("json_dict parse failed due to wrong JSON format (validation)");

    // Finalize
    json_object::_index++;

    // Debug
    // std::cout << "Dict Parse After : " << json_object::_index << std::endl;

    // Return
    return dict;
}

json_object *json_dict::operator[](json_object *key) const
{
    for (auto it = this->v.begin(); it != this->v.end(); it++)
        if (it->first == key)
            return it->second;
    return nullptr;
}
json_object *json_dict::operator[](const std::string &key) const
{
    for (auto it = this->v.begin(); it != this->v.end(); it++)
    {
        if (it->first->type() != json_object::_type::STRING)
            continue;
        if (((String *)(it->first))->val().compare(key) == 0)
        {
            return it->second;
        }
    }
    return nullptr;
}
json_object *json_dict::operator[](int key) const
{
    for (auto it = this->v.begin(); it != this->v.end(); it++)
    {
        if (it->first->type() != json_object::_type::INT)
            continue;
        if (((Integer *)(it->first))->val() == key)
            return it->second;
    }
    return nullptr;
}

json_object::_type json_dict::type() { return this->DICT; }
std::string json_dict::to_string()
{
    std::string str("{");
    int index;
    for (index = 0; index < (int)this->v.size(); index++)
    {
        str += this->v[index].first->to_string();
        str += ": ";
        str += this->v[index].second->to_string();
        if (index + 1 < (int)this->v.size())
            str += ", ";
    }
    str += "}";
    return str;
}