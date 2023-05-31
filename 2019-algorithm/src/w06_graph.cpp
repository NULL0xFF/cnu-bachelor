#include <iostream>
#include <algorithm>
#include <map>
#include <vector>
#include <string>

int main(void)
{
    // Graph Scale
    int n, m;
    std::cin >> n;
    std::cin >> m;

    // Create Graph
    std::map<std::string, std::vector<std::string> *> graph;
    std::string input[2];
    for (int i = 0; i < n; i++)
    {
        std::cin >> input[0];
        graph.insert(std::make_pair(input[0], new std::vector<std::string>));
    }
    std::vector<std::string> *list;
    for (int i = 0; i < m; i++)
    {
        std::cin >> input[0];
        std::cin >> input[1];
        if (graph.find(input[0]) != graph.end())
        {
            list = graph.find(input[0])->second;
            if (std::find(list->begin(), list->end(), input[1]) == list->end())
            {
                list->push_back(input[1]);
                sort(list->begin(), list->end());
                list = graph.find(input[1])->second;
                list->push_back(input[0]);
                sort(list->begin(), list->end());
            }
        }
        else
            return 1; // key not found
    }

    // Input
    std::cin >> input[0];

    // Output
    list = graph.find(input[0])->second;
    std::cout << list->size();

    return 0;
}