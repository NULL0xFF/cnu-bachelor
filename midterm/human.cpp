#include "human.h"

human::human() { this->name = nullptr; }
human::human(char name[]) { this->name = name; }
char *human::get_name() { return this->name; }
int human::get_id() { return 0; }
