import turtle
t = turtle.Turtle()
s = turtle.Screen()
'''
# 실습1: 사각형을 그리는 함수 작성하기
def square(length):
    for i in range(4):
        t.forward(length)
        t.left(90)
length = int(turtle.textinput("사각형 그리기", "한 변의 길이를 설정하세요"))
for i in range(3):
    square(length)
    t.penup()
    t.forward(length * 2)
    t.pendown()

# 터틀 정리
input("Press Any Key to Continue...")
t.reset()
'''
# 실습2: n-각형을 그리는 함수 작성하기
def drawing(length, n_count, angle):
    for i in range(n_count):
        t.forward(length)
        t.left(180 - angle)

length = int(turtle.textinput("n각형 그리기", "한 변의 길이를 설정하세요"))
while length <= 0 :
    length = int(turtle.textinput("n각형 그리기", "한 변의 길이를 설정하세요"))
n_count = int(turtle.textinput("n각형 그리기", "한 모서리의 각을 설정하세요"))
while n_count < 3:
    n_count = int(turtle.textinput("n각형 그리기", "한 모서리의 각을 설정하세요"))
total_angle = 180 * (n_count - 2)
angle = total_angle / n_count
for i in range(n_count):
    drawing(length, n_count, angle)
    t.left(180 - angle)

# 터틀 정리
input("Press Any Key to Continue...")
t.reset()    
'''
#실습3: 클릭하는 곳에 사각형 그리기
def square(length):
    for i in range(4):
        t.forward(length)
        t.left(90)
def drawit(x, y):
    t.penup()
    t.goto(x, y)
    t.pendown()
    t.begin_fill()
    t.color("green")
    square(100)
    t.end_fill()

s.onscreenclick(drawit)

''''''
# 실습4: 마우스로 그림 그리기
def drawit(x, y):
    t.goto(x, y)

s.onscreenclick(drawit)
''''''
# 실습5: 나무 그리기
def tree(length):
    if length > 5:
        t.forward(length)
        t.right(20)
        tree(length - 15)
        t.left(40)
        tree(length-15)
        t.right(20)
        t.backward(length)
t.left(90)
t.color("green")
t.speed(0)
tree(90)
''''''
def branch(length):
    t.forward(length)
    t.left(45)
    t.forward(length)
    t.backward(length)
    t.right(45)
    t.forward(length)
    t.backward(length)
    t.right(45)
    t.forward(length)
    t.backward(length)
def branch_return(length):
    t.left(45)
    t.backward(length)
    t.left(45)
def branch_big_return(length):
    t.right(90)
    t.backward(length)
    t.left(45)

t.left(90)
length = 100

branch(length)

branch(length / 2)

branch(length / 4)
branch_return(length / 4)
branch(length / 4)
branch_return(length / 4)
branch(length / 4)
branch_return(length / 4)

branch_big_return(length / 2)

branch(length / 2)
branch(length / 4)
branch_return(length / 4)
branch(length / 4)
branch_return(length / 4)
branch(length / 4)
branch_return(length / 4)

branch_big_return(length / 2)

branch(length / 2)
branch(length / 4)
branch_return(length / 4)
branch(length / 4)
branch_return(length / 4)
branch(length / 4)
branch_return(length / 4)
''''''
# 실습6: 막대 그래프 그리기
def stick_graph(height)
'''
