#ifdef __linux__

#ifndef LINUX_KBHIT_H
#define LINUX_KBHIT_H

#include <stdio.h>
#include <termios.h>
#include <unistd.h>

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

#endif // LINUX_KBHIT_H

#endif