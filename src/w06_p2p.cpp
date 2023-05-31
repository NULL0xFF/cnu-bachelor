#include <iostream>
#include <algorithm>
#include <map>
#include <vector>
#include <string>
#include <queue>

// Class for wave_length queue noding
class cache
{
private:
    std::string value;
    int index;

public:
    cache(std::string V, int I)
    {
        cache::value = V;
        cache::index = I;
    }
    std::string getValue() { return cache::value; }
    int getIndex() { return cache::index; }
};

// Graph Wave Length
int wave_length(std::map<std::string, std::vector<std::string> *> graph, std::string input);

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
                list = graph.find(input[1])->second;
                list->push_back(input[0]);
            }
        }
        else
            return 1; // key not found
    }

    // Input
    std::cin >> input[0];

    // Output
    std::cout << wave_length(graph, input[0]);

    // Return
    return 0;
}

int wave_length(std::map<std::string, std::vector<std::string> *> graph, std::string input)
{
    // Exception
    if (graph.find(input) == graph.end())
        return -1;

    // Initialize
    int length = 0;

    // BFS
    std::map<std::string, int> visited;
    std::queue<cache *> queue_;
    cache *node;
    queue_.push(new cache(input, 0));
    while (!queue_.empty())
    {
        node = queue_.front();
        queue_.pop();
        if (visited.find(node->getValue()) == visited.end())
            visited.insert(std::make_pair(node->getValue(), node->getIndex()));
        else if (node->getIndex() >= visited.find(node->getValue())->second)
            continue;
        std::vector<std::string> *graph_value;
        graph_value = graph.find(node->getValue())->second;
        for (auto it = graph_value->begin(); it != graph_value->end(); it++)
            queue_.push(new cache(*it, node->getIndex() + 1));
    }

    // Path
    int path;
    for (auto it = visited.begin(); it != visited.end(); it++)
    {
        path = it->second;
        if (length < path)
            length = path;
    }

    // Return
    return length;
}