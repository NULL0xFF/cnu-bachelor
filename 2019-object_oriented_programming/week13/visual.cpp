#include "visual.hpp"

Visual::Visual(int w, int h) : rd(), rnd(rd()), blockGroupDistribution(1, 3), blockTypeDistribution(1, 4)
{
    width = w;
    height = h;
    score = 0;
    rotation = 0;
    type = Group::Null;
    canvas = new Canvas(width, height);
}
std::vector<std::pair<int, int> *> *Visual::adjacent(Block::Type t, int x, int y)
{
    std::vector<std::pair<int, int> *> *list = new std::vector<std::pair<int, int> *>();
    if (x - 1 >= 0)
    {
        if (canvas->get(x - 1, y)->getType() == canvas->get(x, y)->getType())
            list->push_back(new std::pair<int, int>(x - 1, y));
        else if (t != Block::Type::Gray && canvas->get(x - 1, y)->getType() == Block::Type::Gray)
            list->push_back(new std::pair<int, int>(x - 1, y));
    }
    if (x + 1 < this->width)
    {
        if (canvas->get(x + 1, y)->getType() == canvas->get(x, y)->getType())
            list->push_back(new std::pair<int, int>(x + 1, y));
        else if (t != Block::Type::Gray && canvas->get(x + 1, y)->getType() == Block::Type::Gray)
            list->push_back(new std::pair<int, int>(x + 1, y));
    }
    if (y - 1 >= 0)
    {
        if (canvas->get(x, y - 1)->getType() == canvas->get(x, y)->getType())
            list->push_back(new std::pair<int, int>(x, y - 1));
        else if (t != Block::Type::Gray && canvas->get(x, y - 1)->getType() == Block::Type::Gray)
            list->push_back(new std::pair<int, int>(x, y - 1));
    }
    if (y + 1 < this->height)
    {
        if (canvas->get(x, y + 1)->getType() == canvas->get(x, y)->getType())
            list->push_back(new std::pair<int, int>(x, y + 1));
        else if (t != Block::Type::Gray && canvas->get(x, y + 1)->getType() == Block::Type::Gray)
            list->push_back(new std::pair<int, int>(x, y + 1));
    }
    return list;
}
bool Visual::contact(void)
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
bool Visual::create(void)
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
    rotation = 0;
    return true;
}
bool Visual::collide(void)
{
    clear();
    draw();
    bool collision = false;
    for (int y = height - 1; y >= 0; y--)
        for (int x = 0; x < width; x++)
        {
            Block::Type currentType = canvas->get(x, y)->getType();
            if (currentType == Block::Type::Blank || currentType == Block::Type::Gray)
                continue;
            std::pair<int, int> *p = new std::pair<int, int>(x, y);
            std::vector<std::pair<int, int> *> visited;
            std::queue<std::pair<int, int> *> queued;
            std::vector<std::pair<int, int> *> *list = nullptr;
            queued.push(p);
            while (!queued.empty())
            {
                p = queued.front();
                queued.pop();
                bool flag = true;
                for (auto it = visited.begin(); it != visited.end(); it++)
                    if ((*it)->first == p->first && (*it)->second == p->second)
                    {
                        flag = false;
                        break;
                    }
                if (flag)
                {
                    visited.push_back(p);
                    list = adjacent(currentType, p->first, p->second);
                    for (int i = 0; i < (int)list->size(); i++)
                        queued.push(list->at(i));
                }
            }
            if (visited.size() >= 4)
            {
                int countGray = 0;
                for (int i = 0; i < (int)visited.size(); i++)
                {
                    if (canvas->get(visited.at(i)->first, visited.at(i)->second)->getType() == Block::Type::Gray)
                        countGray++;
                }
                if ((visited.size() - countGray) >= 4)
                {
                    for (int i = 0; i < (int)visited.size(); i++)
                    {
                        canvas->remove(visited.at(i)->first, visited.at(i)->second);
                        canvas->put(visited.at(i)->first, visited.at(i)->second, new Block());
                    }
                    collision = true;
                }
            }
        }
    return collision;
}
void Visual::draw(void)
{
    for (int y = 0; y < height; y++)
    {
        for (int x = 0; x < width; x++)
            std::cout << canvas->get(x, y)->toString() << "  ";
        std::cout << std::endl;
    }
}
void Visual::clear(void)
{
    if (system("clear"))
        throw std::runtime_error("visual clear failed");
}
bool Visual::gravity(void)
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
bool Visual::gravity_max(void)
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
bool Visual::update(void)
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
bool Visual::move(int dx, int dy)
{
    switch (type)
    {
    case Group::Fold:
        if ((controlPoint->first - 1 + dx < 0) ||
            (controlPoint->first + dx >= width) ||
            (controlPoint->second - 1 + dy < 0) ||
            (controlPoint->second + dy >= height))
            return false;
        switch (rotation % 360)
        {
        case 0:
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
        case 90:
            if (dx == -1 && dy == 0)
            {
                if (canvas->get(controlPoint->first - 2, controlPoint->second - 1)->getType() != Block::Type::Blank)
                    return false;
                if (canvas->get(controlPoint->first - 2, controlPoint->second)->getType() != Block::Type::Blank)
                    return false;
                canvas->swap(controlPoint->first - 2, controlPoint->second - 1, controlPoint->first - 1, controlPoint->second - 1);
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
                canvas->swap(controlPoint->first - 1, controlPoint->second, controlPoint->first - 1, controlPoint->second - 1);
                canvas->swap(controlPoint->first, controlPoint->second + 1, controlPoint->first, controlPoint->second);
                controlPoint->second++;
            }
            else if (dx == 1 && dy == 0)
            {
                if (canvas->get(controlPoint->first, controlPoint->second - 1)->getType() != Block::Type::Blank)
                    return false;
                if (canvas->get(controlPoint->first + 1, controlPoint->second)->getType() != Block::Type::Blank)
                    return false;
                canvas->swap(controlPoint->first, controlPoint->second - 1, controlPoint->first - 1, controlPoint->second - 1);
                canvas->swap(controlPoint->first + 1, controlPoint->second, controlPoint->first, controlPoint->second);
                canvas->swap(controlPoint->first, controlPoint->second, controlPoint->first - 1, controlPoint->second);
                controlPoint->first++;
            }
            break;
        case 180:
            if (dx == -1 && dy == 0)
            {
                if (canvas->get(controlPoint->first - 2, controlPoint->second - 1)->getType() != Block::Type::Blank)
                    return false;
                if (canvas->get(controlPoint->first - 2, controlPoint->second)->getType() != Block::Type::Blank)
                    return false;
                canvas->swap(controlPoint->first - 2, controlPoint->second - 1, controlPoint->first - 1, controlPoint->second - 1);
                canvas->swap(controlPoint->first - 1, controlPoint->second - 1, controlPoint->first, controlPoint->second - 1);
                canvas->swap(controlPoint->first - 2, controlPoint->second, controlPoint->first - 1, controlPoint->second);
                controlPoint->first--;
            }
            else if (dx == 0 && dy == 1)
            {
                if (canvas->get(controlPoint->first - 1, controlPoint->second + 1)->getType() != Block::Type::Blank)
                    return false;
                if (canvas->get(controlPoint->first, controlPoint->second)->getType() != Block::Type::Blank)
                    return false;
                canvas->swap(controlPoint->first - 1, controlPoint->second + 1, controlPoint->first - 1, controlPoint->second);
                canvas->swap(controlPoint->first - 1, controlPoint->second, controlPoint->first - 1, controlPoint->second - 1);
                canvas->swap(controlPoint->first, controlPoint->second, controlPoint->first, controlPoint->second - 1);
                controlPoint->second++;
            }
            else if (dx == 1 && dy == 0)
            {
                if (canvas->get(controlPoint->first + 1, controlPoint->second - 1)->getType() != Block::Type::Blank)
                    return false;
                if (canvas->get(controlPoint->first, controlPoint->second)->getType() != Block::Type::Blank)
                    return false;
                canvas->swap(controlPoint->first + 1, controlPoint->second - 1, controlPoint->first, controlPoint->second - 1);
                canvas->swap(controlPoint->first, controlPoint->second - 1, controlPoint->first - 1, controlPoint->second - 1);
                canvas->swap(controlPoint->first, controlPoint->second, controlPoint->first - 1, controlPoint->second);
                controlPoint->first++;
            }
            break;
        case 270:
            if (dx == -1 && dy == 0)
            {
                if (canvas->get(controlPoint->first - 2, controlPoint->second - 1)->getType() != Block::Type::Blank)
                    return false;
                if (canvas->get(controlPoint->first - 1, controlPoint->second)->getType() != Block::Type::Blank)
                    return false;
                canvas->swap(controlPoint->first - 2, controlPoint->second - 1, controlPoint->first - 1, controlPoint->second - 1);
                canvas->swap(controlPoint->first - 1, controlPoint->second - 1, controlPoint->first, controlPoint->second - 1);
                canvas->swap(controlPoint->first - 1, controlPoint->second, controlPoint->first, controlPoint->second);
                controlPoint->first--;
            }
            else if (dx == 0 && dy == 1)
            {
                if (canvas->get(controlPoint->first - 1, controlPoint->second)->getType() != Block::Type::Blank)
                    return false;
                if (canvas->get(controlPoint->first, controlPoint->second + 1)->getType() != Block::Type::Blank)
                    return false;
                canvas->swap(controlPoint->first - 1, controlPoint->second, controlPoint->first - 1, controlPoint->second - 1);
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
                canvas->swap(controlPoint->first, controlPoint->second - 1, controlPoint->first - 1, controlPoint->second - 1);
                canvas->swap(controlPoint->first + 1, controlPoint->second, controlPoint->first, controlPoint->second);
                controlPoint->first++;
            }
            break;
        default:
            return false;
        }
        break;
    case Group::Tree:
        switch (rotation % 360)
        {
        case 0:
        case 180:
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
        case 90:
        case 270:
            if ((controlPoint->first - 1 + dx < 0) ||
                (controlPoint->first + 1 + dx >= width) ||
                (controlPoint->second + dy < 0) ||
                (controlPoint->second + dy >= height))
                return false;
            if (dx == -1 && dy == 0)
            {
                if (canvas->get(controlPoint->first - 2, controlPoint->second)->getType() != Block::Type::Blank)
                    return false;
                for (int x = -2; x < 1; x++)
                    canvas->swap(controlPoint->first + x, controlPoint->second, controlPoint->first + (x + 1), controlPoint->second);
                controlPoint->first--;
            }
            else if (dx == 0 && dy == 1)
            {
                for (int x = -1; x <= 1; x++)
                    if (canvas->get(controlPoint->first + x, controlPoint->second + 1)->getType() != Block::Type::Blank)
                        return false;
                for (int x = -1; x <= 1; x++)
                    canvas->swap(controlPoint->first + x, controlPoint->second + 1, controlPoint->first + x, controlPoint->second);
                controlPoint->second++;
            }
            else if (dx == 1 && dy == 0)
            {
                if (canvas->get(controlPoint->first + 2, controlPoint->second)->getType() != Block::Type::Blank)
                    return false;
                for (int x = 2; x >= 0; x--)
                    canvas->swap(controlPoint->first + x, controlPoint->second, controlPoint->first + (x - 1), controlPoint->second);
                controlPoint->first++;
            }
            break;
        default:
            return false;
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
bool Visual::rotate(int degree)
{
    if (degree == 90)
    {
        switch (type)
        {
        case Fold:
            switch (rotation % 360)
            {
            case 0:
                if (canvas->get(controlPoint->first - 1, controlPoint->second - 1)->getType() != Block::Type::Blank)
                    return false;
                break;
            case 90:
                if (canvas->get(controlPoint->first, controlPoint->second - 1)->getType() != Block::Type::Blank)
                    return false;
                break;
            case 180:
                if (canvas->get(controlPoint->first, controlPoint->second)->getType() != Block::Type::Blank)
                    return false;
                break;
            case 270:
                if (canvas->get(controlPoint->first - 1, controlPoint->second)->getType() != Block::Type::Blank)
                    return false;
                break;
            default:
                return false;
            }
            canvas->swap(controlPoint->first - 1, controlPoint->second - 1, controlPoint->first - 1, controlPoint->second);
            canvas->swap(controlPoint->first - 1, controlPoint->second, controlPoint->first, controlPoint->second);
            canvas->swap(controlPoint->first, controlPoint->second, controlPoint->first, controlPoint->second - 1);
            rotation = (rotation + degree) % 360;
            return true;
        case Tree:
            switch (rotation % 360)
            {
            case 0:
            case 180:
                if (controlPoint->first - 1 < 0)
                    return false;
                if (controlPoint->first + 1 >= width)
                    return false;
                for (int y = -1; y < 2; y++)
                {
                    if (canvas->get(controlPoint->first - 1, controlPoint->second + y)->getType() != Block::Type::Blank)
                        return false;
                    if (canvas->get(controlPoint->first + 1, controlPoint->second + y)->getType() != Block::Type::Blank)
                        return false;
                }
                break;
            case 90:
            case 270:
                for (int x = -1; x < 2; x++)
                {
                    if (canvas->get(controlPoint->first + x, controlPoint->second - 1)->getType() != Block::Type::Blank)
                        return false;
                    if (canvas->get(controlPoint->first + x, controlPoint->second + 1)->getType() != Block::Type::Blank)
                        return false;
                }
                break;
            default:
                return false;
            }
            canvas->swap(controlPoint->first, controlPoint->second - 1, controlPoint->first + 1, controlPoint->second);
            canvas->swap(controlPoint->first - 1, controlPoint->second, controlPoint->first, controlPoint->second - 1);
            canvas->swap(controlPoint->first, controlPoint->second + 1, controlPoint->first - 1, controlPoint->second);
            rotation = (rotation + degree) % 360;
            return true;
        case Cross:
            if (canvas->get(controlPoint->first - 1, controlPoint->second - 1)->getType() != Block::Type::Blank)
                return false;
            if (canvas->get(controlPoint->first + 1, controlPoint->second - 1)->getType() != Block::Type::Blank)
                return false;
            if (canvas->get(controlPoint->first + 1, controlPoint->second + 1)->getType() != Block::Type::Blank)
                return false;
            if (canvas->get(controlPoint->first - 1, controlPoint->second + 1)->getType() != Block::Type::Blank)
                return false;
            canvas->swap(controlPoint->first, controlPoint->second - 1, controlPoint->first + 1, controlPoint->second);
            canvas->swap(controlPoint->first - 1, controlPoint->second, controlPoint->first, controlPoint->second - 1);
            canvas->swap(controlPoint->first, controlPoint->second + 1, controlPoint->first - 1, controlPoint->second);
            rotation = (rotation + degree) % 360;
            return true;
        default:
            return false;
        }
    }
    else if (degree == 270)
    {
        switch (type)
        {
        case Fold:
            switch (rotation % 360)
            {
            case 0:
                if (canvas->get(controlPoint->first - 1, controlPoint->second - 1)->getType() != Block::Type::Blank)
                    return false;
                break;
            case 90:
                if (canvas->get(controlPoint->first, controlPoint->second - 1)->getType() != Block::Type::Blank)
                    return false;
                break;
            case 180:
                if (canvas->get(controlPoint->first, controlPoint->second)->getType() != Block::Type::Blank)
                    return false;
                break;
            case 270:
                if (canvas->get(controlPoint->first - 1, controlPoint->second)->getType() != Block::Type::Blank)
                    return false;
                break;
            default:
                return false;
            }
            canvas->swap(controlPoint->first - 1, controlPoint->second - 1, controlPoint->first - 1, controlPoint->second);
            canvas->swap(controlPoint->first - 1, controlPoint->second - 1, controlPoint->first, controlPoint->second - 1);
            canvas->swap(controlPoint->first, controlPoint->second - 1, controlPoint->first, controlPoint->second);
            rotation = (rotation + degree) % 360;
            return true;
        case Tree:
            switch (rotation % 360)
            {
            case 0:
            case 180:
                if (controlPoint->first - 1 < 0)
                    return false;
                if (controlPoint->first + 1 >= width)
                    return false;
                for (int y = -1; y < 2; y++)
                {
                    if (canvas->get(controlPoint->first - 1, controlPoint->second + y)->getType() != Block::Type::Blank)
                        return false;
                    if (canvas->get(controlPoint->first + 1, controlPoint->second + y)->getType() != Block::Type::Blank)
                        return false;
                }
                break;
            case 90:
            case 270:
                for (int x = -1; x < 2; x++)
                {
                    if (canvas->get(controlPoint->first + x, controlPoint->second - 1)->getType() != Block::Type::Blank)
                        return false;
                    if (canvas->get(controlPoint->first + x, controlPoint->second + 1)->getType() != Block::Type::Blank)
                        return false;
                }
                break;
            default:
                return false;
            }
            canvas->swap(controlPoint->first, controlPoint->second - 1, controlPoint->first + 1, controlPoint->second);
            canvas->swap(controlPoint->first + 1, controlPoint->second, controlPoint->first, controlPoint->second + 1);
            canvas->swap(controlPoint->first, controlPoint->second + 1, controlPoint->first - 1, controlPoint->second);
            rotation = (rotation + degree) % 360;
            return true;
        case Cross:
            if (canvas->get(controlPoint->first - 1, controlPoint->second - 1)->getType() != Block::Type::Blank)
                return false;
            if (canvas->get(controlPoint->first + 1, controlPoint->second - 1)->getType() != Block::Type::Blank)
                return false;
            if (canvas->get(controlPoint->first + 1, controlPoint->second + 1)->getType() != Block::Type::Blank)
                return false;
            if (canvas->get(controlPoint->first - 1, controlPoint->second + 1)->getType() != Block::Type::Blank)
                return false;
            canvas->swap(controlPoint->first, controlPoint->second - 1, controlPoint->first + 1, controlPoint->second);
            canvas->swap(controlPoint->first + 1, controlPoint->second, controlPoint->first, controlPoint->second + 1);
            canvas->swap(controlPoint->first, controlPoint->second + 1, controlPoint->first - 1, controlPoint->second);
            rotation = (rotation + degree) % 360;
            return true;
        default:
            return false;
        }
    }
    else
    {
        return false;
    }
}
int Visual::getScore(void) { return score; }