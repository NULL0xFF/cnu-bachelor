#include "vehicle.hpp"

class car : public vehicle
{
private:
    char *car_name;

public:
    car();
    explicit car(int, int);
    explicit car(int, int, char *);
    explicit car(int, int, char *, bool);
    char *get_car_name();
    const char *get_class_name() { return "car"; };
    void set_car_name(char *);
};