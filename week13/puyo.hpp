#ifndef PUYO_HPP
#define PUYO_HPP

#include <pthread.h>
#include <atomic>
#include <chrono>
#include <iostream>
#include <stdexcept>
#include <thread>
#include "os.h"
#include "visual.hpp"

class Puyo
{
private:
    std::thread *t_main, *t_input;
    Visual *canvas;
    bool isAlive;
    int width, height;

    void run()
    {
        // Main loop
        while (true)
        {
            // Update
            if (!canvas->update())
                break;
            // Output
            canvas->clear();
            canvas->draw();
            // Sleep
            std::this_thread::sleep_for(std::chrono::nanoseconds(1000000000));
        }

        // Exit thread
        isAlive = false;
        std::cout << "Press any key to quit" << std::endl;
    }
    void input()
    {
        // Main loop
        while (isAlive)
        {
            // Input
            int ch = kbhit();

            // Check condition
            if (!isAlive)
                break;

            // Case by Case
            switch (ch)
            {
            case 'A':
            case 'a':
                // Left
                canvas->move(-1, 0);
                break;
            case 'S':
            case 's':
                // Down
                canvas->move(0, 1);
                break;
            case 'D':
            case 'd':
                // Right
                canvas->move(1, 0);
                break;
            case 'Q':
            case 'q':
                // Anti-Clockwise rotation
                // canvas->rotation(-90);
                break;
            case 'E':
            case 'e':
                // Clockwise rotation
                // canvas->rotation(90);
                break;
            case 'X':
            case 'x':
                // Gravity
                canvas->gravity_max();
                canvas->update();
                break;
            case 27: // ESC, Exit the game
                isAlive = false;
                pthread_t pt_main = t_main->native_handle();
                t_main->detach();
                pthread_cancel(pt_main);
                break;
            }

            // Output
            canvas->clear();
            canvas->draw();
        }
    }
    void reset()
    {
        if (isAlive)
            std::runtime_error("thread is still running");

        if (canvas != nullptr)
            delete (canvas);
        canvas = new Visual(width, height);
        if (t_input != nullptr)
            delete (t_input);
    }

public:
    Puyo(int w, int h)
    {
        if (w < 3 || h < 3)
            std::runtime_error("game board size must be at least 3");
        width = w;
        height = h;
        canvas = nullptr;
        t_main = nullptr;
        t_input = nullptr;
    }
    ~Puyo() { reset(); }
    void start(void)
    {
        if (isAlive)
            std::runtime_error("thread is already running");

        // Run thread
        reset();
        isAlive = true;
        t_main = new std::thread(&Puyo::run, this);
        t_input = new std::thread(&Puyo::input, this);
    }
    void wait(void)
    {
        if (t_input->joinable())
            t_input->join();
        else
            std::runtime_error("thread is not joinable");
    }
    int score(void)
    {
        return canvas->getScore();
    }
};

#endif // PUYO_HPP