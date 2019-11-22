#include "json_dict.h"

/* Private */
/* Public */
json_object *json_dict::parse(const char *input, int length)
{
    json_dict *dict = new json_dict();
    int index = 1;
    int depth = 0;
    bool innerParseFlag = false;
    while (index < length)
    {
        switch (input[json_object::_index + index])
        {
        case ' ':
        case '\n':
        case '\r':
        case '\t':
            // WHITESPACE
            break;
        
        case '}':
            if (depth == 0)
                return dict;
        }
        index++;
    }
}