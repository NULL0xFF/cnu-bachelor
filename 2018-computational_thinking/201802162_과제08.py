import turtle
t = turtle.Turtle()
t.shape("turtle")

n = 0 # N각형, N은 3 이상이여야 한다

while (n < 3):
    n = int(turtle.textinput("","몇각형을"))

internalAngle = 0 # N각형 내각의 총 합
internalAngle = 180 * (n - 2)

oneAngle = 0 # N각형의 한 내각
oneAngle = internalAngle / n

for count in range(n, 0, -1):
    t.forward(100)
    t.left(180 - oneAngle)
