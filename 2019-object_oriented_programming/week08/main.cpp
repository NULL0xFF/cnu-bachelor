#include <iostream>
#include <string>
#include <regex>

int main(void)
{
    std::string s;
    std::cin >> s;
    std::regex number("[0-9]+");

    if (std::regex_match(s, number))
    {
        std::cout << "number" << std::endl;
        std::sregex_iterator it(s.begin(), s.end(), number);
        std::sregex_iterator end;
        while (it != end)
        {
            std::smatch m = *it;
            std::cout << m.str().c_str() << std::endl;
            it++;
        }
    }
    else
        std::cout << "not a number" << std::endl;

    return 0;
}