#pragma once
class vehicle
{
private:
    bool has_name;
    int wheel_number;
    int max_speed;

public:
    vehicle();
    explicit vehicle(int, int);
    explicit vehicle(int, int, bool);
    int get_wheel_number();
    int get_max_speed();
    bool get_has_name();
    virtual const char *get_class_name() { return "vehicle"; };
    void set_wheel_number(int);
    void set_max_speed(int);
    void set_has_name(bool);
};