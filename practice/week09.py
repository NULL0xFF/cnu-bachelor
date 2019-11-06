# numpy usage
# import numpy as np

# a = np.array([[1, 2, 3], [4, 5, 6]])
# b = np.array([[7, 8, 9], [10, 11, 12]])

# print(a * b)

# math usage
# import math

# print(abs(-3))
# print(max(2, 3, 4 ,5))

# JSON
# json = {
#     "이름": "홍길동",
#     "나이": 25,
#     "성별": "여",
#     "주소": "서울특별시 양천구 목동",
#     "특기": [
#         "농구",
#         "도슬"
#     ],
#     "가족관계": {
#         "#": 2,
#         "아버지": "홍판서",
#         "어머니": "춘섬"
#     },
#     "회사": "경기 수원시 팔달구 우만동"
# }

# print(json)

import json

with open('practice/week09.json', 'r', encoding='utf-8') as f:
    data = json.load(f)

data = {
    "이름": "홍길동",
    "학번": 25,
    "전공": "컴퓨터공학",
    "수강": [
        {
            "과목": "",
            "교수": "",
            "학점": 3,
            "학년": 2,
            "팀": []
        }
    ]
}

with open('./week09.json', 'w', encoding='utf-8') as f:
    json.dump(data, f, ensure_ascii=False, indent=4)

db = []
st_record = {
    "name": "홍길동",
    "student number": 25,
    "department": "컴퓨터공학",
    "cource": []
}
oop_course = {
    "name": "객체지향설계",
    "team": []
}
math_course = {
    "team": []
}

db.append(st_record)