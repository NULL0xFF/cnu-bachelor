#include "block.hpp"

Block::Type Block_Gray::getType() { return Block::Type::Gray; }
std::string Block_Gray::toString() { return std::string("■"); }

Block::Type Block_Red::getType() { return Block::Type::Red; }
std::string Block_Red::toString() { return std::string("\033[31m■\033[0m"); }

Block::Type Block_Green::getType() { return Block::Type::Green; }
std::string Block_Green::toString() { return std::string("\033[32m■\033[0m"); }

Block::Type Block_Blue::getType() { return Block::Type::Blue; }
std::string Block_Blue::toString() { return std::string("\033[34m■\033[0m"); }