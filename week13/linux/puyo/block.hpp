#ifndef BLOCK_HPP
#define BLOCK_HPP

enum BlockType
{
    BLANK,
    RED,
    GREEN,
    BLUE,
    GRAY
};

class Block
{
protected:
public:
    Block();
    explicit Block(BlockType _type = BlockType::BLANK);
    BlockType type();
};

#endif // BLOCK_HPP