#include <iostream>
#include "block.hpp"

int main(int argc, char* argv[])
{
	std::cout << "Hello, World!" << std::endl;

	Block blk(100, 100, 0, 0);
	std::cout << blk.to_string() << ": " << blk.get_pos().x << ", "<< blk.get_pos().y << std::endl;
	blk.move(1, 2);
	std::cout << blk.to_string() << ": " << blk.get_pos().x << ", " << blk.get_pos().y << std::endl;
	blk.get_type() = BlockType::GREEN;
	std::cout << blk.to_string() << ": " << blk.get_pos().x << ", " << blk.get_pos().y << std::endl;
	blk.move(-500, 200);
	std::cout << blk.to_string() << ": " << blk.get_pos().x << ", " << blk.get_pos().y << std::endl;

	return 0;
}