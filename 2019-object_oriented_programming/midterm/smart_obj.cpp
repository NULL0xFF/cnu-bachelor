#include "smart_obj.h"

namespace ptr
{
smart_obj::mgr *const smart_obj::empty_mgr = new smart_obj::mgr();
std::map<student *, smart_obj::mgr *> smart_obj::ptr_map;
smart_obj::smart_obj(){};
smart_obj::~smart_obj(){};
} // end of namespace ptr
