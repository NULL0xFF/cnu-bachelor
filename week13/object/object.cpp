#include "object.hpp"

object::object() {}
object::_type object::type() { return this->BLANK; }
std::string object::to_string() const
{
    return _STRING_BLANK;
}