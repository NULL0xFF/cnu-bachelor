#include <iostream>
#include <stdexcept>
#include "lib/os.h"
#include "puyo.hpp"

int main(int argc, char *argv[])
{
    try
    {
        Puyo p(5, 12);
        p.start();
        while (p.status())
            continue; // Wait for the game to be stopped
    }
    catch (const std::exception &e)
    {
        std::cerr << e.what() << '\n';
    }
}