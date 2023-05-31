#include "Integer.h"
#include "Float.h"
#include "Complex.h"

int Integer::parse_string(const std::string &str)
{
    int result = atoi(str.c_str());
    return result;
}
Integer::Integer() { this->value = 0; }
Integer::Integer(int _value) { this->value = _value; }
Integer::Integer(const std::string &str) { this->value = this->parse_string(str); }
Number *Integer::add(Number *num)
{
    if (num->types() == INTEGER)
    {
        Integer *num_i = dynamic_cast<Integer *>(num);
        this->value = this->value + num_i->val();
        delete (num_i);
        return this;
    }
    else if (num->types() == FLOAT)
    {
        Float *num_f = dynamic_cast<Float *>(num);
        num_f->set_val((double)this->value + num_f->val());
        delete (this);
        return num_f;
    }
    else if (num->types() == COMPLEX)
    {
        Complex *num_c = dynamic_cast<Complex *>(num);
        num_c->set_val((double)this->value + num_c->real(), num_c->imag());
        delete (this);
        return num_c;
    }
    return nullptr;
}
Number *Integer::sub(Number *num)
{
    if (num->types() == INTEGER)
    {
        Integer *num_i = dynamic_cast<Integer *>(num);
        this->value = this->value - num_i->val();
        delete (num_i);
        return this;
    }
    else if (num->types() == FLOAT)
    {
        Float *num_f = dynamic_cast<Float *>(num);
        num_f->set_val((double)this->value - num_f->val());
        delete (this);
        return num_f;
    }
    else if (num->types() == COMPLEX)
    {
        Complex *num_c = dynamic_cast<Complex *>(num);
        num_c->set_val((double)this->value - num_c->real(), 0 - num_c->imag());
        delete (this);
        return num_c;
    }
    return nullptr;
}

Number *Integer::mul(Number *num)
{
    if (num->types() == INTEGER)
    {
        Integer *num_i = dynamic_cast<Integer *>(num);
        this->value = (int)(this->value * num_i->val());
        delete (num_i);
        return this;
    }
    else if (num->types() == FLOAT)
    {
        Float *num_f = dynamic_cast<Float *>(num);
        num_f->set_val((double)this->value * num_f->val());
        delete (this);
        return num_f;
    }
    else if (num->types() == COMPLEX)
    {
        Complex *num_c = dynamic_cast<Complex *>(num);
        num_c->set_val((double)this->value * num_c->real(), (double)this->value * num_c->imag());
        delete (this);
        return num_c;
    }
    return nullptr;
}

Number *Integer::div(Number *num)
{
    if (num->types() == INTEGER)
    {
        Integer *num_i = dynamic_cast<Integer *>(num);
        this->value = (int)((double)this->value / (double)num_i->val());
        delete (num_i);
        return this;
    }
    else if (num->types() == FLOAT)
    {
        Float *num_f = dynamic_cast<Float *>(num);
        num_f->set_val((double)this->value / num_f->val());
        delete (this);
        return num_f;
    }
    else if (num->types() == COMPLEX)
    {
        Complex *num_c = dynamic_cast<Complex *>(num);
        num_c->set_val((double)this->value / num_c->real(), (double)this->value / num_c->imag());
        delete (this);
        return num_c;
    }
    return nullptr;
}
void Integer::set_val(int val) { this->value = val; }
int Integer::val() const { return this->value; }
Number::type Integer::types() const { return this->INTEGER; }
std::string Integer::to_string() const { return std::to_string(value); }