#include <Windows.h>
#include "canvas.hpp"

int main(int argc, char* argv[])
{
	{
		Canvas c(5, 10);
		c.draw();
		std::cout << "=====BREAKLINE=====" << std::endl;
		c.draw();
		std::cout << "=====BREAKLINE=====" << std::endl;
		c.update();
		c.draw();
		std::cout << "=====BREAKLINE=====" << std::endl;
		while (true) {
			(void)getchar();
			system("cls");
			c.update();
			c.createPBlock();
			c.draw();
			(void)getchar();
			system("cls");
			c.update();
			c.draw();
			(void)getchar();
			system("cls");
			c.update();
			c.draw();
			(void)getchar();
			system("cls");
			c.update();
			c.draw();
			(void)getchar();
			system("cls");
			c.update();
			c.createPBlock();
			c.draw();
		}
		//c.getArray()[0][2]->getType() = BlockType::GREEN;
		//c.getArray()[0][1]->getType() = BlockType::GRAY;
		//while (true)
		//{
		//	system("cls");
		//	c.draw();
		//	Sleep(1000);
		//	c.update();
		//}
	}
}