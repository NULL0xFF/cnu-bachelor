#ifndef GROUP_HPP
#define GROUP_HPP

#include <stdexcept>
#include <random>
#include "point.hpp"
#include "block.hpp"

class Group
{
protected:
    std::random_device rd;
    std::mt19937_64 rnd;
    std::uniform_int_distribution<int64_t> blockTypeDist;
    Point **control;
    Block ***blkArray;
    int width, height;

    virtual void create(void) = 0;

public:
    enum Type
    {
        Fold = 1,
        Tree = 2,
        Cross = 3
    };

    Group(Block ***_blkArray, int _width, int _height) : rd(), rnd(rd()), blockTypeDist(1, 4)
    {
        this->blkArray = _blkArray;
        this->width = _width;
        this->height = _height;
    }
    ~Group()
    {
        blkArray = nullptr;
        delete (control);
    }
    virtual bool move(int dx, int dy) = 0;
    virtual Group::Type getType(void) = 0;
};

class TreeGroup : public Group
{
protected:
    void create(void)
    {
        Block *blk = nullptr;
        for (int i = 0; i < 3; i++)
        {
            delete (blkArray[control[i]->y][control[i]->x]);
            switch (static_cast<Block::Type>(blockTypeDist(rnd)))
            {
            case Block::Type::Gray:
                blk = new GrayBlock();
                break;
            case Block::Type::Red:
                blk = new GrayBlock();
                break;
            case Block::Type::Green:
                blk = new GrayBlock();
                break;
            case Block::Type::Blue:
                blk = new GrayBlock();
                break;
            default:
                throw std::runtime_error("random block creation failed");
            }
            blkArray[control[i]->y][control[i]->x] = blk;
        }
        blk = nullptr;
    }

public:
    TreeGroup(Block ***_blkArray, int _width, int _height) : Group(_blkArray, _width, _height)
    {
        control = new Point *[3];
        control[0] = new Point(_width / 2, 0); // Top
        control[1] = new Point(_width / 2, 1); // Middle
        control[2] = new Point(_width / 2, 2); // Bottom
        create();
    }
    Group::Type getType(void) { return Group::Type::Tree; }
    bool move(int dx, int dy)
    {
        if (dy < 0)
            return false; // Range check

        if (dx == 0 && dy == 0)
            return true; // No movement

        // Check whether target destination is changeable
        if (dx == 0)
        {
            for (int i = 2; i >= ((dy == 1) ? 2 : ((dy == 2) ? 1 : 0)); i--)
                if (blkArray[control[i]->y + dy][control[i]->x + dx]->getType() != Block::Type::Blank)
                    return false;
        }
        else
        {
            for (int i = 2; i >= 0; i--)
                if (blkArray[control[i]->y + dy][control[i]->x + dx]->getType() != Block::Type::Blank)
                    return false;
        }

        // Move blocks
        for (int i = 2; i >= 0; i--)
        {
            delete (blkArray[control[i]->y + dy][control[i]->x + dx]);
            blkArray[control[i]->y + dy][control[i]->x + dx] = blkArray[control[i]->y][control[i]->x];
            blkArray[control[i]->y][control[i]->x] = new Block();
        }
        return true;
    }
};

#endif // GROUP_HPP