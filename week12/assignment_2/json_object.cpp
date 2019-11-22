#include "json_object.h"

int json_object::_index = 0;

json_object *json_object::parse(const char *input, int length)
{
    
}
json_object *json_object::parse(const std::string &input)
{
    return json_object::parse(input.c_str(), input.length());
}