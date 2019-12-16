#ifndef VISUAL_HPP
#define VISUAL_HPP

#include <cstdlib>
#include <iostream>
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
    int width, height, score;

    bool contact()
    {
        switch (type)
        {
        case Group::Fold:
            if (controlPoint->second + 1 >= height)
                return true;
            if (canvas->get(controlPoint->first - 1, controlPoint->second + 1)->getType() == Block::Type::Blank)
                if (canvas->get(controlPoint->first, controlPoint->second + 1)->getType() == Block::Type::Blank)
                    return false;
            break;
        case Group::Tree:
            if (controlPoint->second + 2 >= height)
                return true;
            if (canvas->get(controlPoint->first, controlPoint->second + 2)->getType() == Block::Type::Blank)
                return false;
            break;
        case Group::Cross:
            if (controlPoint->second + 2 >= height)
                return true;
            if (canvas->get(controlPoint->first - 1, controlPoint->second + 1)->getType() == Block::Type::Blank)
                if (canvas->get(controlPoint->first + 1, controlPoint->second + 1)->getType() == Block::Type::Blank)
                    if (canvas->get(controlPoint->first, controlPoint->second + 2)->getType() == Block::Type::Blank)
                        return false;
            break;
        default:
            return true;
        }
        return true;
    }

public:
    bool create()
    {
        // Intialize
        type = static_cast<Group>(blockGroupDistribution(rnd));
        std::vector<Block *> stack;
        if (type < Cross)
        {
            for (int i = 0; i < 3; i++)
                switch (static_cast<Block::Type>(blockTypeDistribution(rnd)))
                {
                case Block::Type::Gray:
                    stack.push_back(new Block_Gray());
                    break;
                case Block::Type::Red:
                    stack.push_back(new Block_Red());
                    break;
                case Block::Type::Green:
                    stack.push_back(new Block_Green());
                    break;
                case Block::Type::Blue:
                    stack.push_back(new Block_Blue());
                    break;
                default:
                    throw std::runtime_error("visual create block type undefined");
                }
        }
        else
        {
            for (int i = 0; i < 5; i++)
                switch (static_cast<Block::Type>(blockTypeDistribution(rnd)))
                {
                case Block::Type::Gray:
                    stack.push_back(new Block_Gray());
                    break;
                case Block::Type::Red:
                    stack.push_back(new Block_Red());
                    break;
                case Block::Type::Green:
                    stack.push_back(new Block_Green());
                    break;
                case Block::Type::Blue:
                    stack.push_back(new Block_Blue());
                    break;
                default:
                    throw std::runtime_error("visual create block type undefined");
                }
        }

        // Check space
        switch (type)
        {
        case Group::Fold:
            if (canvas->get(width / 2, 0)->getType() != Block::Type::Blank)
                return false;
            if (canvas->get(width / 2, 1)->getType() != Block::Type::Blank)
                return false;
            if (canvas->get((width / 2) - 1, 1)->getType() != Block::Type::Blank)
                return false;

            canvas->remove(width / 2, 0);
            canvas->remove(width / 2, 1);
            canvas->remove((width / 2) - 1, 1);

            canvas->put(width / 2, 0, stack.back());
            stack.pop_back();
            canvas->put(width / 2, 1, stack.back());
            stack.pop_back();
            canvas->put((width / 2) - 1, 1, stack.back());
            stack.pop_back();
            break;
        case Group::Tree:
            if (canvas->get(width / 2, 0)->getType() != Block::Type::Blank)
                return false;
            if (canvas->get(width / 2, 1)->getType() != Block::Type::Blank)
                return false;
            if (canvas->get(width / 2, 2)->getType() != Block::Type::Blank)
                return false;

            canvas->remove(width / 2, 0);
            canvas->remove(width / 2, 1);
            canvas->remove(width / 2, 2);

            canvas->put(width / 2, 0, stack.back());
            stack.pop_back();
            canvas->put(width / 2, 1, stack.back());
            stack.pop_back();
            canvas->put(width / 2, 2, stack.back());
            stack.pop_back();
            break;
        case Group::Cross:
            if (canvas->get(width / 2, 0)->getType() != Block::Type::Blank)
                return false;
            if (canvas->get((width / 2) - 1, 1)->getType() != Block::Type::Blank)
                return false;
            if (canvas->get(width / 2, 1)->getType() != Block::Type::Blank)
                return false;
            if (canvas->get((width / 2) + 1, 1)->getType() != Block::Type::Blank)
                return false;
            if (canvas->get(width / 2, 2)->getType() != Block::Type::Blank)
                return false;

            canvas->remove(width / 2, 0);
            canvas->remove((width / 2) - 1, 1);
            canvas->remove(width / 2, 1);
            canvas->remove((width / 2) + 1, 1);
            canvas->remove(width / 2, 2);

            canvas->put(width / 2, 0, stack.back());
            stack.pop_back();
            canvas->put((width / 2) - 1, 1, stack.back());
            stack.pop_back();
            canvas->put(width / 2, 1, stack.back());
            stack.pop_back();
            canvas->put((width / 2) + 1, 1, stack.back());
            stack.pop_back();
            canvas->put(width / 2, 2, stack.back());
            stack.pop_back();
            break;
        default:
            throw std::runtime_error("visual create group type undefined");
        }
        controlPoint = new std::pair<int, int>(width / 2, 1);
        return true;
    }
    Visual(int w, int h) : rd(), rnd(rd()), blockGroupDistribution(1, 3), blockTypeDistribution(1, 4)
    {
        width = w;
        height = h;
        score = 0;
        type = Group::Null;
        canvas = new Canvas(width, height);
    }
    void draw(void)
    {
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
                std::cout << canvas->get(x, y)->toString() << "  ";
            std::cout << std::endl;
        }
    }
    void clear(void)
    {
        if (system("clear"))
            throw std::runtime_error("visual clear failed");
    }
    bool collide(void)
    {
        return false;
    }
    bool gravity(void)
    {
        bool updated = false;
        for (int y = height - 1; y > 0; y--)
            for (int x = 0; x < width; x++)
                if (canvas->get(x, y)->getType() == Block::Type::Blank)
                    if (canvas->get(x, y - 1)->getType() != Block::Type::Blank)
                    {
                        canvas->swap(x, y - 1, x, y);
                        updated = true;
                    }
        if (updated)
            controlPoint->second++;
        return updated;
    }
    bool gravity_max(void)
    {
        if (gravity())
        {
            while (gravity())
                ;
            return true;
        }
        else
            return false;
    }
    bool update(void)
    {
        if (contact())
            gravity_max();
        if (!gravity())
        {
            while (collide())
            {
                score++;
                gravity_max();
            }
            if (!create())
                return false;
        }
        return true;
    }
    bool move(int dx, int dy)
    {
        switch (type)
        {
        case Group::Fold:
            if ((controlPoint->first - 1 + dx < 0) ||
                (controlPoint->first + dx >= width) ||
                (controlPoint->second - 1 + dy < 0) ||
                (controlPoint->second + dy >= height))
                return false;

            if (dx == -1 && dy == 0)
            {
                if (canvas->get(controlPoint->first - 1, controlPoint->second - 1)->getType() != Block::Type::Blank)
                    return false;
                if (canvas->get(controlPoint->first - 2, controlPoint->second)->getType() != Block::Type::Blank)
                    return false;
                canvas->swap(controlPoint->first - 1, controlPoint->second - 1, controlPoint->first, controlPoint->second - 1);
                canvas->swap(controlPoint->first - 2, controlPoint->second, controlPoint->first - 1, controlPoint->second);
                canvas->swap(controlPoint->first - 1, controlPoint->second, controlPoint->first, controlPoint->second);
                controlPoint->first--;
            }
            else if (dx == 0 && dy == 1)
            {
                if (canvas->get(controlPoint->first - 1, controlPoint->second + 1)->getType() != Block::Type::Blank)
                    return false;
                if (canvas->get(controlPoint->first, controlPoint->second + 1)->getType() != Block::Type::Blank)
                    return false;
                canvas->swap(controlPoint->first - 1, controlPoint->second + 1, controlPoint->first - 1, controlPoint->second);
                canvas->swap(controlPoint->first, controlPoint->second + 1, controlPoint->first, controlPoint->second);
                canvas->swap(controlPoint->first, controlPoint->second, controlPoint->first, controlPoint->second - 1);
                controlPoint->second++;
            }
            else if (dx == 1 && dy == 0)
            {
                if (canvas->get(controlPoint->first + 1, controlPoint->second - 1)->getType() != Block::Type::Blank)
                    return false;
                if (canvas->get(controlPoint->first + 1, controlPoint->second)->getType() != Block::Type::Blank)
                    return false;
                canvas->swap(controlPoint->first + 1, controlPoint->second - 1, controlPoint->first, controlPoint->second - 1);
                canvas->swap(controlPoint->first + 1, controlPoint->second, controlPoint->first, controlPoint->second);
                canvas->swap(controlPoint->first, controlPoint->second, controlPoint->first - 1, controlPoint->second);
                controlPoint->first++;
            }
            break;
        case Group::Tree:
            if ((controlPoint->first + dx < 0) ||
                (controlPoint->first + dx >= width) ||
                (controlPoint->second - 1 + dy < 0) ||
                (controlPoint->second + 1 + dy >= height))
                return false;

            if (dx == -1 && dy == 0)
            {
                for (int y = -1; y < 2; y++)
                    if (canvas->get(controlPoint->first - 1, controlPoint->second + y)->getType() != Block::Type::Blank)
                        return false;
                for (int y = -1; y < 2; y++)
                    canvas->swap(controlPoint->first - 1, controlPoint->second + y, controlPoint->first, controlPoint->second + y);
                controlPoint->first--;
            }
            else if (dx == 0 && dy == 1)
            {
                if (canvas->get(controlPoint->first, controlPoint->second + 2)->getType() != Block::Type::Blank)
                    return false;
                for (int y = 2; y >= 0; y--)
                    canvas->swap(controlPoint->first, controlPoint->second + y, controlPoint->first, controlPoint->second + (y - 1));
                controlPoint->second++;
            }
            else if (dx == 1 && dy == 0)
            {
                for (int y = -1; y < 2; y++)
                    if (canvas->get(controlPoint->first + 1, controlPoint->second + y)->getType() != Block::Type::Blank)
                        return false;
                for (int y = -1; y < 2; y++)
                    canvas->swap(controlPoint->first + 1, controlPoint->second + y, controlPoint->first, controlPoint->second + y);
                controlPoint->first++;
            }
            break;
        case Group::Cross:
            if ((controlPoint->first - 1 + dx < 0) ||
                (controlPoint->first + 1 + dx >= width) ||
                (controlPoint->second - 1 + dy < 0) ||
                (controlPoint->second + 1 + dy >= height))
                return false;
            if (dx == -1 && dy == 0)
            {
                if (canvas->get(controlPoint->first - 1, controlPoint->second - 1)->getType() != Block::Type::Blank)
                    return false;
                if (canvas->get(controlPoint->first - 2, controlPoint->second)->getType() != Block::Type::Blank)
                    return false;
                if (canvas->get(controlPoint->first - 1, controlPoint->second + 1)->getType() != Block::Type::Blank)
                    return false;
                canvas->swap(controlPoint->first - 1, controlPoint->second - 1, controlPoint->first, controlPoint->second - 1);
                for (int x = 0; x < 3; x++)
                    canvas->swap(controlPoint->first + (x - 2), controlPoint->second, controlPoint->first + (x - 1), controlPoint->second);
                canvas->swap(controlPoint->first - 1, controlPoint->second + 1, controlPoint->first, controlPoint->second + 1);
                controlPoint->first--;
            }
            else if (dx == 0 && dy == 1)
            {
                if (canvas->get(controlPoint->first - 1, controlPoint->second + 1)->getType() != Block::Type::Blank)
                    return false;
                if (canvas->get(controlPoint->first, controlPoint->second + 2)->getType() != Block::Type::Blank)
                    return false;
                if (canvas->get(controlPoint->first + 1, controlPoint->second + 1)->getType() != Block::Type::Blank)
                    return false;
                canvas->swap(controlPoint->first - 1, controlPoint->second, controlPoint->first - 1, controlPoint->second + 1);
                canvas->swap(controlPoint->first + 1, controlPoint->second, controlPoint->first + 1, controlPoint->second + 1);
                for (int y = 2; y >= 0; y--)
                    canvas->swap(controlPoint->first, controlPoint->second + y, controlPoint->first, controlPoint->second + (y - 1));
                controlPoint->second++;
            }
            else if (dx == 1 && dy == 0)
            {
                if (canvas->get(controlPoint->first + 1, controlPoint->second - 1)->getType() != Block::Type::Blank)
                    return false;
                if (canvas->get(controlPoint->first + 2, controlPoint->second)->getType() != Block::Type::Blank)
                    return false;
                if (canvas->get(controlPoint->first + 1, controlPoint->second + 1)->getType() != Block::Type::Blank)
                    return false;
                canvas->swap(controlPoint->first + 1, controlPoint->second - 1, controlPoint->first, controlPoint->second - 1);
                for (int x = 2; x >= 0; x--)
                    canvas->swap(controlPoint->first + x, controlPoint->second, controlPoint->first + (x - 1), controlPoint->second);
                canvas->swap(controlPoint->first + 1, controlPoint->second + 1, controlPoint->first, controlPoint->second + 1);
                controlPoint->first++;
            }
            break;
        default:
            return false;
        }
        return true;
    }
    int getScore() { return score; }
};

#endif // VISUAL_HPP