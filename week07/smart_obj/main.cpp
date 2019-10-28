#include <iostream>
#include "smart_ptr/object.h"
#include "smart_ptr/shared_mut.h"

using namespace ptr;

int main()
{
    std::cout << "Shared Mutable Pointer" << std::endl;
    {
        shared_mut p(new Object(10));
        std::cout << "shared_mut (" << &p << ") | ptr (" << p.get() << ") | value (" << p->get() << ") | count (" << p.count() << ")" << std::endl;

        shared_mut q(new Object(2));
        std::cout << "shared_mut (" << &q << ") | ptr (" << q.get() << ") | value (" << q->get() << ") | count (" << q.count() << ")" << std::endl;

        shared_mut r = p + q;
        std::cout << "shared_mut (" << &r << ") | ptr (" << r.get() << ") | value (" << r->get() << ") | count (" << r.count() << ")" << std::endl;

        shared_mut s = p - q;
        std::cout << "shared_mut (" << &s << ") | ptr (" << s.get() << ") | value (" << s->get() << ") | count (" << s.count() << ")" << std::endl;

        shared_mut t = p * q;
        std::cout << "shared_mut (" << &t << ") | ptr (" << t.get() << ") | value (" << t->get() << ") | count (" << t.count() << ")" << std::endl;

        shared_mut u = p / q;
        std::cout << "shared_mut (" << &u << ") | ptr (" << u.get() << ") | value (" << u->get() << ") | count (" << u.count() << ")" << std::endl;

        shared_mut v, w, x;
        v = p;
        std::cout << "shared_mut (" << &v << ") | ptr (" << v.get() << ") | value (" << v->get() << ") | count (" << v.count() << ")" << std::endl;
        w = p;
        std::cout << "shared_mut (" << &w << ") | ptr (" << w.get() << ") | value (" << w->get() << ") | count (" << w.count() << ")" << std::endl;
        x = q;
        std::cout << "shared_mut (" << &x << ") | ptr (" << x.get() << ") | value (" << x->get() << ") | count (" << x.count() << ")" << std::endl;
    }
    std::cout << "\n\nUnique Immutable Pointer" << std::endl;
    {
        unique_immut p(new Object(10));
        std::cout << "unique_immut (" << &p << ") | ptr (" << p.get() << ") | value (" << p->get() << ")" << std::endl;

        unique_immut q(new Object(2));
        std::cout << "unique_immut (" << &q << ") | ptr (" << q.get() << ") | value (" << q->get() << ")" << std::endl;

        unique_immut r = p + q;
        std::cout << "unique_immut (" << &p << ") | ptr (" << p.get() << ")" << std::endl;
        std::cout << "unique_immut (" << &q << ") | ptr (" << q.get() << ")" << std::endl;
        std::cout << "unique_immut (" << &r << ") | ptr (" << r.get() << ") | value (" << r->get() << ")" << std::endl;

        unique_immut s(new Object(5));
        std::cout << "unique_immut (" << &s << ") | ptr (" << s.get() << ") | value (" << s->get() << ")" << std::endl;

        unique_immut t(new Object(4));
        std::cout << "unique_immut (" << &t << ") | ptr (" << t.get() << ") | value (" << t->get() << ")" << std::endl;

        unique_immut u = s * t;
        std::cout << "unique_immut (" << &s << ") | ptr (" << s.get() << ")" << std::endl;
        std::cout << "unique_immut (" << &t << ") | ptr (" << t.get() << ")" << std::endl;
        std::cout << "unique_immut (" << &u << ") | ptr (" << u.get() << ") | value (" << u->get() << ")" << std::endl;

        unique_immut v;
        v = r;
        std::cout << "unique_immut (" << &r << ") | ptr (" << r.get() << ")" << std::endl;
        std::cout << "unique_immut (" << &v << ") | ptr (" << v.get() << ") | value (" << v->get() << ")" << std::endl;
    }
    return 0;
}