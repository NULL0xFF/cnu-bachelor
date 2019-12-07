#ifndef CANVAS_HPP
#define CANVAS_HPP

#include <time.h>
#include <iostream>
#include <random>
#include <vector>
#include "block.hpp"
#include "pblock.hpp"

class Canvas
{
private:
	std::random_device rd;
	std::mt19937_64 rnd;
	std::uniform_int_distribution<_int64> blockSizeDist;
	std::uniform_int_distribution<_int64> blockTypeDist;
	std::vector<std::vector<Block*>> blockArray;
	PBlock* pBlk;
	bool isAlive, isHandled;
	int width, height;

	bool createFoldBlock(void)
	{
		// Block creation space test
		for (int i = 0; i < 2; i++)
			if (this->blockArray[i][this->width / 2]->getType() != BlockType::BLANK)
				return false;
		if (this->blockArray[1][this->width / 2]->getType() != BlockType::BLANK)
			return false;

		std::vector<Block* > foldList = {
			this->blockArray[0][this->width / 2],
			this->blockArray[1][(this->width / 2) - 1],
			this->blockArray[1][this->width / 2]
		};

		for (int i = 0; i < (unsigned)foldList.size(); i++)
			foldList[i]->getType() = static_cast<BlockType>(this->blockTypeDist(rnd));

		this->pBlk = new PBlock(foldList);

		return true;
	}
	bool createTreeBlock(void)
	{
		// Block creation space test
		for (int i = 0; i < 3; i++)
			if (this->blockArray[i][this->width / 2]->getType() != BlockType::BLANK)
				return false;

		std::vector<Block* > treeList = {
			this->blockArray[0][this->width / 2],
			this->blockArray[1][this->width / 2],
			this->blockArray[2][this->width / 2]
		};

		for (int i = 0; i < 3; i++)
			treeList[i]->getType() = static_cast<BlockType>(this->blockTypeDist(rnd));

		this->pBlk = new PBlock(treeList);

		return true;
	}
	bool createCrossBlock(void) {
		// Block creation space test
		if (this->blockArray[0][this->width / 2]->getType() != BlockType::BLANK)
			return false;
		for (int i = -1; i < 2; i++)
			if (this->blockArray[1][(this->width / 2) + i]->getType() != BlockType::BLANK)
				return false;
		if (this->blockArray[2][this->width / 2]->getType() != BlockType::BLANK)
			return false;

		std::vector<Block* >crossList = {
			this->blockArray[0][this->width / 2],
			this->blockArray[1][(this->width / 2) - 1],
			this->blockArray[1][this->width / 2],
			this->blockArray[1][(this->width / 2) + 1],
			this->blockArray[2][this->width / 2]
		};

		for (int i = 0; i < (unsigned) crossList.size(); i++) {
			crossList[i]->getType() = static_cast<BlockType>(this->blockTypeDist(rnd));
		}

		this->pBlk = new PBlock(crossList);

		return true;
	}

public:
	void createPBlock(void)
	{
		// User block handle check
		if (this->isHandled)
			return;

		bool isCreated = false;
		bool foldTried = false, treeTried = false, crossTried = false;

		while (!isCreated) {
			if (foldTried && treeTried && crossTried) {
				this->isAlive = false;
				return;
			}
			switch (this->blockSizeDist(rnd))
			{
			case 1:
				if (!foldTried) {
					foldTried = true;
					isCreated = createFoldBlock();
				}
				break;
			case 2:
				if (!treeTried) {
					treeTried = true;
					isCreated = createTreeBlock();
				}
				break;
			case 3:
				if (!crossTried) {
					crossTried = true;
					isCreated = createCrossBlock();
				}
				break;
			default:
				throw std::runtime_error("unknown block size");
			}
		}
		this->isHandled = true;
	}
	Canvas(int _width, int _height) : rd(), rnd(rd()), blockSizeDist(1, 3), blockTypeDist(1, 4), blockArray(_height, std::vector<Block*>(_width))
	{
		// Size Check
		if (_width < 3)
			throw std::runtime_error("width is too small");
		if (_height < 3)
			throw std::runtime_error("height is too small");

		this->isAlive = false;
		this->width = _width;
		this->height = _height;
		this->pBlk = nullptr;
		this->isHandled = false;

		for (int y = 0; y < this->height; y++)
			for (int x = 0; x < this->width; x++)
				this->blockArray[y][x] = new Block();
	}
	void draw(void)
	{
		for (int y = 0; y < this->height; y++) {
			for (int x = 0; x < this->width; x++)
				std::cout << this->blockArray[y][x]->toString() << '\t';
			std::cout << std::endl;
		}
	}
	void update(void)
	{
		/**
		 * Move upper block to current block position
		 * if current block is not availiable(nullptr)
		 * or BlockType::BLANK, with changing upper block
		 * position as nullptr
		 */
		for (int y = this->height - 1; y > 0; y--)
			for (int x = 0; x < this->width; x++)
				if (this->blockArray[y][x] == nullptr) {
					this->blockArray[y][x] = this->blockArray[y - 1][x];
					this->blockArray[y - 1][x] = nullptr;
				}
				else if (this->blockArray[y][x]->getType() == BlockType::BLANK)
				{
					this->blockArray[y][x] = this->blockArray[y - 1][x];
					this->blockArray[y - 1][x] = nullptr;
				}

		// New Top Blocks
		for (int x = 0; x < this->width; x++)
			this->blockArray[0][x] = new Block();
	}

	std::vector<std::vector<Block*>>& getArray() { return this->blockArray; }
};

#endif // CANVAS_HPP