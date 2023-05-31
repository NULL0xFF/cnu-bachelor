import random
import turtle

# 글로벌 필드
trackLength = 0  # 경기장의 한 변의 길이
trackWidth = 0  # 경기장의 터틀 간 사이
totalRaceTurtle = 0  # 총 터틀의 수
live_rank_first = 0  # 실시간 첫번째 터틀의 총 길이
live_rank_second = 0  # 실시간 두번째 터틀의 총 길이
live_rank_third = 0  # 실시간 세번째 터틀의 총 길이
rank = 1  # 터틀 순위 초기화


# 경기장 생성 메소드
def init_track():
    track_turtle = turtle.Turtle()  # 경기장을 그릴 터틀 설정
    track_turtle.hideturtle()
    track_turtle.penup()
    track_turtle.goto(-(trackLength / 2), -(trackLength / 2))  # 터틀을 경기장의 한 꼭짓점으로 이동
    track_turtle.pendown()
    # 정사각형을 그리는 for 문
    for forward_loop in range(0, 4):
        track_turtle.forward(trackLength)
        track_turtle.left(90)


# 순위 그리는 메소드
def write_ranking(var):
    global rank
    ranking_turtle = turtle.Turtle()  # 순위를 작성할 터틀 설정
    ranking_turtle.hideturtle()
    ranking_turtle.penup()
    ranking_turtle.goto(0, -(trackWidth * rank))  # 순위의 위치 설정
    ranking_turtle.write("%d등: 거북이 #%d" % (rank, var + 1), font=("Cambria", int(trackWidth * 0.8), "normal"))  # 순위 작성
    rank = rank + 1  # 글로벌 순위 변경


