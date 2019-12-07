#ifndef BLOCK_HPP
#define BLOCK_HPP

#include <stdexcept>
#include <string>

enum class BlockType
{
	BLANK,
	GRAY,
	RED,
	GREEN,
	BLUE,
};

class Block
{
private:
	BlockType type;

public:
	Block() : Block(BlockType::BLANK) {}
	explicit Block(BlockType _type) : type(_type) {}
	BlockType& getType(void) { return this->type; }
	std::string toString(void)
	{
		switch (this->type)
		{
		case BlockType::BLANK:
			return "0";
		case BlockType::GRAY:
			return "1";
		case BlockType::RED:
			return "2";
		case BlockType::GREEN:
			return "3";
		case BlockType::BLUE:
			return "4";
		default:
			throw std::runtime_error("undefined block type");
		}
	}
};

#endif // BLOCK_HPP