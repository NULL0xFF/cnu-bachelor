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
    virtual const Type getType() { return Block::Type::Blank; }
    virtual const std::string toString() { return std::string("·"); }
};

class GrayBlock : public Block
{
public:
    const Type getType() { return Block::Type::Gray; }
    const std::string toString() { return std::string("※"); }
};
class RedBlock : public Block
{
public:
    const Type getType() { return Block::Type::Red; }
    const std::string toString() { return std::string("■"); }
};
class GreenBlock : public Block
{
public:
    const Type getType() { return Block::Type::Green; }
    const std::string toString() { return std::string("▲"); }
};
class BlueBlock : public Block
{
public:
    const Type getType() { return Block::Type::Blue; }
    const std::string toString() { return std::string("●"); }
};

#endif // BLOCK_HPP