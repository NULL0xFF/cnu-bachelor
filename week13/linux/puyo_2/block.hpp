#ifndef BLOCK_HPP
#define BLOCK_HPP

#include "canvas.hpp"

class Block
{
private:
	std::string name, icon;
	int x, y;

	void clip(int x_Max, int y_Max)
	{
		if (x < 0)
			x = 0;
		if (x_Max <= x)
			x = x_Max - 1;
		if (y < 0)
			y = 0;
		if (y_Max <= y)
			y = y_Max - 1;
	}

public:
	enum BlockType
	{
		BLANK,
		RED,
		GREEN,
		BLUE
	};

public:
	Block(std::string i = "·", int px = 0, int py = 0) {}
	virtual ~Block(){};

	void draw(Canvas *canvas) { canvas->draw(x, y, icon); }
	virtual void move(std::vector<int> map, int x_Max, int y_Max);
	virtual BlockType type() { return BlockType::BLANK; };
};

#endif // BLOCK_HPP