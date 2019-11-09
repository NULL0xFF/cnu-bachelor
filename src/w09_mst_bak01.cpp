#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <queue>
#include <algorithm>
#include <map>

/* Input Method Return Function */
std::istream &init_input(int argc, char *argv[])
{
    if (argc == 2)
        return *(new std::ifstream(argv[1]));
    return std::cin;
}

int main(int argc, char *argv[])
{
    // Initialize Variable
    std::istream &in = init_input(argc, argv);
    std::map<char, std::map<int, std::vector<char>>> graph;
    int i, j, k, n, m;
    char c, d;

    // Set Graph Scale
    in >> n;
    in >> m;
    for (i = 0; i < n; i++)
    {
        in >> c;
        graph.insert(std::make_pair(c, *(new std::map<int, std::vector<char>>)));
    }

    // Create Graph
    for (i = 0; i < m; i++)
    {
        in >> c;
        in >> d;
        in >> j;

        if (graph.find(c) != graph.end() && graph.find(d) != graph.end())
        {
            if (graph.find(c)->second.find(j) == graph.find(c)->second.end())
            {
                graph.find(c)->second.insert(std::make_pair(j, *(new std::vector<char>)));
                graph.find(c)->second.find(j)->second.push_back(d);
            }
            else if (std::find(graph.find(c)->second.find(j)->second.begin(), graph.find(c)->second.find(j)->second.end(), d) == graph.find(c)->second.find(j)->second.end())
                graph.find(c)->second.find(j)->second.push_back(d);
            if (graph.find(d)->second.find(j) == graph.find(d)->second.end())
            {
                graph.find(d)->second.insert(std::make_pair(j, *(new std::vector<char>)));
                graph.find(d)->second.find(j)->second.push_back(c);
            }
            else if (std::find(graph.find(d)->second.find(j)->second.begin(), graph.find(d)->second.find(j)->second.end(), c) == graph.find(d)->second.find(j)->second.end())
                graph.find(d)->second.find(j)->second.push_back(c);
            std::sort(graph.find(c)->second.find(j)->second.begin(), graph.find(c)->second.find(j)->second.end());
            std::sort(graph.find(d)->second.find(j)->second.begin(), graph.find(d)->second.find(j)->second.end());
        }
    }

    // Draw Graph
    for (auto it = graph.begin(); it != graph.end(); it++)
    {
        std::cout << it->first << " [ ";
        for (auto it2 = it->second.begin(); it2 != it->second.end(); it2++)
        {
            std::cout << "(" << it2->first << ", "
                      << "(";
            for (auto it3 = it2->second.begin(); it3 != it2->second.end(); it3++)
            {
                std::cout << *(it3);
                if (it3 + 1 != it2->second.end())
                    std::cout << ", ";
            }
            std::cout << ")) ";
        }
        std::cout << "]" << std::endl;
    }

    // MST
    std::vector<int> mst;
    std::pair<int, char> *p;
    k = 0;
    for (auto it = graph.begin(); it != graph.end(); it++)
    {
        std::map<int, std::vector<char>> *it2;
        std::vector<char> visited;
        std::queue<std::pair<int, char>> queued;
        queued.push(std::pair<int, char> (0, it->first));
        while (!queued.empty())
        {
            p = &queued.front();
            queued.pop();
            if (std::find(visited.begin(), visited.end(), p->second) == visited.end())
            {
                visited.push_back(c);
                it2 = &graph.find(c)->second;
                for (i = 0; i < (int) it2->size(); i++)
                {
                    for(j = 0; j < (int) it2->at(i).size(); j++)
                    {
                    }
                }
            }
        }
    }
    std::map<char, std::map<int, std::vector<char>>>::iterator start_point = graph.begin();

    std::vector<char> visited;
    visited.push_back(graph.begin()->first);

    // std::map<char, int> vertex = graph.begin()->second;
    // std::sort(vertex.begin(), vertex.end());

    // int current_length = -1;
    // std::map<std::string, int> cache;
    // std::vector<char> visited;
    // std::vector<std::map<char, int>::iterator> queued;
    // for (auto it = graph.begin(); it != graph.end(); it++)
    // {
    //     visited.clear();
    //     visited.push_back(it->first);
    //     queued.push_back(it->second.begin());
    // }

    // Return
    return 0;
}