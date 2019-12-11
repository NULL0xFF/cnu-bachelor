#include <iostream>
#include <stdexcept>

int main(int argc, char *argv[])
{
    try
    {
        /* code */
    }
    catch (const std::exception &e)
    {
        std::cerr << e.what() << '\n';
    }
}