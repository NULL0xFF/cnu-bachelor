#include "json_list.h"

/* Private */
json_list::json_list() {}
/* Public */
json_object *json_list::parse(const char *input, int length)
{
    
}
json_object::_type json_list::type() { return this->LIST; }
std::string json_list::to_string()
{
}