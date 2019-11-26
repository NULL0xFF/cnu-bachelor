#include <iostream>

// Fibonacci function with recursive programming
int fibo(int i)
{
    if (i <= 1)
        return i;
    return fibo(i - 1) + fibo(i - 2);
}

// Main function
int main(int argc, char *argv[])
{
    int i;
    std::cin >> i;
    int val = fibo(i);

    std::cout << val << std::endl;
    return 0;
}