#include "json_dict.h"

// PUBLIC
json_dict::json_dict() {}
json_object *json_dict::parse(const char *input, int length)
{
    // TODO
}
json_object::_type json_dict::type() { return this->DICT; }
std::string json_dict::to_string()
{
    // TODO
}
// PRIVATE
void json_dict::put(json_object *key, json_object *val)
{
    int index = this->find(key);
    if (index == -1)
    {
        this->v.push_back(std::pair(key, val));
        return;
    }
    else
    {
        this->v[index].second = val;
        return;
    }
    throw new std::runtime_error("put() failed");
}
int json_dict::find(json_object *key)
{
    int index = 0;
    for (auto it = this->v.begin(); it != this->v.end(); it++)
    {
        if (it->first == key)
            return index;
        index++;
    }
    return -1;
}