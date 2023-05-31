#include <iostream>
#include <map>

std::map<long long, long long> cache;

// Fibonacci function with dynamic programming
long long fibo(long long i)
{
    if (i <= 1)
    {
        cache.insert(std::make_pair(i, i));
        return i;
    }

    // Cache Check
    if (cache.find(i) != cache.end())
        return cache.find(i)->second;

    // Calculate
    long long f_1 = fibo(i - 1);
    long long f_2 = fibo(i - 2);

    // Save Cache
    cache.insert(std::make_pair(i, f_1 + f_2));

    // Return
    return f_1 + f_2;
}

// Main function
int main(int argc, char *argv[])
{
    long long i;
    std::cin >> i;
    long long val = fibo(i);

    std::cout << val << std::endl;
    return 0;
}