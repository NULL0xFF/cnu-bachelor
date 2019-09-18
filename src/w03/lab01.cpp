#include <iostream>

void code()
{
    return;
}
int main()
{
    char *rodata = "ABC";
    static int data = 0;
    static int bss;
    int *heap = new int(4);
    const int stack = 0;
    std::cout << "code\t" << (void *)code << std::endl;
    std::cout << "Rodata\t" << (void *)rodata << std::endl;
    std::cout << "data\t" << &data << std::endl;
    std::cout << "BSS\t" << &bss << std::endl;
    std::cout << "HEAP\t" << heap << std::endl;
    std::cout << "Stack\t" << &stack << std::endl;

    // Finalize
    delete heap;
    heap = nullptr;
}