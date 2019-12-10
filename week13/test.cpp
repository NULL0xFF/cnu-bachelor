#include <iostream>
#include "lib/os.h"

int main(int argc, char *argv[])
{
    while(true)
    {
        switch(get_dir_key())
        {
        case KEYBOARD::UNDEFINED:
            std::cout << "UNDEFINED" << std::endl;
            break;
        case KEYBOARD::UP:
            std::cout << "UP" << std::endl;
            break;
        case KEYBOARD::DOWN:
            std::cout << "DOWN" << std::endl;
            break;
        case KEYBOARD::LEFT:
            std::cout << "LEFT" << std::endl;
            break;
        case KEYBOARD::RIGHT:
            std::cout << "RIGHT" << std::endl;
            break;
        case KEYBOARD::ROTATE_LEFT:
            std::cout << "LEFT ROTATION" << std::endl;
            break;
        case KEYBOARD::ROTATE_RIGHT:
            std::cout << "RIGHT ROTATION" << std::endl;
            break;
        case KEYBOARD::SPACE:
            std::cout << "SPACE" << std::endl;
            break;
        }
    }
}