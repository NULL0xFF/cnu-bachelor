#include "bike.hpp"

bike::bike() : vehicle()
{
    this->bike_name = nullptr;
    this->bike_number = -1;
}
bike::bike(int wheel_number, int max_speed) : vehicle(wheel_number, max_speed)
{
    this->bike_name = nullptr;
    this->bike_number = -1;
}
bike::bike(int wheel_number, int max_speed, char *bike_name) : bike(wheel_number, max_speed)
{
    this->bike_name = bike_name;
}
bike::bike(int wheel_number, int max_speed, char *bike_name, int bike_number) : bike(wheel_number, max_speed, bike_name)
{
    this->bike_number = bike_number;
}
bike::bike(int wheel_number, int max_speed, char *bike_name, int bike_number, bool has_name) : vehicle(wheel_number, max_speed, has_name)
{
    this->bike_name = bike_name;
    this->bike_number = bike_number;
}
int bike::get_bike_number() { return this->bike_number; }
char *bike::get_bike_name() { return this->bike_name; }
void bike::set_bike_name(char *) { this->bike_name = bike_name; }
void bike::set_bike_number(int) { this->bike_number = bike_number; }