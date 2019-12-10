def rsp(mine, yours):
    available_string = ["가위", "바위", "보"]
    i = j = False
    for s in available_string:
        if (mine == s):
            i = True
        if (yours == s):
            j = True
    if((i & j) == False):
        raise ValueError
    if (mine == yours):
        print("비겼습니다")
    elif (mine == "가위" and yours == "바위"):
        print("상대방의 승리")
    elif (mine == "가위" and yours == "보"):
        print("나의 승리")
    elif (mine == "바위" and yours == "가위"):
        print("나의 승리")
    elif (mine == "바위" and yours == "보"):
        print("상대방의 승리")
    elif (mine == "보" and yours == "가위"):
        print("상대방의 승리")
    elif (mine == "보" and yours == "바위"):
        print("나의 승리")


try:
    rsp("바위", "바위")
except ValueError:
    print("잘못된 값을 넣었습니다!")
else:
    print("종료합니다")