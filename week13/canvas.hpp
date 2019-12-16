#ifndef CANVAS_HPP
#define CANVAS_HPP

#include "block.hpp"

class Canvas
{
private:
    Block ***array;
    int width, height;

public:
    Canvas(int w, int h)
    {
        width = w;
        height = h;
        array = new Block **[height];
        for (int y = 0; y < height; y++)
        {
            array[y] = new Block *[width];
            for (int x = 0; x < width; x++)
                array[y][x] = new Block();
        }
    }
    Block *get(int x, int y) { return array[y][x]; }
    void put(int x, int y, Block *blk) { array[y][x] = blk; }
    void remove(int x, int y) { delete static_cast<Block *>(array[y][x]); }
    void swap(int x1, int y1, int x2, int y2)
    {
        Block *blk = array[y1][x1];
        array[y1][x1] = array[y2][x2];
        array[y2][x2] = blk;
        blk = nullptr;
    }
};

#endif // CANVAS_HPP