import math

class Shape:
    def __init__(self):
        pass
    def getArea(self):
        raise NotImplementedError

class Circle(Shape):
    def getArea(self):
        return self.radius * self.radius * math.pi
    def setRadius(self, radius):
        self.radius = radius

class Polygon(Shape):
    def __init__(self, width, height):
        self.width = width
        self.height = height
    def getArea(self):
        pass
    def setWidth(self, width):
        self.width = width
    def setHeight(self, height):
        self.height = height

class Rectangle(Polygon):
    def getArea(self):
        return self.width * self.height

class Triangle(Polygon):
    def getArea(self):
        return self.width * self.height * 0.5

Cir = Circle()
Cir.setRadius(3)
Rect = Rectangle(2, 3)
Trian = Triangle(2, 8)
print("Circle Radius\t", Cir.radius, " | Circle Area:\t", Cir.getArea())
print("Rectangle Width\t", Rect.width, " | Rectangle Height:\t", Rect.height, " | Rectangle Area:\t", Rect.getArea())
print("Triangle Width\t", Trian.width, " | Triangle Height:\t", Trian.height, " | Triangle Area:\t", Trian.getArea())
