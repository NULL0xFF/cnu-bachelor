//
// Created by 김혁진 on 14/10/2019.
//

#include "shared_mut.h"

namespace ptr
{
shared_mut::shared_mut()
{
    _mgr = new mgr();
}

shared_mut::shared_mut(Object *_obj)
{
    _mgr = new mgr(_obj);
}

shared_mut::shared_mut(const shared_mut &r)
{
    if (r._mgr)
    {
        _mgr = r._mgr;
        this->increase();
    }
}

shared_mut::~shared_mut()
{
    release();
}

void shared_mut::increase()
{
    _mgr->count++;
}

Object *shared_mut::get() const
{
    return _mgr->ptr;
}

void shared_mut::release()
{
    _mgr->count--;
    if (_mgr->count <= 0)
        _mgr->~mgr();
    _mgr = new mgr();
}

int shared_mut::count()
{
    return _mgr->count;
}

shared_mut shared_mut::operator+(const shared_mut &shared)
{
    return shared_mut(new Object(get()->get() + shared.get()->get()));
}

shared_mut shared_mut::operator-(const shared_mut &shared)
{
    return shared_mut(new Object(this->get()->get() - shared.get()->get()));
}

shared_mut shared_mut::operator*(const shared_mut &shared)
{
    return shared_mut(new Object(this->get()->get() * shared.get()->get()));
}

shared_mut shared_mut::operator/(const shared_mut &shared)
{
    return shared_mut(new Object(this->get()->get() / shared.get()->get()));
}

Object *shared_mut::operator->()
{
    return _mgr->ptr;
}

shared_mut &shared_mut::operator=(const shared_mut &r)
{
    release();
    _mgr = r._mgr;
    increase();
    return *this;
}

} // end of namespace ptr
