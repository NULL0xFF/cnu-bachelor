# 실습1: 거북이와 인사해보자
import turtle
t = turtle.Turtle()
t.shape("turtle")
s = turtle.textinput("", "이름을 입력하세요: ")
n = 0
while n < 4:
    t.left(90)
    t.forward(50)
    t.write("안녕하세요? %s씨, 터틀 인사 드립니다." % s)
    t.forward(50)
    n += 1

# 실습2: 연, 원, 일을 합하여 출력하기
year = input("오늘의 연도를 입력하세요: ")
month = input("오늘의 월을 입력하세요: ")
day = input("오늘의 일을 입력하세요: ")
print("오늘은 %s년 %s월 %s일입니다." %(year, month, day))
print("%s/%s/%s" %(month, year, year))

# 실습3: 2050년에는 몇 살이 될까?
import time
now = time.time()
thisYear = int(1970 + now//(365*24*3600))
print("올해는 %d입니다." % thisYear)
age = int(input("몇 살이신지요? "))
expected_age = (2050 - thisYear) + age
print("2050년에는 %d살 이시군요."% expected_age)
