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

shared_mut::~shared_mut()
{
    release();
}
void shared_mut::release()
{
    _mgr->count = _mgr->count - 1;
    if (_mgr->count == 0)
        _mgr->~mgr();
}
Object *shared_mut::get() const
{
    return _mgr->ptr;
}
int shared_mut::count()
{
    return _mgr->count;
}
void shared_mut::increase()
{
    _mgr->count = _mgr->count + 1;
}

shared_mut shared_mut::operator+(const shared_mut &shared)
{
    return shared_mut(new Object(this->get()->get() + shared.get()->get()));
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
    return this->_mgr->ptr;
}
shared_mut &shared_mut::operator=(const shared_mut &r)
{
    shared_mut::release();
    this->_mgr = r._mgr;
    shared_mut::increase();
}
} // end of namespace ptr
