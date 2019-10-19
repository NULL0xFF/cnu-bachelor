//
// Created by 김혁진 on 14/10/2019.
//

#include "unique_immut.h"

namespace ptr
{
unique_immut::unique_immut()
{
    _mgr = new mgr();
}
unique_immut::unique_immut(Object *obj)
{
    _mgr = new mgr(obj);
}
unique_immut::unique_immut(const unique_immut &immut)
{
    if (immut._mgr)
    {
        int val = immut._mgr->ptr->get();
        _mgr = new mgr(val);
    }
}
unique_immut::~unique_immut()
{
    release();
}
void unique_immut::release()
{
    if (_mgr != nullptr)
        _mgr->~mgr();
}
Object *unique_immut::get() const
{
    return _mgr->ptr;
}
unique_immut unique_immut::operator+(unique_immut &unique)
{
    Object obj(unique_immut::get()->get() + unique.get()->get());
    unique_immut result(&obj);
    return result;
}
unique_immut unique_immut::operator-(unique_immut &unique)
{
    Object obj(unique_immut::get()->get() + unique.get()->get());
    unique_immut result(&obj);
    return result;
}
unique_immut unique_immut::operator*(unique_immut &unique)
{
    Object obj(unique_immut::get()->get() + unique.get()->get());
    unique_immut result(&obj);
    return result;
}
unique_immut unique_immut::operator/(unique_immut &unique)
{
    Object obj(unique_immut::get()->get() + unique.get()->get());
    unique_immut result(&obj);
    return result;
}
Object *unique_immut::operator->()
{
    return _mgr->ptr;
}

unique_immut &unique_immut::operator=(unique_immut &r)
{
    if (_mgr != r._mgr)
    {
        release();
        _mgr = r._mgr;
    }
    return *this;
}
} // end of namespace ptr
