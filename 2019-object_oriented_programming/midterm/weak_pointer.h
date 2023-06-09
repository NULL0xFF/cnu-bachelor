#ifndef SMART_PTR_WEAK_POINTER_H
#define SMART_PTR_WEAK_POINTER_H

#include "shared_ref.h"

namespace ptr
{
class weak_pointer : public smart_obj
{
private:
    student *ptr;

public:
    explicit weak_pointer();
    explicit weak_pointer(shared_ref &shared);
    weak_pointer(const weak_pointer &weak);

    int is_expired();
    student *get();
};
} // namespace ptr

#endif //SMART_PTR_WEAK_POINTER_H
