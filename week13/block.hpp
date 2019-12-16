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
    Type getType() { return Block::Type::Gray; }
    std::string toString() { return std::string("■"); }
};
class Block_Red : public Block
{
public:
    Type getType() { return Block::Type::Red; }
    std::string toString() { return std::string("\033[31m■\033[0m"); }
};
class Block_Green : public Block
{
public:
    Type getType() { return Block::Type::Green; }
    std::string toString() { return std::string("\033[32m■\033[0m"); }
};
class Block_Blue : public Block
{
public:
    Type getType() { return Block::Type::Blue; }
    std::string toString() { return std::string("\033[34m■\033[0m"); }
};

#endif // BLOCK_HPP