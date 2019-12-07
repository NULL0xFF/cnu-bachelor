#ifndef OS_H
#define OS_H

#ifdef _WIN32 // Defined on Windows

#include <Windows.h>
#include "get_dir_key.h"

#define CLEAR "cls"
#define SLEEP(x) Sleep(x * 1000)

#elif __linux__ // Defined on Linux

#include <unistd.h>
#include "get_dir_key.h"
#include "linux/kbhit.h"

#define CLEAR "clear"
#define SLEEP(x) sleep(x)

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