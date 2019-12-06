#include <vector>
#include "block.hpp"

class Visual
{
private:
	std::vector<std::vector<Block&>> canvas;
	int width, height;

public:
	Visual(int w, int h) : canvas(h){
		for (int y = 0; y < h; y++)
		{
			this->canvas[y] = std::vector<Block&>(w);
			for (int x = 0; x < w; x++)
				this->canvas[y][x] = Block(x, y);
		}
	}
};