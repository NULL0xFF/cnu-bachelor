#pragma once

#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Canvas
{
	vector<string> line;
	int xMax, yMax;

public:
	explicit Canvas(int nx = 10, int ny = 10) : line(ny), xMax(nx), yMax(ny)
	{
		for (int y = 0; y < yMax; y++)
			line[y] = string(xMax * 2, ' ');
	}
	void draw(int x, int y, string val)
	{
		if (0 <= x && 0 <= y && x < xMax && y < yMax)
			line[y].replace(x * 2, 2, val);
	}
	void clear(string val = "  ")
	{
		for (int y = 0; y < yMax; y++)
			for (int x = 0; x < xMax; x++)
				draw(x, y, val);
	}
	void print(const char *title = "<My Canvas>")
	{
		system("cls");
		cout << title << endl;
		for (int y = 0; y < yMax; y++)
			cout << line[y] << endl;
		cout << endl;
	}
};