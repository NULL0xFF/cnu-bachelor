#include <vector>
#include "block.hpp"

class Visual
{
private:
	std::vector<std::vector<Block>> canvas;
	int width, height;

public:
	Visual(int w, int h) : canvas(h, std::vector<Block>(w, Block(w, h, 0, 0))), width(w), height(h) {
		for (int y = 0; y < h; y++)
			for (int x = 0; x < w; x++) {
				this->canvas[y][x].get_pos().x = x;
				this->canvas[y][x].get_pos().y = y;
			}
	}
	void draw(void)
	{
		for (int y = 0; y < this->height; y++) {
			for (int x = 0; x < this->width; x++)
				std::cout << this->canvas[y][x].to_string() << "\t";
			std::cout << std::endl;
		}
	}

};