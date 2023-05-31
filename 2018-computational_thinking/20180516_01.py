globalList = []
########################################################################################################################
def selective():
    for i1 in range(0, len(globalList) - 1):
        print ("i1 = ", i1)
        minimumNumber = min(globalList[i1 + 1:])
        minimumNumberIndex = globalList.index(minimumNumber)
        if (globalList[i1] > globalList[minimumNumberIndex]):
            globalList[i1], globalList[minimumNumberIndex] = globalList[minimumNumberIndex], globalList[i1]
        print("minimumNumber = ", minimumNumber)
    return

########################################################################################################################
'''
def selective():
    minNum = 0;
    currentNum = 0;
    listLength = list_length()

    for i1 in range(0, listLength):
        currentNum = list[i1]
        currentNumIndex = i1
        selectedNum = list[i1 + 1]
        selectedNumIndex = i1 + 1
        for i2 in range (i1 + 1, listLength):
            if (selectedNum > list[i2]):
                selectedNum = list[i2]
                selectedNumIndex = i2
        if (currentNum > minNum):
            list[currentNumIndex] = list.append(selectedNumIndex)
            list[selectedNumIndex] = list.append(currentNumIndex)
        print(input)

def list_length():
    return len(list)
'''
########################################################################################################################
while 1:
    print(len(globalList) + 1, " 번째")
    input_string = input("Data 입력(\"끝\" 입력시 종료): ")
    if input_string == "끝":
        break
    else:
        globalList.append(int(input_string))
print("입력받은 값 = ", globalList)
selective()
print("Sort 결과 = ", globalList)