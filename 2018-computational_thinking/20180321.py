'''
Identification
'''
Student_ID = "201802162"
Student_Name = "지명하"
print(Student_ID + " " + Student_Name)
input()
'''
Practice #1
'''
x = 7
y = 6
print(x + y) # Output 13
input()
x = '7'
y = '6'
print(x + y) # Output 76
input()
'''
Practice #2
'''
Input_Name = "Type your name : "
Hello_Name = "Hello, %s?"
Welcome_Python = "Welcome to Python."
First_Integer = "Type first integer : "
Second_Integer = "Type second integer : "
Sum_of_Two_Integer = "Sum of %d and %d is %d."
Name = input(Input_Name)
print(Hello_Name % (Name))
print(Welcome_Python)
i1 = int(input(First_Integer))
i2 = int(input(Second_Integer))
i3 = i1 + i2
print(Sum_of_Two_Integer % (i1, i2, i3))
input()
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
'''
Assignment #3
'''
home = input("경기장은 어디입니까? : ")
win = input("이긴팀은 어디입니까? : ")
lose = input("진팀은 어디입니까? : ")
mvp = input("우수선수는 누구입니까? : ")
score = input("스코어는 몇대몇입니까? : ")
breakline = "=================================================="

print(breakline)
print("오늘 %s 에서 야구 경기가 열렸습니다." % home)
print("%s 와(과) %s 은(는) 치열한 공방전을 펼쳤습니다." % (win, lose))
print("%s 이(가) 맹활약을 하였습니다." % mvp)
print("결국 %s 와(가) %s 을(를) %s 로 이겼습니다." % (win, lose, score))
print(breakline)
