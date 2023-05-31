# 터틀 모듈 불러오기 및 사전 설정
import turtle
t = turtle.Turtle()
t.color("green")

# 나무 그리기 함수 (시작선의 길이)
def tree(length):
    if length > 5: # 선의 길이가 5 이하가 될 때 까지 함수 반복 실행
        t.forward(length)
        t.right(20)
        tree(length - 15) # 나무 그리기 함수 실행 (시작선 길이 - 15)
        t.left(40)
        tree(length - 15) # 나무 그리기 함수 실행 (시작선 길이 - 15)
        t.right(20)
        t.backward(length)

t.left(90) # 터틀 기본 Heading 설정
tree(90) # 나무 그리기 함수에 시작선 길이 입력&실행
