# 터틀 모듈 불러오기 및 사전 설정
import turtle
t = turtle.Turtle()

# n-각형을 그리는 함수 (한 변의 길이, n, 한 각)
def drawing(length, n_count, angle):
    for i in range(n_count):
        t.forward(length)
        t.left(180 - angle)

# n-각형의 n을 입력
n_count = int(turtle.textinput("n각형 그리기", "각의 수를 입력하세요"))

# 한 변의 길이 입력
length = int(turtle.textinput(str(n_count)+"각형 그리기", "한 변의 길이를 입력하세요"))

# 계산
total_angle = 180 * (n_count - 2) # n-각형의 모든 각의 합
angle = total_angle / n_count # n-각형의 한 각

# n-각형을 360도를 돌며 n번 그리기
for i in range(n_count):
    drawing(length, n_count, angle)
    t.left(180 - angle)
