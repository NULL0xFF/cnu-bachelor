#ifndef OBJECT_GRAY_HPP
#define OBJECT_GRAY_HPP

#include "object.hpp"

class object_gray : public object
{
public:
    object_gray();
    object::_type type();
    std::string to_string() const;
};

#endif // OBJECT_GRAY_HPP