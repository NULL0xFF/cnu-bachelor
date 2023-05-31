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
