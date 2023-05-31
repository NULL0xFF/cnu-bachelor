'''
Assignment #2
'''
import turtle
t = turtle.Turtle()
turtle.bgcolor("black")
t.pencolor("white")
t.speed(0)
t.width(1)
length = int(input("집의 크기는 얼마로 할까요? : "))
t.forward(length)
n = 0
while n < 3:
    t.right(90)
    t.forward(length)
    n += 1
t.right(30)
t.forward(length)
t.right(120)
t.forward(length)
