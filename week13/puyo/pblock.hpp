#ifndef PBLOCK_HPP
#define PBLOCK_HPP

#include "../lib/os.h"

class pblock
{
public:
    int getDirKey()
    {
        #ifdef _WIN32
        return getche() == 224 ? getch() : 0;
        #elif __linux__
        return GETCH_ARROW();
        #endif
    }
}

#endif // PBLOCK_HPP