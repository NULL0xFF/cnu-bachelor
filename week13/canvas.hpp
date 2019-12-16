#ifndef CANVAS_HPP
#define CANVAS_HPP

#include "block.hpp"

class Canvas
{
private:
    Block ***array;
    int width, height;

public:
    Canvas(int w, int h);
    Block *get(int x, int y);
    void put(int x, int y, Block *blk);
    void remove(int x, int y);
    void swap(int x1, int y1, int x2, int y2);
};

#endif // CANVAS_HPP