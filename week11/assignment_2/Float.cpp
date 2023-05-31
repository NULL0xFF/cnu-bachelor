#include "Float.h"
#include "Integer.h"
#include "Complex.h"

double Float::parse_string(std::string str)
{
    double result = atof(str.c_str());
    return result;
}
Float::Float() { this->value = 0; }
Float::Float(double _value) { this->value = _value; }
Float::Float(const std::string &str) { this->value = this->parse_string(str); }
Number *Float::add(Number *num)
{
    if (num->types() == INTEGER)
    {
        Integer *num_i = dynamic_cast<Integer *>(num);
        this->value = this->value + (double)num_i->val();
        delete (num_i);
        return this;
    }
    else if (num->types() == FLOAT)
    {
        Float *num_f = dynamic_cast<Float *>(num);
        this->value = this->value + num_f->val();
        delete (num_f);
        return this;
    }
    else if (num->types() == COMPLEX)
    {
        Complex *num_c = dynamic_cast<Complex *>(num);
        num_c->set_val(this->value + num_c->real(), num_c->imag());
        delete (this);
        return num_c;
    }
    return nullptr;
}
Number *Float::sub(Number *num)
{
    if (num->types() == INTEGER)
    {
        Integer *num_i = dynamic_cast<Integer *>(num);
        this->value = this->value - (double)num_i->val();
        delete (num_i);
        return this;
    }
    else if (num->types() == FLOAT)
    {
        Float *num_f = dynamic_cast<Float *>(num);
        this->value = this->value - num_f->val();
        delete (num_f);
        return this;
    }
    else if (num->types() == COMPLEX)
    {
        Complex *num_c = dynamic_cast<Complex *>(num);
        num_c->set_val(this->value - num_c->real(), 0 - num_c->imag());
        delete (this);
        return num_c;
    }
    return nullptr;
}
Number *Float::mul(Number *num)
{
    /**
     * this->value * num->value // num의 value는 private 이므로 호출 불가능 (단순 개념 설명임)
     * this의 값과 parameter로 들어온 num의 value를 곱하는 함수
     */
    if (num->types() == INTEGER)
    {
        Integer *num_i = dynamic_cast<Integer *>(num);
        this->value = this->value * (double)num_i->val();
        delete (num_i);
        return this;
    }
    else if (num->types() == FLOAT)
    {
        Float *num_f = dynamic_cast<Float *>(num);
        this->value = this->value * num_f->val();
        delete (num_f);
        return this;
    }
    else if (num->types() == COMPLEX)
    {
        Complex *num_c = dynamic_cast<Complex *>(num);
        num_c->set_val(this->value * num_c->real(), this->value * num_c->imag());
        delete (this);
        return num_c;
    }
    return nullptr;
}
Number *Float::div(Number *num)
{
    if (num->types() == INTEGER)
    {
        Integer *num_i = dynamic_cast<Integer *>(num);
        this->value = this->value / (double)num_i->val();
        delete (num_i);
        return this;
    }
    else if (num->types() == FLOAT)
    {
        Float *num_f = dynamic_cast<Float *>(num);
        this->value = this->value / num_f->val();
        delete (num_f);
        return this;
    }
    else if (num->types() == COMPLEX)
    {
        Complex *num_c = dynamic_cast<Complex *>(num);
        num_c->set_val(this->value / num_c->real(), this->value / num_c->imag());
        delete (this);
        return num_c;
    }
    return nullptr;
}
void Float::set_val(double val) { this->value = val; }
double Float::val() const { return this->value; }
Number::type Float::types() const { return this->FLOAT; }
std::string Float::to_string() const { return std::to_string(value); }
