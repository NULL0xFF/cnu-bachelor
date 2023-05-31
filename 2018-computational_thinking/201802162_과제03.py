'''
Assignment #3
'''
home = input("경기장은 어디입니까? : ")
win = input("이긴팀은 어디입니까? : ")
lose = input("진팀은 어디입니까? : ")
mvp = input("우수선수는 누구입니까? : ")
score = input("스코어는 몇대몇입니까? : ")
breakline = "=================================================="

print(breakline)
print("오늘 %s 에서 야구 경기가 열렸습니다." % home)
print("%s 와(과) %s 은(는) 치열한 공방전을 펼쳤습니다." % (win, lose))
print("%s 이(가) 맹활약을 하였습니다." % mvp)
print("결국 %s 와(과) %s 을(를) %s 로 이겼습니다." % (win, lose, score))
print(breakline)
