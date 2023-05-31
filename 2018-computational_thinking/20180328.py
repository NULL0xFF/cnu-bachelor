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
print("아메리카노(Americano) 2000원\n카페라떼(Cafelatte) 3000원\n카푸치노(Capucino) 3500원")
soldAmericano = 0 # 변수 초기화
soldCafelatte = 0 # 변수 초기화
soldCapucino = 0 # 변수 초기화
soldAmericano = int(input("아메리카노 판매 개수: "))
soldCafelatte = int(input("카페라떼 판매 개수: "))
soldCapucino = int(input("카푸치노 판매 개수: "))
totalValue = soldAmericano * 2000 + soldCafelatte * 3000 + soldCapucino * 3500
print("총 매출은", totalValue, "원 입니다")
input()
'''
Practice #2
'''
# Declaration and Data Input
inputFarenheit = 0 # 변수 초기화
inputFarenheit = int(input("화씨 온도를 입력하세요(°F): ")) # 화씨 온도 입력
# Calculation
outputCelsius =  (inputFarenheit - 32) * (5 / 9) # 섭씨 온도 계산
# Output
print("섭씨 온도는:", outputCelsius, "°C 입니다")

input()
'''
Practice #3
'''
# Declaration and Data Input
inputWeight = 0 # 변수 초기화
inputWeight = float(input("몸무게를 입력하세요(kg): ")) # 몸무게 입력
inputHeight = float(input("키를 입력하세요(m): ")) # 키 입력
# Calculation
outputBMI = (inputWeight) / (inputHeight ** 2) # BMI 계산
# Output
print("계산된 BMI =", outputBMI)
input()
'''
Practice #4
'''
# Declaration and Data Input
x = int(input("첫 번째 수를 입력하시오: "))
y = int(input("두 번째 수를 입력하시오: "))
z = int(input("세 번째 수를 입력하시오: "))
# Calculation
avg = (x + y + z) / 3 # 괄호를 이용하여 평균을 구한다
# Output
print("평균 =", avg)
input()
'''
Assignment #4
'''
# 과제4: 자동 판매기 프로그램
# Declaration
inputMoney = int(input("투입한 돈: ")) # 투입한 돈을 inputMoney라는 이름으로 값을 저장한다
inputValue = int(input("물건값: ")) # 물건 값을 inputValue라는 이름으로 값을 저장한다
# Calculation
leftoverMoney = inputMoney - inputValue # 거스름돈을 계산한 후 leftoverMoeny라는 이름으로 값을 저장한다 (투입한 돈 - 물건값)
countFiveHundred = leftoverMoney // 500 # 500원의 개수를 계산하고 countFiveHundred라는 이름으로 값을 저장한다 ((거스름돈 / 500)의 몫)
countOneHundred = (leftoverMoney % 500) // 100 # 100원의 개수를 계산하고 countOneHundred라는 이름으로 값을 저장한다 (((거스름돈 / 500)의 나머지) / 100)
# Output
print("거스름돈:", leftoverMoney) # 거스름돈 출력
print("500원 동전의 개수:", countFiveHundred) # 500원 개수 출력
print("100원 동전의 개수:", countOneHundred) # 100원 개수 출력
input()
