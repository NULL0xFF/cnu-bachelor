import turtle
'''
#for(), range()
t1 = turtle.Turtle()
for count in range (6):
    t1.circle(100)
    t1.left(360/6)
turtle.bye()

#while()
password = ""
while password != "pythonisfun":
    password = input("암호를 입력하세요: ")
print("로그인 성공")

#sum of 1 to 10
count = 1
sum = 0
while count <= 10 :
    sum = sum + count
    count = count + 1
print("합계는 ", sum)

#draw rectangle
t2 = turtle.Turtle()
count = 1
while count < 4:
    t2.forward(100)
    t2.right(90)
    count = count + 1
turtle.bye()

#실습 1: 반복을 사용하여 도형 그리기
t3 = turtle.Turtle()
t3.shape("turtle")
count = 0
for i in range(1, 4, 1):
    t3.forward(100)
    t3.left(120)
    count = count + 1
t3.penup()
t3.forward(200)
t3.pendown()
count = 0
for i in range (1, 5, 1):
    t3.forward(100)
    t3.left(90)
    count = count + 1
turtle.bye()
'''
'''
while True:
    try:
        x = int(input("\"홀수\" or \"짝수\"를 입력하세요: "))
        if (x >= 1 and x <= 100):
            break
        else:
            print("1에서 100 사이의 숫자를 입력해야 합니다")
    except ValueError:
        print("1에서 100 사이의 숫자를 입력해야 합니다")
'''
while True:
    s1 = input("\"홀수\" or \"짝수\"를 입력하세요: ")
    if (s1 == "홀수" or s1 == "짝수"):
        break
sum = 0
if (s1 == "홀수"):
    for i in range(1,101, 2):
        sum = sum + i
else:
    for i in range(2,101, 2):
        sum = sum + i
print(sum)

