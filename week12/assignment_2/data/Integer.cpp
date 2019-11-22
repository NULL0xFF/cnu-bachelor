#include "Integer.h"

Integer::Integer(int value) { this->_val = value; }
int Integer::val() { return this->_val; }
void Integer::set_val(const int &value) { this->_val = value; }
json_object *Integer::parse(const char *input, int length)
{
    // TODO Implement Parse Here
}
json_object::_type Integer::type() { return this->INT; }
std::string Integer::to_string() { return std::to_string(this->_val); }