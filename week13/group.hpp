#ifndef GROUP_HPP
#define GROUP_HPP

#include "point.hpp"
#include "block.hpp"

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
    }
    Group::Type getType(void) { return Group::Type::Tree; }
};

#endif // GROUP_HPP