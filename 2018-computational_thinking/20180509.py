#input_list = {54, 33, 13, 32, 30, 18, 5, 58, 63, 67, 79, 90, 25, 42, 39, 99, 81, 14, 68, 3, 66, 56, 74, 31, 64, 48, 51,
#              43, 7, 49, 80, 75, 91, 46, 35, 60, 24, 44, 53, 12, 69, 8, 98, 26, 77, 93, 1, 38, 29, 100, 52, 62, 50, 61,
#              57, 85, 19, 40, 96, 92, 47, 15, 86, 82, 76, 83, 20, 94, 70, 6, 45, 22, 34, 17, 41, 71, 37, 36, 72, 65,
#              73, 59, 23, 78, 21, 87, 97, 88, 27, 95, 10, 28, 4, 84, 16, 11, 2, 89, 9, 55}
input_list = []
########################################################################################################################
def bubble():
    for i1 in range(1, list_length(), 1):
        FLAG = True
        for i2 in range(0, list_length() - 1, 1):
            if input_list[i2] > input_list[i2 + 1]:
                input_list[i2], input_list[i2 + 1] = input_list[i2 + 1], input_list[i2]
                FLAG = False
        if FLAG:
            break
    return
def list_length():
    return len(input_list)
########################################################################################################################
while True:
    print(list_length() + 1, " 번째")
    input_string = input("Data 입력(\"끝\" 입력시 종료): ")
    if input_string == "끝":
        break
    else:
        input_list.append(int(input_string))
print("입력받은 값 = ", input_list)
bubble()
print("Sort 결과 = ", input_list)