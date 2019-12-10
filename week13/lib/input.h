#ifndef INPUT_H
#define INPUT_H

enum Keyboard
{
    UNDEFINED,
    UP,
    DOWN,
    RIGHT,
    LEFT,
    QUIT
};

#ifdef _WIN32

#pragma warning(disable : 4996)

#include <conio.h>

int get_dir_key(void)
{
    unsigned int i = getch();
    unsigned int j;
    switch (i)
    {
    case 'Q':
    case 'q':
        return Keyboard::QUIT;
    case 224:
        j = getch();
        switch (j)
        {
        case 75:
            return Keyboard::LEFT;
        case 77:
            return Keyboard::RIGHT;
        case 72:
            return Keyboard::UP;
        case 80:
            return Keyboard::DOWN;
        }
    }
    return Keyboard::UNDEFINED;
}
#elif __linux__

#include "linux/getch.h"

Keyboard get_dir_key(void)
{
    char c = '\0';
    c = getch();
    switch (c)
    {
    case 27:
        c = getch();
        switch (c)
        {
        case 91:
            c = getch();
            switch (c)
            {
            case (int)'D':
                return Keyboard::LEFT;
            case (int)'C':
                return Keyboard::RIGHT;
            case (int)'A':
                return Keyboard::UP;
            case (int)'B':
                return Keyboard::DOWN;
            }
        }
        break;
    case 'Q':
    case 'q':
        return Keyboard::QUIT;
    }
    return Keyboard::UNDEFINED;
}
#endif

#endif // GET_DIR_KEY_H