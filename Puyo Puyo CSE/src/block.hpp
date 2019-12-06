#include <iostream>
#include <stdexcept>
#include <string>
#include "point.hpp"

enum class BlockType {
	BLANK,
	GRAY,
	RED,
	GREEN,
	BLUE
};

class Block
{
private:
	BlockType type;
	Point p;
	int width, height;

public:
	Block(int w, int h, int x, int y) : Block(w, h, x, y, BlockType::BLANK) {}
	explicit Block(int w, int h, int x, int y, BlockType _type) : p(x, y) {
		this->width = w;
		this->height = h;
		this->type = _type;
	}
	void move(int dx, int dy) {
		this->p.x += dx;
		this->p.y += dy;
		if (this->p.x < 0)
			this->p.x = 0;
		else if (this->width <= this->p.x)
			this->p.x = this->width - 1;
		if (this->p.y < 0)
			this->p.y = 0;
		else if (this->height <= this->p.y)
			this->p.y = this->height - 1;
	}
	BlockType& get_type(void) {
		return this->type;
	}
	Point& get_pos(void) { return this->p; }
	std::string to_string(void) {
		switch (this->type) {
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
			throw std::runtime_error("unknown block type");
		}
	}
};