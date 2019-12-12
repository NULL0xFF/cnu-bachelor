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
    std::thread _game, _input;
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
                stop();
        }
    }
    void input(void)
    {
        while (this->isAlive)
        {
            switch (get_dir_key())
            {
            case KEYBOARD::UP:
                break;
            case KEYBOARD::DOWN:
                board.move(0, 1);
                break;
            case KEYBOARD::LEFT:
                board.move(-1, 0);
                break;
            case KEYBOARD::RIGHT:
                board.move(1, 0);
                break;
            case KEYBOARD::ROTATE_LEFT:
                board.rotate(-90);
                break;
            case KEYBOARD::ROTATE_RIGHT:
                board.rotate(90);
                break;
            case KEYBOARD::SPACE:
                board.gravity();
                while (board.isUpdated())
                    board.gravity();
                break;
            case KEYBOARD::QUIT:
                std::cout << "QUIT!!!" << std::endl;
                this->stop();
                break;
            case KEYBOARD::UNDEFINED:
                break;
            default:
                throw std::runtime_error("unknown input error");
            }
            if (!isAlive)
                break;
            system(CLEAR);
            board.draw();
        }
    }

public:
    Puyo(int _width, int _height) : board(_width, _height)
    {
        this->width = _width;
        this->height = _height;
        this->isAlive = false;
        this->isInputed = false;
    }
    void start(void)
    {
        // Check if thread is running
        if (this->isAlive)
            return;

        // Start thread
        this->isAlive = true;
        this->_game = std::thread(&Puyo::run, this);
        this->_input = std::thread(&Puyo::input, this);
    }
    void stop(void)
    {
        // Check if thread is dead
        if (!this->isAlive)
            return;

        // Stop thread
        this->isAlive = false;
        this->_input.detach();
        this->_game.detach();
    }
    bool status(void) { return this->_game.joinable(); }
};

#endif // PUYO_HPP