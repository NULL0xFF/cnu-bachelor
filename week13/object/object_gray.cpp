#include "object_gray.hpp"

object_gray::object_gray(const std::string str) : object(str)
{
    this->set_val(_OBJECT_GRAY);
}
object::_type object_gray::type() { return this->GRAY; }