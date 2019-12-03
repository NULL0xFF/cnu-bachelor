#ifndef OS_HPP
#define OS_HPP

#ifdef _WIN32 // Defined on Windows

#pragma warning(disable : 4996)

#include <Windows.h>
#include <conio.h>

#define CLEAR "cls"
#define SLEEP(x) Sleep(x * 1000)
#define GETCH_ARROW() getch() == 224 ? (getch()) : 0

enum KeyboardArrow
{
    LEFT = 75,
    RIGHT = 77,
    UP = 72,
    DOWN = 80
};

#elif __linux__ // Defined on Linux

#include <stdio.h>
#include <unistd.h>
#include <termios.h>

#include <iostream>
#include <string>

#define CLEAR "clear"
#define SLEEP(x) sleep(x)
#define GETCH_ARROW() getch() == 27 ? (getch() == 91 ? (getch()) : 0) : 0

enum Keyboard
{
    UNDEFINED,
    UP,
    DOWN,
    RIGHT,
    LEFT,
    QUIT
};

char getch(void)
{
    char buf = 0;
    struct termios old = {0};
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
    // printf("%c\n", buf);
    return buf;
}

int getch_key(void)
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
            case 'D':
                return Keyboard::LEFT;
            case 'C':
                return Keyboard::RIGHT;
            case 'A':
                // return "↑";
                return Keyboard::UP;
            case 'B':
                // return "↓";
                return Keyboard::DOWN;
            }
        }
    case 'Q':
    case 'q':
        return Keyboard::QUIT;
    }
    return Keyboard::UNDEFINED;
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

#endif // OS_HPP