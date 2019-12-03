#include <iostream>
#include "lib/os.hpp"

int main(int argc, char *argv[])
{
    /* OS COMPATIBILITY CHECK */
#ifdef THROW
    try
    {
        throw std::runtime_error(THROW_MESSAGE);
    }
    catch (const std::exception &e)
    {
        std::cerr << e.what() << std::endl;
    }
    exit(1);
#endif
    /* END OF OS CHECK */

    bool flag = true;
    while (flag)
    {
        switch (getch_key())
        {
        case UP:
            std::cout << "↑" << std::endl;
            break;
        case DOWN:
            std::cout << "↓" << std::endl;
            break;
        case RIGHT:
            std::cout << "→" << std::endl;
            break;
        case LEFT:
            std::cout << "←" << std::endl;
            break;
        case QUIT:
            flag = false;
        }
    }

    // END OF MAIN FUNCTION
    return 0;
}