# 과제6: 1/3 결과를 보여주는 프로그램 작성
oneThird = 1 / 3
print("="*40) # 구분선
print("원본: " + str(oneThird)) # 1/3 의 원본값(근사값) 출력
print("="*40) # 구분선
print("소수점 1자리 " + str(round(oneThird, 1))) # 0.3 출력
print("소수점 2자리 " + str(round(oneThird, 2))) # 0.33 출력
print("소수점 3자리 " + str(round(oneThird, 3))) # 0.333 출력
print("소수점 4자리 " + str(round(oneThird, 4))) # 0.3333 출력
