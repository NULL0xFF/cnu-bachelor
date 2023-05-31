import turtle

t = turtle.Turtle()

type_of_drawing = turtle.textinput("실습 5","도형을 입력하세요:")

if type_of_drawing == "사각형":
    length_horizontal = int(turtle.textinput("실습 5","가로:"))
    length_vertical = int(turtle.textinput("실습 5","세로:"))
    t.forward(length_horizontal)
    t.left(90)
    t.forward(length_vertical)
    t.left(90)
    t.forward(length_horizontal)
    t.left(90)
    t.forward(length_vertical)
elif type_of_drawing == "삼각형":
    length_horizontal = int(turtle.textinput("실습 5","밑변:"))
    length_vertical = int(turtle.textinput("실습 5","높이:"))
    t.forward(length_horizontal)
    
elif type_of_drawing == "원":
    length_radius = int(turtle.textinput("실습 5","반지름:"))
else:
    print("ERROR")
