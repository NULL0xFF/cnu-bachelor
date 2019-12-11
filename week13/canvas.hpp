#ifndef CANVAS_HPP
#define CANVAS_HPP

#include <time.h>
#include <iostream>
#include <random>
#include <stdexcept>
#include <vector>
#include "block.hpp"
#include "group.hpp"

class Canvas
{
private:
    std::random_device rd;
    std::mt19937_64 rnd;
    std::uniform_int_distribution<long long int> blockTypeDist;
    Block ***blkArray;
    Group *blkGroup;
    bool updated;
    int width, height, second, score;

    bool isMovable(int x, int y, int dx, int dy)
    {
        if (x < 0 || width <= x)
            return false;
        else if (y < 0 || height <= y)
            return false;

        if (x + dx < 0 || width <= x + dx)
            return false;
        else if (y + dy < 0 || height <= y + dy)
            return false;

        if (blkArray[y + dy][x + dx] == nullptr)
            return true;
        else if (blkArray[y + dy][x + dx]->getType() != Block::Type::Blank)
            return false;

        return true;
    }
    void create(void)
    {
        if (updated)
            return;
        for (int y = 0; y < 3; y++)
            if (blkArray[y][width / 2]->getType() != Block::Type::Blank)
                return;
        if (blkGroup != nullptr)
            delete (blkGroup);
        blkGroup = new TreeGroup(blkArray, width, height);
        updated = true;
    }

public:
    Canvas(int _width, int _height) : width(_width), height(_height), second(0), score(0), updated(false), rd(), rnd(rd()), blockTypeDist(1, 4)
    {
        blkGroup = nullptr;
        blkArray = new Block **[height];
        for (int y = 0; y < height; y++)
        {
            blkArray[y] = new Block *[width];
            for (int x = 0; x < width; x++)
                blkArray[y][x] = new Block();
        }
    }
    void update(void)
    {
        updated = false;
        for (int y = height - 1; y >= 0; y--)
            for (int x = 0; x < width; x++)
                if (blkArray[y][x]->getType() != Block::Type::Blank)
                    if (isMovable(x, y, 0, 1))
                    {
                        delete (blkArray[y + 1][x]);
                        blkArray[y + 1][x] = blkArray[y][x];
                        blkArray[y][x] = new Block();
                        updated = true;
                    }
        if (!updated)
            create();
        second++;
    }
    bool isUpdated(void) { return this->updated; }
    void draw(void)
    {
        std::cout << "Time:\t" << second << "\tScore:\t" << score << std::endl;
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
                std::cout << blkArray[y][x]->toString() << '\t';
            std::cout << std::endl;
        }
    }
    const int getWidth(void) { return this->width; }
    const int getHeight(void) { return this->height; }
};

#endif // CANVAS_HPP