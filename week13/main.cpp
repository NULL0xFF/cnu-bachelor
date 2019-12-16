#include <unistd.h>
#include <iostream>
#include "visual.hpp"

int main(void)
{
    Visual v(10, 10);
    while (true)
    {
        if(!v.update())
            break;
        v.draw();
        v.move(-1,0);
        sleep(1);
    }

    return 0;
}