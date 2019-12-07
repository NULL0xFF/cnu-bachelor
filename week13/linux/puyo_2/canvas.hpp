#ifndef CANVAS_HPP
#define CANVAS_HPP

#include <iostream>
#include <vector>
#include <string>

class Canvas
{
private:
    std::vector<std::string> line;
    int x_Max, y_Max;

public:
    explicit Canvas(int nx, int ny);
    void draw(int x, int y, std::string val);
    void clear(std::string val = "  ");
    void print(const char *title = "<My Canvas>");
};

#endif // CANVAS_HPP