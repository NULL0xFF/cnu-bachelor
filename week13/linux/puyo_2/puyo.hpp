#ifndef PUYO_HPP
#define PUYO_HPP

#include <vector>
#include "../lib/os.h"
#include "canvas.hpp"
#include "block.hpp"
#include "pblock.hpp"

class Puyo
{
private:
    std::vector<std::vector<Block *>> world;

    PBlock *pBlk;
    Canvas *canvas;

    int x_Max, y_Max;
    bool isAlive;

    Block *Map(int x, int y) { return world[y][x]; }
    bool isDone(void) { return isAlive; }
    void print(void)
    {
        this->canvas->clear();
        for (int y = 0; y < this->y_Max; y++)
        {
            for (int x = 0; x < this->x_Max; x++)
            {
                switch (Map(x, y)->type())
                {
                case Block::BlockType::BLANK:
                    this->canvas->draw(x, y, "  ");
                    break;
                case Block::BlockType::RED:
                    this->canvas->draw(x, y, "RE");
                    break;
                case Block::BlockType::GREEN:
                    this->canvas->draw(x, y, "GR");
                    break;
                case Block::BlockType::BLUE:
                    this->canvas->draw(x, y, "BL");
                    break;
                }
            }
        }
        pBlk->draw(canvas);
    }

public:
    Puyo(int width, int height);
    ~Puyo()
    {
        for (int y = 0; y < this->y_Max; y++)
        {
            for (int x = 0; x < this->x_Max; x++)
            {
                delete this->world[y][x];
            }
        }
        delete pBlk;
        delete canvas;
    }
    void add(PBlock *altPBlk) {
        
        this->pBlk = altPBlk;
    }
};

#endif // PUYO_HPP