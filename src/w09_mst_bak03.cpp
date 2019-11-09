#include <iostream>
#include <fstream>
#include <map>
#include <vector>
#include <queue>

/* Input Method Return Function */
std::istream &init_input(int argc, char *argv[])
{
    if (argc == 2)
        return *(new std::ifstream(argv[1]));
    return std::cin;
}

class vertex
{
private:
    char edge_end;
    int weight;

public:
    explicit vertex(char edge, int weight)
    {
        this->edge_end = edge;
        this->weight = weight;
    };
    const char get_edge_end() { return this->edge_end; };
    const int get_weight() { return this->weight; };
};

class end_point : public vertex
{
private:
    char edge_start;

public:
    explicit end_point(char edge_start, char edge_end, int weight)
        : vertex(edge_end, weight) { this->edge_start = edge_start; };
    const char get_edge_start() { return this->edge_start; };
};

int main(int argc, char *argv[])
{
    // Initialize Variables
    std::istream &in = init_input(argc, argv); // Input Stream
    std::map<char, std::vector<vertex> *> graph;

    int n, m;
    in >> n;
    in >> m;
    char c;
    for (int i = 0; i < n; i++)
    {
        in >> c;
        graph.insert(std::make_pair(c, new std::vector<vertex>));
    }
    std::vector<vertex> *list;
    char d;
    int j;
    bool f;
    for (int i = 0; i < m; i++)
    {
        in >> c;
        in >> d;
        in >> j;
        if (graph.find(c) != graph.end())
        {
            list = graph.find(c)->second;
            f = true;
            for (auto it = list->begin(); it != list->end(); it++)
                if (it->get_edge_end() == d && it->get_weight() == j)
                {
                    f = false;
                    break;
                }
            if (f)
            {
                list->push_back(vertex(d, j));
                list = graph.find(d)->second;
                list->push_back(vertex(c, j));
            }
        }
    }

    // BFS
    std::vector<char> visited;
    std::queue<end_point> queued;
    c = graph.begin()->first;
    queued.push(end_point('\0', c, 0));
    end_point *p;
    while (!queued.empty())
    {
        p = &queued.front();
        queued.pop();
        list = graph.at(p->get_edge_end());
        for (auto it = list->begin(); it != list->end(); it++)
        {
            f = true;
            for (auto it_v = visited.begin(); it_v != visited.end(); it_v++)
            {
                if (it->get_edge_end() == (*it_v))
                    f = false;
            }
            if (f)
            {
                queued.push(end_point(p->get_edge_start(), it->get_edge_end(), it->get_weight()));
            }
        }
        visited.push_back(p->get_edge_end());
    }

    // Output Graph
    for (auto it = graph.begin(); it != graph.end(); it++)
    {
        std::cout << it->first;
        for (auto it_v = it->second->begin(); it_v != it->second->end(); it_v++)
            std::cout << " (" << it_v->get_edge_end() << ", " << it_v->get_weight() << ")";
        std::cout << std::endl;
    }

    // Output BFS
    for (auto it = visited.begin(); it != visited.end(); it++)
        std::cout << (*it) << " ";
    std::cout << std::endl;

    // Return Main
    return 0;
}