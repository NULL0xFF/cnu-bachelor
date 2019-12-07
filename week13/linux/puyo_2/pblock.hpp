#ifndef PBLOCK_HPP
#define PBLOCK_HPP

#include <string>
#include <vector>
#include "../lib/os.h"
#include "block.hpp"

class PBlock
{
private:
    std::vector<Block *> bList;

public:
    PBlock();
    void move(std::vector<std::vector<Block *>> map, int max_X, int max_y)
    {
        bool flag;
        if (kbhit())
        {
            switch (get_dir_key())
            {
            case UP:
                break;
            case DOWN:
                break;
            case RIGHT:
                break;
            case LEFT:
                flag = true;
                for(int i = 0; i < this->bList.size(); i++){
                    if(isBlocked)
                        flag = false;
                }
                if (flag)
                    for(auto it = this->bList.begin(); it != this->bList.end(); it++){
                        (*it)->move5
                    }
                break;
            case QUIT:
            case UNDEFINED:
                break;
            default:
                throw std::runtime_error("unknown key");
            }
        }
    }
    bool isBlocked(std::vector<std::vector<Block *>> map, int x, int y)
};

#endif // PBLOCK_HPP