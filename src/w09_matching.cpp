#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>
/* Athlete Class */
class athlete
{
private:
    int team_number;
    int value;

public:
    explicit athlete(int team_number, int value)
    {
        this->team_number = team_number;
        this->value = value;
    };
    int get_team_number(void) { return this->team_number; };
    int get_value(void) { return this->value; };
    static bool compare(athlete a1, athlete a2)
    {
        if (a1.get_value() < a2.get_value())
            return true;
        else if (a1.get_value() == a2.get_value())
            return a1.get_team_number() < a2.get_team_number();
        return false;
    };
};
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
    // Initialize Variable
    std::istream &in = init_input(argc, argv);
    int a, b, i, j, k, n, m, x;
    std::vector<athlete> input_list;
    // Input
    in >> n;
    in >> m;
    for (i = 0; i < n; i++)
        for (j = 0; j < m; j++)
        {
            in >> x;
            input_list.push_back(athlete(i, x));
        }
    // Sort
    std::sort(input_list.begin(), input_list.end(), athlete::compare);
    // Difference Check
    athlete *queue[n];
    for (i = 0; i < n; i++)
        queue[i] = nullptr;
    x = 0;  // Queue Flag
    k = -1; // Minimum Difference
    for (auto it = input_list.begin(); it != input_list.end(); it++)
    {
        queue[it->get_team_number()] = &(*it);
        // Queue Flag Check
        if (x == 0)
        {
            j = 0;
            for (i = 0; i < n; i++)
                if (queue[i] != nullptr)
                    j++;
            if (j == n)
                x = 1;
        }
        // Queue Ready
        if (x == 1)
        {
            a = 0;
            b = 0;
            if (queue[0]->get_value() <= queue[1]->get_value())
            {
                a = queue[0]->get_value();
                b = queue[1]->get_value();
            }
            else
            {
                a = queue[1]->get_value();
                b = queue[0]->get_value();
            }
            for (i = 2; i < n; i++)
                if (queue[i]->get_value() < a)
                    a = queue[i]->get_value();
                else if (b < queue[i]->get_value())
                    b = queue[i]->get_value();
            if ((b - a) < k)
                k = (b - a);
            else if (k == -1)
                k = (b - a);
        }
    }
    // Print
    std::cout << k << std::endl;
    // Return
    return 0;
}