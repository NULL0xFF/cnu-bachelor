#ifndef PUYO_HPP
#define PUYO_HPP

#pragma warning(disable : 4996)

#include <Windows.h>
#include <conio.h>
#include <cstdlib>
#include <iostream>
#include <thread>
#include "canvas.hpp"

#define SLEEP(x) Sleep(x * 1000)

class Puyo
{
private:
    std::thread _game;
    Canvas board;
    bool isAlive;
    int width, height;

    void run(void)
    {
        while (this->isAlive)
        {
            system("cls");
            board.draw();
            SLEEP(1); // Update every second
            board.update();
            if (!board.isUpdated())
                this->stop();
        }
    }
    void input(void)
    {
        while (this->isAlive)
        {
            if (kbhit())
            {
                char ch = (getch() == 224) ? getch() : 0;
                switch (static_cast<Direction>(ch))
                {
                case Direction::Up:
                    break;
                case Direction::Down:
                    break;
                case Direction::Left:
                    break;
                case Direction::Right:
                    break;
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
        // Running
        if (this->isAlive)
            return;

        // Start thread
        this->isAlive = true;
        this->_game = std::thread(&Puyo::run, this);
    }
    void stop(void)
    {
        // Already stopped
        if (!this->isAlive)
            return;

        // Stop thread
        this->isAlive = false;
        this->_game.detach();
    }
    bool status(void) { return this->_game.joinable(); }
};

#endif // PUYO_HPP