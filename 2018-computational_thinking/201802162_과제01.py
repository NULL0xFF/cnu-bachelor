import turtle
color = "white"
t = turtle.Turtle()

turtle.bgcolor("black")
t.pencolor(color)
t.speed(0)
t.width(1)
n = 1
t.forward(100)

while n < 6:
    t.left(60)
    t.forward(100)
    n += 1

t.circle(100)
