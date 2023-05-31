# 터틀 모듈 불러오기 및 사전 설정
import turtle
t = turtle.Turtle()
t.color("green")

# 터틀 스크린 사전 설정
s = turtle.Screen()

# 사각형을 그리는 함수 (한 변)
def square(length):
    for i in range(4):
        t.forward(length)
        t.left(90)

# 터틀 그리기 함수 (x 좌표값, y 좌표값)
def drawit(x, y):
    # 터틀 이동
    t.penup()
    t.goto(x, y)
    t.pendown()
    # 사각형 함수 실행&사각형 채우기
    t.begin_fill()
    square(50)
    t.end_fill()

# 터틀 스크린에 마우스 클릭 시, 클릭 좌표를 터틀 그리기 함수에 입력&실행
s.onscreenclick(drawit)
