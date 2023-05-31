#include <unistd.h>
#include <iostream>
#include "puyo.hpp"

int main(void)
{
    try
    {
        Puyo p(5, 12);
        p.start();
        p.wait();
        std::cout << std::endl
                  << "GAME OVER" << std::endl
                  << "Total Score : " << p.score() << std::endl;
    }
    catch (const std::exception &e)
    {
        std::cerr << e.what() << '\n';
    }

    return 0;
}