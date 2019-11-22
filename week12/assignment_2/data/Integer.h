#ifndef INTEGER_H
#define INTEGER_H

#include "Object.h"

class Integer : public Object<int>
{
private:
    int _val;
    explicit Integer(int value);

public:
    int val();
    void set_val(const int &value);

    static json_object *parse(const char *, int length);
    _type type();
    std::string to_string();
};

#endif //INTEGER_H
