#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>

std::vector<char> vertices;
std::vector<std::vector<std::pair<int, int>>> mst; // Minimum Spanning Tree
int total_edge;

bool merge(char c, char d, int i)
{
    std::find(mst.begin(), mst.end(), c)->push_back({d, i});
    std::find(mst.begin(), mst.end(), d)->push_back({c, i});
    total_edge = total_edge + i;

}

/* Input Method Return Function */
std::istream &init_input(int argc, char *argv[])
{
    if (argc == 2)
        return *(new std::ifstream(argv[1]));
    return std::cin;
}

/* Main Function */
int main(int argc, char *argv[])
{
    std::istream &in = init_input(argc, argv); // Input Stream
    std::vector<std::pair<int, std::pair<char, char>>> vertex;

    int n, m;
    in >> n;
    in >> m;

    // Input Vertex
    int i;
    char c;
    for (i = 0; i < n; i++)
    {
        in >> c;
        vertices.push_back(c);
    }

    // Input Edge
    char d;
    int j;
    for (i = 0; i < m; i++)
    {
        in >> c;
        in >> d;
        in >> j;
        vertex.push_back({j, {c, d}});
    }

    // Sort By Priority
    std::sort(vertex.begin(), vertex.end());

    for (i = 0; i < m; i++)
    {
        if (merge(vertex[i].second.first, vertex[i].second.second, vertex[i].first))
        {
            
        }
    }

    // Return Main
    return 0;
}