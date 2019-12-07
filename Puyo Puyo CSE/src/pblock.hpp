#pragma warning ( disable : 4996 )

#include <conio.h>
#include <vector>
#include "block.hpp"

enum Direction
{
	LEFT = 75,
	RIGHT = 77,
	UP = 72,
	DOWN = 80
};

class PBlock
{
private:
	std::vector<Block*> pBlkList;

	int getDirKey() { return getche() == 224 ? getch() : 0; }
	bool isColliding(const std::vector<std::vector<Block>> canvas, int dx, int dy) {
	}

public:
	PBlock(int w, int h, int x, int y) {

	}

	void move()
	{
		if (kbhit())
		{
			char ch = getDirKey();
			switch (ch)
			{
			case LEFT:
				break;
			case RIGHT:
				break;
			case UP:
				break;
			case DOWN:
				break;
			}
			if (!isColliding)
			{
				for (int i = 0; i < pBlkList.size(); i++)
					pBlkList[i]->get_pos().x--;
			}
		}
	}
};