# 터틀 모듈 불러오기 및 사전 설정
import turtle
t = turtle.Turtle()
t.shape("turtle")

# 사각형을 그리는 함수 (한 변의 길이)
def square(length):
    for i in range(4):
        t.forward(length)
        t.left(90)

# 한 변의 길이 입력
length = int(turtle.textinput("사각형 그리기", "한 변의 길이를 입력하세요"))

# 사각형 함수에 한 변의 길이를 입력 후, 이를 3번 실행
for i in range(3):
    square(length)
    # 오른쪽으로 이동
    t.penup()
    t.forward(length * 2)
    t.pendown()
