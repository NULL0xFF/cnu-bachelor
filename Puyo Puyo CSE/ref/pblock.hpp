#ifndef PBLOCK_HPP
#define PBLOCK_HPP

#include <vector>
#include "block.hpp"

// Player Block Control Class
// Contains a list of blocks currently handled by player
class PBlock
{
private:
	std::vector<Block* > blkList;

public:
	PBlock(std::vector<Block*> list) : blkList(list) {}
	~PBlock(void)
	{
		for (unsigned int i = 0; i < (unsigned)this->blkList.size(); i++)
			this->blkList[i] = nullptr;
	}
};

#endif // PBLOCK_HPP