# 난수를 이용한 앞으로 가는 길이 리턴 메소드
def random_length():
    return random.randrange(trackLength // 10, trackLength // 5)


# 랜덤 RGB HEX 값 리턴 메소드
def random_rgb():
    while True:
        r = random_hex()
        g = random_hex()
        b = random_hex()
        if not (r == g == b):
            return "#" + r + g + b


# 랜덤 2자리 HEX 값 리턴 메소드
def random_hex():
    decimal = random.randrange(0, 256)
    quotient = decimal // 16
    remainder = decimal % 16
    random_return_hex = f"{decimal2hex(quotient)}{decimal2hex(remainder)}"
    return random_return_hex


# 10진수 16진수 변환 리턴 메소드
def decimal2hex(decimal):
    return {
        0: "0",
        1: "1",
        2: "2",
        3: "3",
        4: "4",
        5: "5",
        6: "6",
        7: "7",
        8: "8",
        9: "9",
        10: "A",
        11: "B",
        12: "C",
        13: "D",
        14: "E",
        15: "F",
    }[decimal]


# 터틀 객체 클래스
class RaceTurtle:
    def __init__(self, position_number):
        self.totalLength = 0  # 터틀의 총 거리 변수
        self.turtle = turtle.Turtle()  # 터틀 선언
        self.turtle.shape("turtle")  # 터틀 모양
        self.turtle.color(random_rgb())  # 터틀 색상 (랜덤)
        self.turtle.shapesize(trackWidth / 20)  # 경기장의 터틀 간 사이에 따른 터틀의 크기 설정
        self.turtle.penup()
        self.turtle.goto(-(trackLength / 2), -(trackLength / 2 + (position_number + 1) * trackWidth))  # 터틀 기본 위치 설정
        self.turtle.pendown()


# 실제 게임 코드 시작
gameTitle = "터틀 경주 게임"

turtleArray = []  # raceTurtle들을 저장할 배열
screenTurtle = turtle.Screen()

screenTurtle.delay(0)

while True:
    inputTrackLength = int(screenTurtle.textinput(gameTitle, "사각형 경기장의 한 변의 길이를 입력하세요\n최소 100, 최대 500"))
    if 100 <= inputTrackLength <= 500:
        trackLength = inputTrackLength
        break

init_track()  # 경기장 생성

while True:
    inputTrackWidth = int(screenTurtle.textinput(gameTitle, "터틀 사이의 폭 길이를 입력하세요\n최소 10, 최대 25"))
    if 10 <= inputTrackWidth <= 25:
        trackWidth = inputTrackWidth
        break

while True:
    total_Turtle = int(screenTurtle.textinput(gameTitle, "터틀의 수를 정하세요\n최소 4"))
    if total_Turtle >= 4:
        for loop in range(0, total_Turtle):
            turtleArray.insert(loop, RaceTurtle(loop))
            turtleArray[loop].turtle.write("거북이 #" + str(loop + 1))
        break

totalRaceTurtle = turtleArray.__len__()  # 총 터틀 수
screenTurtle.delay(25)

while rank <= totalRaceTurtle:
    for loop in range(0, totalRaceTurtle):
        firstSide = trackLength + trackWidth * (totalRaceTurtle - loop)  # 출발점부터 첫번째 커브까지의 길이
        secondSide = firstSide + (trackLength + (trackWidth * 2) * (loop + 1))  # 출발점부터 두번째 커브까지의 길이
        thirdSide = secondSide + (trackLength + (trackWidth * 2) * (totalRaceTurtle - loop))  # 출발점부터 세번째 커브까지의 길이
        fourthSide = thirdSide + (trackLength + (trackWidth * 2) * (loop + 1))  # 출발점부터 네번째 커브까지의 길이
        end2FirstSide = fourthSide + (trackWidth * (totalRaceTurtle - loop))  # 출발점부터 결승선 까지의 길이
        randomForward = random_length()  # 앞으로 갈 길이 (랜덤)
        calculatedTotalLength = turtleArray[loop].totalLength + randomForward  # 예상되는 터틀의 총 길이

        # 첫번째 커브 전까지 앞으로 가는 if문
        if turtleArray[loop].totalLength < firstSide:
            if calculatedTotalLength < firstSide:
                turtleArray[loop].turtle.forward(randomForward)
                turtleArray[loop].totalLength = calculatedTotalLength
            elif calculatedTotalLength == firstSide:
                turtleArray[loop].turtle.forward(randomForward)
                screenTurtle.delay(0)
                turtleArray[loop].turtle.left(90)
                screenTurtle.delay(25)
                turtleArray[loop].totalLength = calculatedTotalLength
            else:
                turtleArray[loop].turtle.forward(firstSide - turtleArray[loop].totalLength)
                screenTurtle.delay(0)
                turtleArray[loop].turtle.left(90)
                screenTurtle.delay(25)
                turtleArray[loop].turtle.forward(calculatedTotalLength - firstSide)
                turtleArray[loop].totalLength = calculatedTotalLength
        # 두번째 커브 전까지 앞으로 가는 else-if문
        elif turtleArray[loop].totalLength < secondSide:
            if calculatedTotalLength < secondSide:
                turtleArray[loop].turtle.forward(randomForward)
                turtleArray[loop].totalLength = calculatedTotalLength
            elif calculatedTotalLength == secondSide:
                turtleArray[loop].turtle.forward(randomForward)
                screenTurtle.delay(0)
                turtleArray[loop].turtle.left(90)
                screenTurtle.delay(25)
                turtleArray[loop].totalLength = calculatedTotalLength
            else:
                turtleArray[loop].turtle.forward(secondSide - turtleArray[loop].totalLength)
                screenTurtle.delay(0)
                turtleArray[loop].turtle.left(90)
                screenTurtle.delay(25)
                turtleArray[loop].turtle.forward(calculatedTotalLength - secondSide)
                turtleArray[loop].totalLength = calculatedTotalLength
        # 세번째 커브 전까지 앞으로 가는 else-if문
        elif turtleArray[loop].totalLength < thirdSide:
            if calculatedTotalLength < thirdSide:
                turtleArray[loop].turtle.forward(randomForward)
                turtleArray[loop].totalLength = calculatedTotalLength
            elif calculatedTotalLength == thirdSide:
                turtleArray[loop].turtle.forward(randomForward)
                screenTurtle.delay(0)
                turtleArray[loop].turtle.left(90)
                screenTurtle.delay(25)
                turtleArray[loop].totalLength = calculatedTotalLength
            else:
                turtleArray[loop].turtle.forward(thirdSide - turtleArray[loop].totalLength)
                screenTurtle.delay(0)
                turtleArray[loop].turtle.left(90)
                screenTurtle.delay(25)
                turtleArray[loop].turtle.forward(calculatedTotalLength - thirdSide)
                turtleArray[loop].totalLength = calculatedTotalLength
        # 네번째 커브 전까지 앞으로 가는 else-if문
        elif turtleArray[loop].totalLength < fourthSide:
            if calculatedTotalLength < fourthSide:
                turtleArray[loop].turtle.forward(randomForward)
                turtleArray[loop].totalLength = calculatedTotalLength
            elif calculatedTotalLength == fourthSide:
                turtleArray[loop].turtle.forward(randomForward)
                screenTurtle.delay(0)
                turtleArray[loop].turtle.left(90)
                screenTurtle.delay(25)
                turtleArray[loop].totalLength = calculatedTotalLength
            elif fourthSide < calculatedTotalLength < end2FirstSide:
                turtleArray[loop].turtle.forward(fourthSide - turtleArray[loop].totalLength)
                screenTurtle.delay(0)
                turtleArray[loop].turtle.left(90)
                screenTurtle.delay(25)
                turtleArray[loop].turtle.forward(calculatedTotalLength - fourthSide)
                turtleArray[loop].totalLength = calculatedTotalLength
            else:
                calculatedTotalLength = end2FirstSide
                turtleArray[loop].turtle.forward(fourthSide - turtleArray[loop].totalLength)
                screenTurtle.delay(0)
                turtleArray[loop].turtle.left(90)
                screenTurtle.delay(25)
                turtleArray[loop].turtle.forward(calculatedTotalLength - fourthSide)
                turtleArray[loop].totalLength = calculatedTotalLength
                write_ranking(loop)
        # 결승전까지 앞으로 가는 else-if문
        elif turtleArray[loop].totalLength < end2FirstSide:
            if calculatedTotalLength < end2FirstSide:
                turtleArray[loop].turtle.forward(randomForward)
                turtleArray[loop].totalLength = calculatedTotalLength
            else:
                turtleArray[loop].turtle.forward(end2FirstSide - turtleArray[loop].totalLength)
                turtleArray[loop].totalLength = turtleArray[loop].totalLength + (
                        end2FirstSide - turtleArray[loop].totalLength)
                write_ranking(loop)

screenTurtle.mainloop()
