#ifndef STRING_H
#define STRING_H

#include "Object.h"

class String : public Object<std::string>
{
private:
    std::string _val;

    explicit String(const std::string &str);

public:
    static json_object *parse(const char *, int length, char base);

    std::string val();
    void set_val(const std::string &str);

    _type type();
    std::string to_string();
};

#endif //STRING_H
