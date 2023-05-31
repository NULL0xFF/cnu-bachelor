#ifndef BLOCK_HPP
#define BLOCK_HPP

#include <string>

class Block
{
public:
    enum class Type
    {
        Blank,
        Gray,
        Red,
        Green,
        Blue
    };
    virtual Type getType() { return Block::Type::Blank; }
    virtual std::string toString() { return std::string("·"); }
};

class Block_Gray : public Block
{
public:
    Type getType();
    std::string toString();
};
class Block_Red : public Block
{
public:
    Type getType();
    std::string toString();
};
class Block_Green : public Block
{
public:
    Type getType();
    std::string toString();
};
class Block_Blue : public Block
{
public:
    Type getType();
    std::string toString();
};

#endif // BLOCK_HPP