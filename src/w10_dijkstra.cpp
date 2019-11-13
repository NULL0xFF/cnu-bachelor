#include <iostream>
#include <map>
#include <vector>
#include <queue>
#include <stack>

int main(int argc, char *argv[])
{
    // Graph Scale
    int n, m;
    std::cin >> n;
    std::cin >> m;

    // Create Graph
    char c;
    std::map<char, std::map<char, int>> graph;
    for (int i = 0; i < n; i++)
    {
        std::cin >> c;
        graph.insert(std::make_pair(c, std::map<char, int>()));
    }

    // Insert Direction
    char d;
    int x;
    for (int i = 0; i < m; i++)
    {
        std::cin >> c;
        std::cin >> d;
        std::cin >> x;
        if (graph.find(c)->second.find(d) == graph.find(c)->second.end())
            graph.find(c)->second.insert(std::make_pair(d, x));
        else if (graph.find(c)->second.find(d)->second > x)
            graph.find(c)->second.find(d)->second = x;
    }

    // Print Graph
    for (auto it = graph.begin(); it != graph.end(); it++)
    {
        std::cout << it->first << ": ";
        std::cout << "[ ";
        for (auto it2 = it->second.begin(); it2 != it->second.end(); it2++)
        {
            std::cout << "(" << it2->first << ", " << it2->second << ") ";
        }
        std::cout << "]" << std::endl;
    }

    // Find Path
    std::cin >> c;
    std::cin >> d;

    // Path Check
    char f = c;
    std::map<char, std::pair<int, char>> table;
    std::queue<std::pair<char, char>> queued;
    table.insert(std::make_pair(c, std::make_pair(0, c)));
    queued.push(std::make_pair(c, c));
    while (!queued.empty())
    {
        c = queued.front().first;
        queued.pop();
        for (auto it = graph.find(c)->second.begin(); it != graph.find(c)->second.end(); it++)
        {
            if (table.find(it->first) == table.end())
                table.insert(std::make_pair(it->first, std::make_pair(it->second + table.find(c)->second.first, c)));
            else if (table.find(it->first)->second.first > it->second + table.find(c)->second.first)
            {
                table.find(it->first)->second.first = it->second + table.find(c)->second.first;
                table.find(it->first)->second.second = c;
            }
            queued.push(std::make_pair(it->first, c));
        }
    }
    std::vector<char> visited;
    visited.push_back(d);
    char e;
    while (true)
    {
        d = visited.back();
        e = table.find(d)->second.second;
        visited.push_back(e);
        if (e == f)
            break;
    }
    std::stack<char> stacked;
    for (auto it = visited.begin(); it != visited.end(); it++)
        stacked.push(*it);
    while (!stacked.empty())
    {
        d = stacked.top();
        std::cout << d << " ";
        stacked.pop();
    }
    std::cout << std::endl;
    std::cout << table.find(d)->second.first << std::endl;

    // Return Main
    return 0;
}