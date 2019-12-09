#include <iostream>
#include <stdexcept>
#include "puyo.hpp"

int main(int argc, char *argv[])
{
    try
    {
        Puyo p(5, 12);
        p.start();
        while (p.status())
        {
            // Wait for thread's stop
            // Pulling status flag
        }
    }
    catch (std::exception &e)
    {
        std::cerr << e.what() << std::endl;
        exit(1);
    }
}