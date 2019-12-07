#include <iostream>
#include <stdexcept>
#include "puyo/canvas.hpp"

int main(int argc, char* argv[])
{
	try {
		Canvas c(3, 3);
	}
	catch (std::exception e)
	{
		std::cerr << e.what() << std::endl;
		exit(1);
	}
}