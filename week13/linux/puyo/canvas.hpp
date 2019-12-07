#ifndef CANVAS_HPP
#define CANVAS_HPP

#include <iostream>
#include <vector>
#include <string>
#include "../lib/os.h"
// #include "./block.hpp"

#define CANVAS_LEN 4

class Canvas
{
private:
    std::vector<std::string> line;
    int width, height;

public:
    explicit Canvas(int w, int h) : line(h)
    {
        this->width = w;
        this->height = h;
        for (int y = 0; y < h; y++)
        {
            this->line[y] = std::string(w * CANVAS_LEN, ' ');
            for (int x = 0; x < h; x++)
                this->line[y].replace(x * CANVAS_LEN, CANVAS_LEN, "□");
        }
        // this->line[y]
        // this->line[y] = std::string(w * CANVAS_LEN, ' ');
    }
    // void draw(int x, int y, Block &blk)
    // {
    //     if ((0 <= x) && (x < this->width) && (0 <= y) && (y < this->height))
    //         switch (blk.type())
    //         {
    //         case BlockType::BLANK:
    //             this->line[y].replace(x * 2, 2, "  ");
    //             break;
    //         case BlockType::RED:
    //             this->line[y].replace(x * 2, 2, "RE");
    //             break;
    //         case BlockType::GREEN:
    //             this->line[y].replace(x * 2, 2, "GR");
    //             break;
    //         case BlockType::BLUE:
    //             this->line[y].replace(x * 2, 2, "BL");
    //             break;
    //         case BlockType::GRAY:
    //             this->line[y].replace(x * 2, 2, "GY");
    //             break;
    //         default:
    //             throw std::runtime_error("undefined block type");
    //         }
    // }
    // void clear(std::string val = "  ")
    // {
    //     Block blk(BlockType::BLANK);
    //     for (int y = 0; y < this->height; y++)
    //         for (int x = 0; x < this->width; x++)
    //             this->draw(x, y, blk);
    // }
    void print(const char *title = "< My Canvas >")
    {
        if (system(CLEAR) != 0)
            throw std::runtime_error("terminal clear failed");
        std::cout << title << std::endl;

        // TOP FRAME
        for (int x = 0; x < this->width + 2; x++)
            std::cout << "■";
        std::cout << std::endl;

        // SIDE FRAME WITH ARRAY
        for (int y = 0; y < this->height; y++)
            std::cout << "■" << this->line[y] << "■" << std::endl;

        // BOTTOM FRAME
        for (int x = 0; x < this->width + 2; x++)
            std::cout << "■";
        std::cout << std::endl;
    }
};

#endif // CANVAS_HPP