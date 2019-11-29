#ifndef PUYO_HPP
#define PUYO_HPP

#include <unistd.h>
#include <iostream>
#include <thread>
#include <string>
#include <map>
#include "../lib/getch.h"
#include "../object/object.hpp"

#define SLEEP(x) sleep(x)
#define CLEAR "clear"
#define _MAP_ROW 12
#define _MAP_COLUMN 5
#define _MAP_BLANK "."
#define _INPUT_QUIT "QUIT"
#define _INPUT_ARROW_UP "↑"
#define _INPUT_ARROW_DOWN "↓"
#define _INPUT_ARROW_LEFT "←"
#define _INPUT_ARROW_RIGHT "→"

class puyo
{
private:
    int score, second;
    std::map<int, std::map<int, object *> *> *graphic_map;
    char **map;
    bool isAlive;
    bool isInput;
    std::string input_string;

    void update(void);
    void init(void);
    void draw(void);
    void run(void);
    void create(void);
    void input(void);
    bool blocked(void);

public:
    puyo(void);
    void start(void);
};

#endif // PUYO_HPP