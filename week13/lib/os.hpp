#ifndef OS_HPP
#define OS_HPP

#ifdef _WIN32 // Windows Environment

#include <Windows.h>

#define SLEEP(x) Sleep(x * 1000)
#define CLEAR "cls"

#elif __linux__ // Linux Environment

#include <unistd.h>
#include "getch.h"

#define SLEEP(x) sleep
#define CLEAR "clear"

#endif // OS Environment

#endif // OS_HPP