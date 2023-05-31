# 터틀 모듈 불러오기 및 사전 설정
import turtle
t = turtle.Turtle()
t.shape("turtle")
t.width(5)

# 터틀 스크린 사전 설정
s = turtle.Screen()

# 터틀 그리기 함수 (x 좌표값, y 좌표값)
def drawit(x, y):
    # 터틀 이동하며 선 그리기
    t.goto(x, y)

# 터틀 스크린에 마우스 클릭 시, 클릭 좌표를 터틀 그리기 함수에 입력&실행
s.onscreenclick(drawit)
