#include <iostream>
#include <fstream>
#include <string>
#include <map>

/* 
 * Input Method Return Function
 */
std::istream *init_input(int argc, char *argv[])
{
    if (argc == 1)
        return &std::cin;
    if (argc == 2)
        return new std::ifstream(argv[1]);
    std::cerr << "too many arguments" << std::endl;
    exit(1);
}

int main(int argc, char *argv[])
{
    // Initialize Variable
    std::istream *in = init_input(argc, argv);
    std::map<int, std::multimap<int, int> *> graph;
    int V, E, K, u, v, w, i;

    // Input
    *in >> V;
    *in >> E;
    *in >> K;
    for (i = 0; i < V; i++)
        graph.insert(std::make_pair(i + 1, new std::multimap<int, int>));
    for (i = 0; i < E; i++)
    {
        *in >> u;
        *in >> v;
        *in >> w;
        graph.find(u)->second->insert(std::make_pair(v, w));
    }
    
    // Algorithm
    

    // Output (Debug)
    for (auto it = graph.begin(); it != graph.end(); it++)
    {
        std::cout << it->first << ":";
        for (auto it2 = it->second->begin(); it2 != it->second->end(); it2++)
            std::cout << " [" << it2->first << ", " << it2->second << "]";
        std::cout << std::endl;
    }

    return 0;
}