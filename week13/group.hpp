#ifndef GROUP_HPP
#define GROUP_HPP

#include <iostream>
#include <stdexcept>
#include <random>
#include "point.hpp"
#include "block.hpp"

class Group
{
protected:
	std::random_device rd;
	std::mt19937_64 rnd;
	std::uniform_int_distribution<long long int> blockTypeDist;
	Block ***blkArray;
	Point **control;
	int width, height, size;
	unsigned int rotation;

	virtual void create(void) = 0;

public:
	enum class Type
	{
		Fold = 1,
		Tree = 2,
		Cross = 3
	};

	Group(Block ***_blkArray, int _width, int _height) : rd(), rnd(rd()), blockTypeDist(1, 4)
	{
		this->blkArray = _blkArray;
		this->control = nullptr;
		this->width = _width;
		this->height = _height;
		this->size = 0;
		this->rotation = 0;
	}
	~Group()
	{
		blkArray = nullptr;
		delete (blkArray);
		for (int i = 0; i < size; i++)
			delete (control[i]);
		delete (control);
	}
	virtual void update(void) = 0;
	virtual bool move(int dx, int dy) = 0;
	virtual bool rotate(unsigned int degree) = 0;
	virtual Group::Type getType(void) = 0;
};

class TreeGroup : public Group
{
private:
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
				blk = new RedBlock();
				break;
			case Block::Type::Green:
				blk = new GreenBlock();
				break;
			case Block::Type::Blue:
				blk = new BlueBlock();
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
		size = 3;
		control = new Point *[3];
		control[0] = new Point(_width / 2, 0); // Top
		control[1] = new Point(_width / 2, 1); // Middle
		control[2] = new Point(_width / 2, 2); // Bottom
		create();
	}
	Group::Type getType(void) { return Group::Type::Tree; }
	void update(void)
	{
		for (int i = 0; i < 3; i++)
			control[i]->y = control[i]->y + 1;
	}
	bool move(int dx, int dy)
	{
		if (dy < 0)
			return false; // Range check

		if (dx == 0 && dy == 0)
			return true; // No movement

		// Check whether target destination is changeable
		switch (rotation % 360)
		{
		case 0:
			if (dx == 0)
			{
				for (int i = 3 - 1; i >= ((dy == 1) ? 2 : ((dy == 2) ? 1 : 0)); i--)
				{
					if (control[i]->x + dx < 0 || control[i]->x + dx >= width)
						return false;
					if (control[i]->y + dy < 0 || control[i]->y + dy >= height)
						return false;
					if (blkArray[control[i]->y + dy][control[i]->x + dx]->getType() != Block::Type::Blank)
						return false;
				}
			}
			else
			{
				for (int i = 2; i >= 0; i--)
				{
					if (control[i]->x + dx < 0 || control[i]->x + dx >= width)
						return false;
					if (control[i]->y + dy < 0 || control[i]->y + dy >= height)
						return false;
					if (blkArray[control[i]->y + dy][control[i]->x + dx]->getType() != Block::Type::Blank)
						return false;
				}
			}
			// Move blocks
			for (int i = 2; i >= 0; i--)
			{
				delete (blkArray[control[i]->y + dy][control[i]->x + dx]);
				blkArray[control[i]->y + dy][control[i]->x + dx] = blkArray[control[i]->y][control[i]->x];
				blkArray[control[i]->y][control[i]->x] = new Block();
				control[i]->x = control[i]->x + dx;
				control[i]->y = control[i]->y + dy;
			}
			break;
		case 90:
			if (dy == 0)
			{
				if (dx > 0)
					for (int i = 0; i < ((dx == 1) ? 1 : ((dx == 2) ? 2 : 3)); i++)
					{
						if (control[i]->x + dx < 0 || control[i]->x + dx >= width)
							return false;
						if (control[i]->y + dy < 0 || control[i]->y + dy >= height)
							return false;
						if (blkArray[control[i]->y + dy][control[i]->x + dx]->getType() != Block::Type::Blank)
							return false;
					}
				else
				{
					for (int i = 3 - 1; i >= ((dx == -1) ? 2 : ((dx == -2) ? 1 : 0)); i--)
					{
						if (control[i]->x + dx < 0 || control[i]->x + dx >= width)
							return false;
						if (control[i]->y + dy < 0 || control[i]->y + dy >= height)
							return false;
						if (blkArray[control[i]->y + dy][control[i]->x + dx]->getType() != Block::Type::Blank)
							return false;
					}
				}
			}
			else
			{
				for (int i = 0; i < 0; i++)
				{
					if (control[i]->x + dx < 0 || control[i]->x + dx >= width)
						return false;
					if (control[i]->y + dy < 0 || control[i]->y + dy >= height)
						return false;
					if (blkArray[control[i]->y + dy][control[i]->x + dx]->getType() != Block::Type::Blank)
						return false;
				}
			}
			// Move blocks
			if (dx > 0)
				for (int i = 0; i < 3; i++)
				{
					delete (blkArray[control[i]->y + dy][control[i]->x + dx]);
					blkArray[control[i]->y + dy][control[i]->x + dx] = blkArray[control[i]->y][control[i]->x];
					blkArray[control[i]->y][control[i]->x] = new Block();
					control[i]->x = control[i]->x + dx;
					control[i]->y = control[i]->y + dy;
				}
			else
			{
				for (int i = 2; i >= 0; i--)
				{
					delete (blkArray[control[i]->y + dy][control[i]->x + dx]);
					blkArray[control[i]->y + dy][control[i]->x + dx] = blkArray[control[i]->y][control[i]->x];
					blkArray[control[i]->y][control[i]->x] = new Block();
					control[i]->x = control[i]->x + dx;
					control[i]->y = control[i]->y + dy;
				}
			}
			break;
		case 180:
			if (dx == 0)
			{
				for (int i = 0; i < ((dy == 1) ? 1 : ((dy == 2) ? 2 : 3)); i++)
				{
					if (control[i]->x + dx < 0 || control[i]->x + dx >= width)
						return false;
					if (control[i]->y + dy < 0 || control[i]->y + dy >= height)
						return false;
					if (blkArray[control[i]->y + dy][control[i]->x + dx]->getType() != Block::Type::Blank)
						return false;
				}
			}
			else
			{
				for (int i = 0; i < 3; i++)
				{
					if (control[i]->x + dx < 0 || control[i]->x + dx >= width)
						return false;
					if (control[i]->y + dy < 0 || control[i]->y + dy >= height)
						return false;
					if (blkArray[control[i]->y + dy][control[i]->x + dx]->getType() != Block::Type::Blank)
						return false;
				}
			}
			// Move blocks
			for (int i = 0; i < 3; i++)
			{
				delete (blkArray[control[i]->y + dy][control[i]->x + dx]);
				blkArray[control[i]->y + dy][control[i]->x + dx] = blkArray[control[i]->y][control[i]->x];
				blkArray[control[i]->y][control[i]->x] = new Block();
				control[i]->x = control[i]->x + dx;
				control[i]->y = control[i]->y + dy;
			}
			break;
		case 270:
			if (dy == 0)
			{
				if (dx > 0)
					for (int i = 3 - 1; i >= ((dx == 1) ? 2 : ((dx == 2) ? 1 : 0)); i--)
					{
						if (control[i]->x + dx < 0 || control[i]->x + dx >= width)
							return false;
						if (control[i]->y + dy < 0 || control[i]->y + dy >= height)
							return false;
						if (blkArray[control[i]->y + dy][control[i]->x + dx]->getType() != Block::Type::Blank)
							return false;
					}
				else
				{
					for (int i = 0; i < ((dx == -1) ? 1 : ((dx == -2) ? 2 : 3)); i++)
					{
						if (control[i]->x + dx < 0 || control[i]->x + dx >= width)
							return false;
						if (control[i]->y + dy < 0 || control[i]->y + dy >= height)
							return false;
						if (blkArray[control[i]->y + dy][control[i]->x + dx]->getType() != Block::Type::Blank)
							return false;
					}
				}
			}
			else
			{
				for (int i = 0; i < 0; i++)
				{
					if (control[i]->x + dx < 0 || control[i]->x + dx >= width)
						return false;
					if (control[i]->y + dy < 0 || control[i]->y + dy >= height)
						return false;
					if (blkArray[control[i]->y + dy][control[i]->x + dx]->getType() != Block::Type::Blank)
						return false;
				}
			}
			// Move blocks
			if (dx > 0)
				for (int i = 2; i >= 0; i--)
				{
					delete (blkArray[control[i]->y + dy][control[i]->x + dx]);
					blkArray[control[i]->y + dy][control[i]->x + dx] = blkArray[control[i]->y][control[i]->x];
					blkArray[control[i]->y][control[i]->x] = new Block();
					control[i]->x = control[i]->x + dx;
					control[i]->y = control[i]->y + dy;
				}
			else
			{
				for (int i = 0; i < 3; i++)
				{
					delete (blkArray[control[i]->y + dy][control[i]->x + dx]);
					blkArray[control[i]->y + dy][control[i]->x + dx] = blkArray[control[i]->y][control[i]->x];
					blkArray[control[i]->y][control[i]->x] = new Block();
					control[i]->x = control[i]->x + dx;
					control[i]->y = control[i]->y + dy;
				}
			}
			break;
		}
		return true;
	}
	bool rotate(unsigned int degree)
	{
		Point *p = control[1];
		Block *blk = nullptr;
		switch (degree % 360)
		{
		case 0:
			return true; // No rotation
		case 90:
			switch (rotation)
			{
			case 0:
				if (p->x - 1 < 0 || p->x + 1 >= width)
					return false;
				if (blkArray[p->y][p->x - 1]->getType() != Block::Type::Blank || blkArray[p->y][p->x + 1]->getType() != Block::Type::Blank)
					return false;
				blk = blkArray[p->y][p->x + 1];
				blkArray[p->y][p->x + 1] = blkArray[control[0]->y][control[0]->x];
				blkArray[control[0]->y][control[0]->x] = blk;
				blk = blkArray[p->y][p->x - 1];
				blkArray[p->y][p->x - 1] = blkArray[control[2]->y][control[2]->x];
				blkArray[control[2]->y][control[2]->x] = blk;
				control[0]->x++;
				control[0]->y++;
				control[2]->x--;
				control[2]->y--;
				break;
			case 90:
				if (p->y - 1 < 0 || p->y + 1 >= height)
					return false;
				if (blkArray[p->y - 1][p->x]->getType() != Block::Type::Blank || blkArray[p->y + 1][p->x]->getType() != Block::Type::Blank)
					return false;
				blk = blkArray[p->y + 1][p->x];
				blkArray[p->y + 1][p->x] = blkArray[control[0]->y][control[0]->x];
				blkArray[control[0]->y][control[0]->x] = blk;
				blk = blkArray[p->y - 1][p->x];
				blkArray[p->y - 1][p->x] = blkArray[control[2]->y][control[2]->x];
				blkArray[control[2]->y][control[2]->x] = blk;
				control[0]->x--;
				control[0]->y++;
				control[2]->x++;
				control[2]->y--;
				break;
			case 180:
				if (p->x - 1 < 0 || p->x + 1 >= width)
					return false;
				if (blkArray[p->y][p->x - 1]->getType() != Block::Type::Blank || blkArray[p->y][p->x + 1]->getType() != Block::Type::Blank)
					return false;
				blk = blkArray[p->y][p->x - 1];
				blkArray[p->y][p->x - 1] = blkArray[control[0]->y][control[0]->x];
				blkArray[control[0]->y][control[0]->x] = blk;
				blk = blkArray[p->y][p->x + 1];
				blkArray[p->y][p->x + 1] = blkArray[control[2]->y][control[2]->x];
				blkArray[control[2]->y][control[2]->x] = blk;
				control[0]->x--;
				control[0]->y--;
				control[2]->x++;
				control[2]->y++;
				break;
			case 270:
				if (p->y - 1 < 0 || p->y + 1 >= height)
					return false;
				if (blkArray[p->y - 1][p->x]->getType() != Block::Type::Blank || blkArray[p->y + 1][p->x]->getType() != Block::Type::Blank)
					return false;
				blk = blkArray[p->y - 1][p->x];
				blkArray[p->y - 1][p->x] = blkArray[control[0]->y][control[0]->x];
				blkArray[control[0]->y][control[0]->x] = blk;
				blk = blkArray[p->y + 1][p->x];
				blkArray[p->y + 1][p->x] = blkArray[control[2]->y][control[2]->x];
				blkArray[control[2]->y][control[2]->x] = blk;
				control[0]->x++;
				control[0]->y--;
				control[2]->x--;
				control[2]->y++;
				break;
			default:
				throw std::runtime_error("undefined rotation degree");
			}
			rotation = (rotation + degree) % 360;
			return true;
		case 180:
			blk = blkArray[control[0]->y][control[0]->x];
			blkArray[control[0]->y][control[0]->x] = blkArray[control[2]->y][control[2]->x];
			blkArray[control[2]->y][control[2]->x] = blk;
			p = control[0];
			control[0] = control[2];
			control[2] = p;
			rotation = (rotation + degree) % 360;
			return true;
		case 270:
			switch (rotation)
			{
			case 0:
				if (p->x - 1 < 0 || p->x + 1 >= width)
					return false;
				if (blkArray[p->y][p->x - 1]->getType() != Block::Type::Blank || blkArray[p->y][p->x + 1]->getType() != Block::Type::Blank)
					return false;
				blk = blkArray[p->y][p->x - 1];
				blkArray[p->y][p->x - 1] = blkArray[control[0]->y][control[0]->x];
				blkArray[control[0]->y][control[0]->x] = blk;
				blk = blkArray[p->y][p->x + 1];
				blkArray[p->y][p->x + 1] = blkArray[control[2]->y][control[2]->x];
				blkArray[control[2]->y][control[2]->x] = blk;
				control[0]->x--;
				control[0]->y++;
				control[2]->x++;
				control[2]->y--;
				break;
			case 90:
				if (p->y - 1 < 0 || p->y + 1 >= height)
					return false;
				if (blkArray[p->y - 1][p->x]->getType() != Block::Type::Blank || blkArray[p->y + 1][p->x]->getType() != Block::Type::Blank)
					return false;
				blk = blkArray[p->y - 1][p->x];
				blkArray[p->y - 1][p->x] = blkArray[control[0]->y][control[0]->x];
				blkArray[control[0]->y][control[0]->x] = blk;
				blk = blkArray[p->y + 1][p->x];
				blkArray[p->y + 1][p->x] = blkArray[control[2]->y][control[2]->x];
				blkArray[control[2]->y][control[2]->x] = blk;
				control[0]->x--;
				control[0]->y--;
				control[2]->x++;
				control[2]->y++;
				break;
			case 180:
				if (p->x - 1 < 0 || p->x + 1 >= width)
					return false;
				if (blkArray[p->y][p->x - 1]->getType() != Block::Type::Blank || blkArray[p->y][p->x + 1]->getType() != Block::Type::Blank)
					return false;
				blk = blkArray[p->y][p->x + 1];
				blkArray[p->y][p->x + 1] = blkArray[control[0]->y][control[0]->x];
				blkArray[control[0]->y][control[0]->x] = blk;
				blk = blkArray[p->y][p->x - 1];
				blkArray[p->y][p->x - 1] = blkArray[control[2]->y][control[2]->x];
				blkArray[control[2]->y][control[2]->x] = blk;
				control[0]->x++;
				control[0]->y--;
				control[2]->x--;
				control[2]->y++;
				break;
			case 270:
				if (p->y - 1 < 0 || p->y + 1 >= height)
					return false;
				if (blkArray[p->y - 1][p->x]->getType() != Block::Type::Blank || blkArray[p->y + 1][p->x]->getType() != Block::Type::Blank)
					return false;
				blk = blkArray[p->y + 1][p->x];
				blkArray[p->y + 1][p->x] = blkArray[control[0]->y][control[0]->x];
				blkArray[control[0]->y][control[0]->x] = blk;
				blk = blkArray[p->y - 1][p->x];
				blkArray[p->y - 1][p->x] = blkArray[control[2]->y][control[2]->x];
				blkArray[control[2]->y][control[2]->x] = blk;
				control[0]->x++;
				control[0]->y++;
				control[2]->x--;
				control[2]->y--;
				break;
			default:
				throw std::runtime_error("undefined rotation degree");
			}
			rotation = (rotation + degree) % 360;
			return true;
		default:
			return false;
		}
	}
};

#endif // GROUP_HPP