#ifndef PUYO_HPP
#define PUYO_HPP

#include <pthread.h>
#include <termios.h>
#include <unistd.h>
#include <atomic>
#include <chrono>
#include <cstdio>
#include <iostream>
#include <stdexcept>
#include <thread>
#include "visual.hpp"

class Puyo
{
private:
    std::thread *t_main, *t_input;
    Visual *canvas;
    bool isAlive;
    int width, height;

    void run();
    void input();
    void reset();

public:
    Puyo(int w, int h);
    ~Puyo() { reset(); }
    void start(void);
    void wait(void);
    int score(void) { return canvas->getScore(); }
};

#endif // PUYO_HPP