#pragma once
#pragma warning(disable : 4996)

#include "Monster.hpp"
#include <conio.h>

enum Direction
{
	Left = 75,
	Right = 77,
	Up = 72,
	Down = 80
};

class Human : public Monster
{
public:
	Human(string n = "사람", string i = "⊙", int px = 0, int py = 0) : Monster(n, i, px, py) {}
	~Human() {}
	int getDirKey() { return getche() == 224 ? getch() : 0; }
	void move(int **map, int maxx, int maxy)
	{
		if (kbhit())
		{
			char ch = getDirKey();
			if (ch == Left)
				x--;
			else if (ch == Right)
				x++;
			else if (ch == Up)
				y--;
			else if (ch == Down)
				y++;
			else
				return;
			clip(maxx, maxy);
			eat(map);
		}
	}
};