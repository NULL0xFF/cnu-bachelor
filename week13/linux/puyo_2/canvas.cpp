#include "../lib/os.h"
#include "canvas.hpp"

Canvas::Canvas(int nx, int ny)
{
    this->x_Max = nx;
    this->y_Max = ny;
    for (int y = 0; y < ny; y++)
        this->line[y] = std::string(nx * 2, ' ');
}

void Canvas::draw(int x, int y, std::string val)
{
    if (0 <= x && 0 <= y && x < this->x_Max && y < this->y_Max)
        this->line[y].replace(x * 2, 2, val);
}

void Canvas::clear(std::string val)
{
    for (int y = 0; y < this->y_Max; y++)
        for (int x = 0; x < this->x_Max; x++)
            this->draw(x, y, val);
}

void Canvas::print(const char *title)
{
    system(CLEAR);
    std::cout << title << std::endl;
    for (int y = 0; y < this->y_Max; y++)
        std::cout << this->line[y] << std::endl;
}