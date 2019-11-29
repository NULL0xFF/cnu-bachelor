#ifndef OBJECT_HPP
#define OBJECT_HPP

#include <string>

#define _STRING_BLANK "."
#define _STRING_GRAY "※"
#define _STRING_RED "○"
#define _STRING_GREEN "□"
#define _STRING_BLUE "△"

class object
{
protected:
    enum _type
    {
        BLANK,
        GRAY,
        RED,
        GREEN,
        BLUE
    };

public:
    object();
    object::_type type();
    std::string to_string() const;
};

#endif // OBJECT_HPP