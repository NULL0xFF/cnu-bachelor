#ifndef PUYO_HPP
#define PUYO_HPP

#include <cstdlib>
#include <iostream>
#include <thread>
#include "lib/os.h"
#include "canvas.hpp"

class Puyo
{
private:
    std::thread _game;
    Canvas board;
    bool isAlive, isSynced, isInputed;
    int width, height;

    void run(void)
    {
        while (this->isAlive)
        {
            system(CLEAR);
            board.draw();
            SLEEP(1); // Update every 1 second
            board.update();
            if (!board.isUpdated())
                this->stop();
        }
    }
    void input(void)
    {
        while (this->isAlive)
        {
            if (kbhit() && !isInputed)
            {
                isInputed = true;
                switch (get_dir_key())
                {
                case KEYBOARD::UP:
                    break;
                case KEYBOARD::DOWN:
                    break;
                case KEYBOARD::LEFT:
                    break;
                case KEYBOARD::RIGHT:
                    break;
                case KEYBOARD::ROTATE_LEFT:
                    break;
                case KEYBOARD::ROTATE_RIGHT:
                    break;
                case KEYBOARD::SPACE:
                    break;
                case KEYBOARD::QUIT:
                    this->isAlive = false;
                    break;
                case KEYBOARD::UNDEFINED:
                    break;
                default:
                    throw std::runtime_error("unknown input error");
                }
            }
        }
    }

public:
    Puyo(int _width, int _height) : board(_width, _height)
    {
        this->width = _width;
        this->height = _height;
        this->isAlive = false;
    }
    void start(void)
    {
        // Check if thread is running
        if (this->isAlive)
            return;

        // Start thread
        this->isAlive = true;
        this->_game = std::thread(&Puyo::run, this);
    }
    void stop(void)
    {
        // Check if thread is dead
        if (!this->isAlive)
            return;

        // Stop thread
        this->isAlive = false;
        this->_game.detach();
    }
    bool status(void) { return this->_game.joinable(); }
};

#endif // PUYO_HPP