#ifndef CANVAS_HPP
#define CANVAS_HPP

#include <time.h>
#include <random>
#include <stdexcept>
#include <vector>
#include "block.hpp"

enum class Direction
{
    Up = 72,
    Down = 80,
    Left = 75,
    Right = 77
};

class Group;

class Canvas
{
private:
    std::mt19937_64 rnd;
    std::uniform_int_distribution<_int64> blockSizeDist;
    std::random_device rd;
    std::uniform_int_distribution<_int64> blockTypeDist;
    Block ***blkArray;
    Group *control;
    int width, height, second, score;
    bool updated;

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
        bool flag = true;
        for (int y = 0; y < 3; y++)
            if (blkArray[y][width / 2]->getType() != Block::Type::Blank)
                flag = false;
        if (flag && !updated)
        {
            std::cout << "Create a Group here!" << std::endl;
            // delete (control);
            // switch (static_cast<Group::Type>(this->blockTypeDist(rnd)))
            // {
            // case Group::Type::Fold:
            //     // break;
            // case Group::Type::Cross:
            //     // break;
            // case Group::Type::Tree:
            //     this->control = new TreeGroup(blkArray, width, height);
            //     break;
            // default:
            //     throw std::runtime_error("unknown block type");
            // }
            updated = true;
        }
    }

public:
    explicit Canvas(int _width, int _height) : width(_width), height(_height), second(0), score(0), updated(false), rd(), rnd(rd()), blockSizeDist(1, 3), blockTypeDist(1, 4)
    {
        control = nullptr;
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

class Point
{
public:
    int x, y;

    Point(int _x, int _y)
    {
        this->x = _x;
        this->y = _y;
    }
};

class Group
{
protected:
    Block ***blkArray;
    int width, height;

public:
    enum Type
    {
        Fold = 1,
        Tree = 2,
        Cross = 3
    };
    Group(Block ***_blkArray, int _width, int _height)
    {
        this->blkArray = _blkArray;
        this->width = _width;
        this->height = _height;
    };
    virtual Group::Type getType(void) = 0;
};

class TreeGroup : public Group
{
private:
    Point topP, midP, botP;

public:
    TreeGroup(Block ***_blkArray, int _width, int _height) : Group(_blkArray, _width, _height), topP(_width / 2, 0), midP(_width / 2, 1), botP(_width / 2, 2)
    {
        // for (int y = 0; y < 3; y++)
        // {
        //     delete (blkArray[y][width / 2]);
        //     switch (static_cast<Block::Type>(this->blockTypeDist(rnd)))
        //     {
        //     case Block::Type::Gray:
        //         blkArray[y][width / 2] = new GrayBlock();
        //         break;
        //     case Block::Type::Red:
        //         blkArray[y][width / 2] = new RedBlock();
        //         break;
        //     case Block::Type::Green:
        //         blkArray[y][width / 2] = new GreenBlock();
        //         break;
        //     case Block::Type::Blue:
        //         blkArray[y][width / 2] = new BlueBlock();
        //         break;
        //     default:
        //         throw std::runtime_error("unknown block type");
        //     }
        // }
    }
    Group::Type getType(void) { return Group::Type::Tree; }
};

#endif // CANVAS_HPP