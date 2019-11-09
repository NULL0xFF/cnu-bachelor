#include <iostream>
#include <fstream>
#include <vector>
#include <map>
#include <algorithm>

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

    // Set Graph Scale
    char c;
    int n, m;
    in >> n;
    in >> m;
    for (int i = 0; i < n; i++)
    {
        in >> c;
        graph.insert(std::make_pair(c, *(new std::map<int, std::vector<char>>)));
    }

    // Create Graph
    char d;
    int j;
    for (int i = 0; i < m; i++)
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
    std::map<char, std::map<int, std::vector<char>>> graph_work(graph);
    std::map<char, int> mst;
    for (auto it1 = graph_work.begin(); it1 != graph_work.end(); it1++)
    {
        for (auto it2 = it1->second.begin(); it2 != it1->second.end(); it2++)
        {
            for (auto it3 = it2->second.begin(); it3 != it2->second.end(); it3++)
            {
                if (mst.find(*it3) == mst.end())
                {
                    mst.insert(std::make_pair(*it3, it2->first));
                    mst.insert(std::make_pair(it1->first, -1));
                }
                else if (mst.find(*it3)->second == it2->first)
                    continue;
                else if (mst.find(*it3)->second == -1)
                    mst.find(*it3)->second = it2->first;
                else if(mst.find(*it3)->second )
                    ;
                else if (it2->first < mst.find(*it3)->second)
                    mst.find(*it3)->second = it2->first;
            }
        }
    }

    // Print MST
    for (auto it = mst.begin(); it != mst.end(); it++)
        std::cout << "(" << it->first << ", " << it->second << ")" << std::endl;

    // Second MST
    // Return Main
    return 0;
}