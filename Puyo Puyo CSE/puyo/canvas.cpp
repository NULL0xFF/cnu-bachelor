#include <stdexcept>
#include <string>
#include "canvas.hpp"

Canvas::Canvas(int _width, int _height)
{
	if (_width < 3 || _height < 3)
		throw std::runtime_error(
			std::string(
				"width and height of the canvas is supposed to be at least 3, but input for canvas constructor is ("
			)
			+
			std::to_string(
				_width
			)
			+
			std::string(
				", "
			)
			+
			std::to_string(
				_height
			)
			+
			std::string(
				")"
			)
		);
	this->width = _width;
	this->height = _height;
}