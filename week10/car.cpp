#include "car.hpp"

car::car() : vehicle()
{
    this->car_name = nullptr;
}
car::car(int wheel_number, int max_speed) : vehicle(wheel_number, max_speed)
{
    this->car_name = nullptr;
}
car::car(int wheel_number, int max_speed, char *car_name) : vehicle(wheel_number, max_speed)
{
    this->car_name = car_name;
}
car::car(int wheel_number, int max_speed, char *car_name, bool has_name) : vehicle(wheel_number, max_speed, has_name)
{
    this->car_name = car_name;
}
char *car::get_car_name()
{
    return this->car_name;
}
void car::set_car_name(char *car_name)
{
    this->car_name = car_name;
}