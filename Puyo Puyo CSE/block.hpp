#ifndef BLOCK_HPP
#define BLOCK_HPP

#include <string>

class Block
{
public:
    enum Type
    {
        Blank,
        Gray,
        Red,
        Green,
        Blue
    };
    virtual const Type getType() { return this->Blank; };
    virtual const std::string toString() { return std::string("0"); };
};

class GrayBlock : public Block
{
public:
    const Type getType() { return this->Gray; }
    const std::string toString() { return std::string("1"); }
};
class RedBlock : public Block
{
public:
    const Type getType() { return this->Red; }
    const std::string toString() { return std::string("2"); }
};
class GreenBlock : public Block
{
public:
    const Type getType() { return this->Green; }
    const std::string toString() { return std::string("3"); }
};
class BlueBlock : public Block
{
public:
    const Type getType() { return this->Blue; }
    const std::string toString() { return std::string("4"); }
};

#endif // BLOCK_HPP