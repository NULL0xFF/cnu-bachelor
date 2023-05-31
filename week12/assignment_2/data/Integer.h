#ifndef INTEGER_H
#define INTEGER_H

#include "Object.h"

class Integer : public Object<int>
{
private:
    int _val;

    explicit Integer(int value);

public:
    static json_object *parse(const char *, int length);

    int val();
    void set_val(const int &value);

    _type type();
    std::string to_string();
};

#endif //INTEGER_H
