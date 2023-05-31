# 과제5: 친구들의 리스트 생성하기
nameList = [] # 이름을 저장할 Array
count = 0; # while 문 실행을 위한 변수
while count < 5:
	nameList.append(input("친구들의 이름을 입력하세요: "))
	count += 1
print(nameList) # 이름의 리스트 출력
