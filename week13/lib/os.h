#ifndef OS_H
#define OS_H

enum KEYBOARD
{
    UNDEFINED,
    UP,
    DOWN,
    LEFT,
    RIGHT,
    ROTATE_LEFT,
    ROTATE_RIGHT,
    SPACE,
    QUIT
};

#ifdef _WIN32 // Defined on Windows

#pragma warning(disable : 4996)

#include <Windows.h>
#include <conio.h>

#define CLEAR "cls"
#define SLEEP(x) Sleep(x * 1000)

KEYBOARD get_dir_key()
{
    switch (getch())
    {
    case 'Q':
    case 'q':
        return KEYBOARD::ROTATE_LEFT;
    case 'E':
    case 'e':
        return KEYBOARD::ROTATE_RIGHT;
    case 224:
        switch (getch())
        {
        case 72:
            return KEYBOARD::UP;
        case 80:
            return KEYBOARD::DOWN;
        case 75:
            return KEYBOARD::LEFT;
        case 77:
            return KEYBOARD::RIGHT;
        default:
            return KEYBOARD::UNDEFINED;
        }
    default:
        return KEYBOARD::UNDEFINED;
    }
}

#elif __linux__ // Defined on Linux

#include <stdio.h>
#include <unistd.h>
#include <termios.h>

#define CLEAR "clear"
#define SLEEP(x) sleep(x)

char getch(void)
{
    char buf = 0;
    struct termios old;
    fflush(stdout);
    if (tcgetattr(0, &old) < 0)
        perror("tcsetattr()");
    old.c_lflag &= ~ICANON;
    old.c_lflag &= ~ECHO;
    old.c_cc[VMIN] = 1;
    old.c_cc[VTIME] = 0;
    if (tcsetattr(0, TCSANOW, &old) < 0)
        perror("tcsetattr ICANON");
    if (read(0, &buf, 1) < 0)
        perror("read()");
    old.c_lflag |= ICANON;
    old.c_lflag |= ECHO;
    if (tcsetattr(0, TCSADRAIN, &old) < 0)
        perror("tcsetattr ~ICANON");
    return buf;
}

int kbhit(void)
{
    struct termios oldt, newt;
    int ch;
    tcgetattr(STDIN_FILENO, &oldt);
    newt = oldt;
    newt.c_lflag &= ~(ICANON | ECHO);
    tcsetattr(STDIN_FILENO, TCSANOW, &newt);
    ch = getchar();
    tcsetattr(STDIN_FILENO, TCSANOW, &oldt);
    return ch;
}

KEYBOARD get_dir_key()
{
    switch (getch())
    {
    case 'A':
    case 'a':
        return KEYBOARD::LEFT;
    case 'S':
    case 's':
        return KEYBOARD::DOWN;
    case 'D':
    case 'd':
        return KEYBOARD::RIGHT;
    case 'Q':
    case 'q':
        return KEYBOARD::ROTATE_LEFT;
    case 'E':
    case 'e':
        return KEYBOARD::ROTATE_RIGHT;
    case 27:
        switch (getch())
        {
        case 27:
            return KEYBOARD::QUIT;
        case 91:
            switch (getch())
            {
            case 65:
                return KEYBOARD::UP;
            case 66:
                return KEYBOARD::DOWN;
            case 68:
                return KEYBOARD::LEFT;
            case 67:
                return KEYBOARD::RIGHT;
            default:
                return KEYBOARD::UNDEFINED;
            }
        default:
            return KEYBOARD::UNDEFINED;
        }
    case 32:
    case 'X':
    case 'x':
        return KEYBOARD::SPACE;
    default:
        return KEYBOARD::UNDEFINED;
    }
}

#elif __sun // Defined on Solaris
#define THROW
#define THROW_MESSAGE "solaris is not supported"
#elif __FreeBSD__ // Defined on FreeBSD
#define THROW
#define THROW_MESSAGE "freebsd is not supported"
#elif __NetBSD__ // Defined on NetBSD
#define THROW
#define THROW_MESSAGE "netbsd is not supported"
#elif __OpenBSD__ // Defined on OpenBSD
#define THROW
#define THROW_MESSAGE "openbsd is not supported"
#elif __APPLE__ // Defined on Mac OS X
#define THROW
#define THROW_MESSAGE "mac os x is not supported"
#elif __hpux // Defined on HP - UX
#define THROW
#define THROW_MESSAGE "hp - ux is not supported"
#elif __osf__ // Defined on Tru64 UNIX(formerly DEC OSF1)
#define THROW
#define THROW_MESSAGE "tru64 unix is not supported"
#elif __sgi // Defined on Irix
#define THROW
#define THROW_MESSAGE "irix is not supported"
#elif _AIX // Defined on AIX
#define THROW
#define THROW_MESSAGE "aix is not supported"
#endif

#endif // OS_H