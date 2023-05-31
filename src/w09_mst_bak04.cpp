#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <map>
#include <set>
#include <queue>

class edge
{
private:
    char n1;
    char n2;
    int weight;

public:
    explicit edge(char c1, char c2, int weight)
    {
        if (c1 < c2)
        {
            this->n1 = c1;
            this->n2 = c2;
        }
        else
        {
            this->n1 = c2;
            this->n2 = c1;
        }
        this->weight = weight;
    }
    const char node_front(void) { return this->n1; }
    const char node_end(void) { return this->n2; }
    int get_weight(void) { return this->weight; }
};

class vertex
{
private:
    char node;
    int weight;

public:
    explicit vertex(char node, int weight)
    {
        this->node = node;
        this->weight = weight;
    }
    const char get_node(void) { return this->node; }
    const int get_weight(void) { return this->weight; }
    void set_weight(const int weight) { this->weight = weight; }
};

/* Input Method Return Function */
std::istream &init_input(int argc, char *argv[])
{
    if (argc == 2)
        return *(new std::ifstream(argv[1]));
    return std::cin;
}

bool loop_check(edge *edge_pointer, std::vector<edge *> graph_erased)
{
    std::vector<edge *> graph(graph_erased);
    std::set<char> visited;
    std::queue<char> queued;
    queued.push(edge_pointer->node_front());
    char c;
    while (!queued.empty())
    {
        c = queued.front();
        queued.pop();
        visited.insert(c);
        for (auto it = graph.begin(); it != graph.end(); it++)
        {
            if ((*it)->node_front() == c)
            {
                queued.push((*it)->node_end());
                graph.erase(it);
                break;
            }
            else if ((*it)->node_end() == c)
            {
                queued.push((*it)->node_front());
                graph.erase(it);
                break;
            }
        }
    }
    for (auto it = visited.begin(); it != visited.end(); it++)
        if (*it == edge_pointer->node_end())
            return false;

    return true;
};

int main(int argc, char *argv[])
{
    // Initialize Variables
    std::istream &in = init_input(argc, argv); // Input Stream
    std::vector<char> node;
    std::vector<edge *> graph;

    // Creating Graph
    int n, m;
    in >> n;
    in >> m;
    char c;
    for (int i = 0; i < n; i++)
    {
        in >> c;
        node.push_back(c);
    }
    char d;
    int j;
    for (int i = 0; i < m; i++)
    {
        in >> c;
        in >> d;
        in >> j;
        graph.push_back(new edge(c, d, j));
    }

    // Backup Graph
    std::vector<edge *> graph_original(graph);

    // Kruskal Algorithm
    std::set<char> visited;
    std::vector<edge *> graph_linked;
    std::vector<edge *> graph_erased;
    int mst = 0;
    while (true)
    {
        edge *edge_pointer = *(graph.begin());
        for (auto it = graph.begin(); it != graph.end(); it++)
        {
            if ((*it)->get_weight() < edge_pointer->get_weight())
                edge_pointer = *it;
        }
        if (visited.find(edge_pointer->node_front()) != visited.end() && visited.find(edge_pointer->node_end()) != visited.end())
        {
            if (loop_check(edge_pointer, graph_erased))
            {
                graph_linked.push_back(edge_pointer);
                mst = mst + edge_pointer->get_weight();
            }
        }
        else if (visited.find(edge_pointer->node_front()) == visited.end() || visited.find(edge_pointer->node_end()) == visited.end())
        {
            graph_linked.push_back(edge_pointer);
            mst = mst + edge_pointer->get_weight();
            visited.insert(edge_pointer->node_front());
            visited.insert(edge_pointer->node_end());
        }
        graph_erased.push_back(edge_pointer);
        graph.erase(std::remove(graph.begin(), graph.end(), edge_pointer));
        if ((int)visited.size() == n)
            break;
    }
    int original_mst = mst;
    // std::cout << mst << std::endl;

    // Print Linked Graph
    // for (auto it = graph_linked.begin(); it != graph_linked.end(); it++)
    //     std::cout
    //         << "(" << (*it)->node_front() << "--" << (*it)->get_weight() << "--" << (*it)->node_end() << ")" << std::endl;

    // Krukal Algorithm Brute-Force
    std::vector<int> mst_v;
    for (auto it = graph_original.begin(); it != graph_original.end(); it++)
    {
        std::set<char> visited_b;
        std::vector<edge *> graph_b(graph_original);
        for (auto it_g = graph_b.begin(); it_g != graph_b.end(); it_g++)
        {
            if (*it_g == *it)
            {
                graph_b.erase(it_g);
                break;
            }
        }
        std::vector<edge *> graph_b_erased;
        mst = 0;
        while (true)
        {
            edge *edge_pointer = *(graph_b.begin());
            for (auto it = graph_b.begin(); it != graph_b.end(); it++)
            {
                if ((*it)->get_weight() < edge_pointer->get_weight())
                    edge_pointer = *it;
            }
            if (visited_b.find(edge_pointer->node_front()) != visited_b.end() && visited_b.find(edge_pointer->node_end()) != visited_b.end())
            {
                if (loop_check(edge_pointer, graph_b_erased))
                {
                    mst = mst + edge_pointer->get_weight();
                }
            }
            else if (visited_b.find(edge_pointer->node_front()) == visited_b.end() || visited_b.find(edge_pointer->node_end()) == visited_b.end())
            {
                mst = mst + edge_pointer->get_weight();
                visited_b.insert(edge_pointer->node_front());
                visited_b.insert(edge_pointer->node_end());
            }
            graph_b_erased.push_back(edge_pointer);
            graph_b.erase(std::remove(graph_b.begin(), graph_b.end(), edge_pointer));
            if ((int)visited_b.size() == n)
                break;
        }
        mst_v.push_back(mst);
    }

    // Print Graph
    // for (auto it = graph.begin(); it != graph.end(); it++)
    //     std::cout
    //         << "(" << (*it)->node_front() << "--" << (*it)->get_weight() << "--" << (*it)->node_end() << ")" << std::endl;

    // Print Calculated MSTs
    // std::cout << original_mst << std::endl;
    mst = -1;
    for (auto it = mst_v.begin(); it != mst_v.end(); it++)
        if ((((*it) < mst) && ((*it) != original_mst)) || ((mst == -1) && ((*it) != original_mst)))
            mst = (*it);
    std::cout << mst << std::endl;
    // mst = *(mst_v.begin());
    // for (auto it = mst_v.begin(); it != mst_v.end(); it++)
    //     if (*it < mst)
    //         mst = *it;

    // std::cout << mst << std::endl;

    // Return Main
    return 0;
}