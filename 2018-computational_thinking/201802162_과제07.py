import turtle

t = turtle.Turtle() # 거북이 불러오기

t.penup()

t.goto(100,100) # 좌표 이동
t.write("A학점 입니다.")
t.goto(100,50) # 좌표 이동
t.write("B학점 입니다.")
t.goto(100,0) # 좌표 이동
t.write("C학점 입니다.")
t.goto(100,-50) # 좌표 이동
t.write("D학점 입니다.")
t.goto(100,-100) # 좌표 이동
t.write("F학점 입니다.")
t.goto(0,0) # 원점 복귀

t.pendown()

t.shape("turtle")

i = int(turtle.textinput("Hw07", "성적을 입력하세요:"))
if i >= 90:
    t.goto(100,100) # 90점 이상일 경우 해당 좌표로 이동
elif i >= 80:
    t.goto(100,50) # 80점 이상일 경우 해당 좌표로 이동
elif i >= 70:
    t.goto(100,0) # 70점 이상일 경우 해당 좌표로 이동
elif i >= 60:
    t.goto(100,-50) # 60점 이상일 경우 해당 좌표로 이동
else:
    t.goto(100,-100) # 60점 미만일 경우 해당 좌표로 이동
