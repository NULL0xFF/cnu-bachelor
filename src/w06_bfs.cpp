#include <iostream>
#include <algorithm>
#include <map>
#include <vector>
#include <string>
#include <stack>

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

    // BFS
    std::vector<std::string> visited;
    std::stack<std::string> stacked;
    std::cin >> input[0];
    stacked.push(input[0]);
    while (!stacked.empty())
    {
        input[1] = stacked.top();
        stacked.pop();
        if (std::find(visited.begin(), visited.end(), input[1]) == visited.end())
        {
            visited.push_back(input[1]);
            list = graph.find(input[1])->second;
            for (int i = 0; i < list->size(); i++)
                stacked.push(list->at(i));
        }
    }

    // Print BFS
    for (auto it1 = visited.begin(); it1 != visited.end(); it1++)
    {
        std::cout << *it1;
        if (it1 != visited.end())
            std::cout << " ";
        else
            std::cout << std::endl;
    }

    return 0;
}