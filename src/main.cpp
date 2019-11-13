#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

int main(void)
{
    std::string s1 = "ab";
    std::string s2 = "ac";
    std::string s3 = "ba";
    std::vector<std::string> v;

    v.push_back(s2);
    v.push_back(s3);
    v.push_back(s1);
    for (auto it = v.begin(); it != v.end(); it++)
        std::cout << *it << " ";
    std::cout << std::endl;
    std::sort(v.begin(), v.end(), std::less<std::string>());

    for (auto it = v.begin(); it != v.end(); it++)
        std::cout << *it << " ";
    std::cout << std::endl;
    return 0;
}