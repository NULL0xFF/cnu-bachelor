#include <time.h>
#include "../lib/os.hpp"
#include "MonsterWorld.hpp"
// #include "Human.hpp"

int main(int argc, char *argv[])
{
	/* OS COMPATIBILITY CHECK */
#ifdef THROW
	try
	{
		throw std::runtime_error(THROW_MESSAGE);
	}
	catch (const std::exception &e)
	{
		std::cerr << e.what() << std::endl;
	}
	exit(1);
#endif
	/* END OF OS CHECK */

	srand((unsigned int)time(NULL));
	int w = 16, h = 8;

	MonsterWorld game(w, h);

	//game.add(new Human("사람","⊙", rand() % w, rand() % h));
	game.add(new Monster("몬스터", "※", rand() % w, rand() % h));
	game.add(new Monster("도깨비", "§", rand() % w, rand() % h));
	game.add(new Monster("별그대", "★", rand() % w, rand() % h));
	game.add(new Monster("고스트", "◎", rand() % w, rand() % h));
	game.play(100, 10);
	printf("-----게임 종료-----\n");

	return 0;
}