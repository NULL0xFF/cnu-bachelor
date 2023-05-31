import turtle
color = "white"
t = turtle.Turtle()

turtle.bgcolor("black")
t.pencolor(color)

t.speed(0)
t.width(1)
t.forward(100)
n = 0

while n < 2:
    t.left(120)
    t.forward(100)
    n +=1

