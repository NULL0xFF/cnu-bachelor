
class Point {
public:
	int x, y;

	Point() : Point(0, 0) {}
	explicit Point(int _x, int _y)
	{
		this->x = _x;
		this->y = _y;
	}
};