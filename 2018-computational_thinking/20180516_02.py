globalList = []
########################################################################################################################
def insertion():
    frontList = []
    backList = globalList
    for i1 in range(0, len(globalList)):
        frontList.append(backList[0])
        del backList[0]
        print(frontList)
        print(backList)



########################################################################################################################
while 1:
    print(len(globalList) + 1, " 번째")
    input_string = input("Data 입력(\"끝\" 입력시 종료): ")
    if input_string == "끝":
        break
    else:
        globalList.append(int(input_string))
print("입력받은 값 = ", globalList)
insertion()
print("Sort 결과 = ", globalList)