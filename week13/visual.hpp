#ifndef VISUAL_HPP
#define VISUAL_HPP

#include <unistd.h>
#include <cstdlib>
#include <iostream>
#include <queue>
#include <vector>
#include <random>
#include "canvas.hpp"

class Visual
{
private:
    enum Group
    {
        Null,
        Fold,
        Tree,
        Cross
    };

    Group type;
    std::random_device rd;
    std::mt19937_64 rnd;
    std::uniform_int_distribution<long long int> blockGroupDistribution;
    std::uniform_int_distribution<long long int> blockTypeDistribution;
    std::pair<int, int> *controlPoint;
    Canvas *canvas;
    int width, height, score, rotation;

    std::vector<std::pair<int, int> *> *adjacent(Block::Type t, int x, int y);
    bool contact();
    bool create();
    bool collide(void);

public:
    Visual(int w, int h);
    void draw(void);
    void clear(void);
    bool gravity(void);
    bool gravity_max(void);
    bool update(void);
    bool move(int dx, int dy);
    bool rotate(int degree);
    int getScore();
};

#endif // VISUAL_HPP