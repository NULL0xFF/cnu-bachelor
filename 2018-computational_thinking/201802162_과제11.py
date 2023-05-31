from turtle import *


class Ball:
    #생성자 메서드
    def __init__(self, color, size, speed):
        #x, y 좌표 초기화
        self.x = 0
        self.y = 0
        #x, y 벡터 초기화
        self.xspeed = speed
        self.yspeed = speed
        #turtle 초기화
        self.turtle = Turtle()
        #turtle 모양 변경
        self.turtle.shape("circle")
        #turtle 색깔 초기화
        self.turtle.color(color)
        #turtle 모양 크기 초기화
        self.turtle.shapesize(size, size)

    def move(self):
        self.x += self.xspeed
        self.y += self.yspeed
        self.turtle.goto(self.x, self.y)


#Ball 객체 생성
ball = Ball("red", 2, 1)
for i in range(100):
    ball.move()
