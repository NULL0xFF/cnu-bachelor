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


# with open('./week09.json', 'r', encoding='utf-8') as f:
#     data = json.load(f)

# data = {
#     "이름": "홍길동",
#     "학번": 25,
#     "전공": "컴퓨터공학",
#     "수강": [
#         {
#             "과목": "",
#             "교수": "",
#             "학점": 3,
#             "학년": 2,
#             "팀": []
#         }
#     ]
# }

import json

db = []

# with open('./week09.json', 'r', encoding='utf-8') as f:
#     db = json.load(f)

st_record = {
    "students": {
        "student": [
            {
                "name": "홍길동",
                "student number": 1,
                "department": "컴퓨터공학과",
                "course": [
                    "객체지향설계",
                    "웹프로그래밍",
                    "알고리즘"
                ]
            },
            {
                "name": "이영수",
                "student number": 2,
                "department": "컴퓨터공학과",
                "course": [
                    "객체지향설계",
                    "컴퓨터구조",
                    "알고리즘"
                ]
            },
            {
                "name": "박지은",
                "student number": 3,
                "department": "컴퓨터공학과",
                "course": [
                    "객체지향설계",
                    "컴퓨터구조",
                    "시스템프로그래밍"
                ]
            },
            {
                "name": "박성호",
                "student number": 4,
                "department": "컴퓨터공학과",
                "course": [
                    "컴퓨터구조",
                    "시스템프로그래밍",
                    "웹프로그래밍"
                ]
            },
            {
                "name": "김유진",
                "student number": 5,
                "department": "컴퓨터공학과",
                "course": [
                    "시스템프로그래밍",
                    "웹프로그래밍",
                    "알고리즘"
                ]
            }
        ]
    }
}

cs_record = {
    "courses": {
        "course": [
            {
                "name": "객체지향설계",
                "team": [
                    "홍길동",
                    "이영수",
                    "박지은"
                ]
            },
            {
                "name": "컴퓨터구조",
                "team": [
                    "이영수",
                    "박지은",
                    "박성호"
                ]
            },
            {
                "name": "시스템프로그래밍",
                "team": [
                    "박지은",
                    "박성호",
                    "김유진"
                ]
            },
            {
                "name": "웹프로그래밍",
                "team": [
                    "박성호",
                    "김유진",
                    "홍길동"
                ]
            },
            {
                "name": "알고리즘",
                "team": [
                    "김유진",
                    "홍길동",
                    "이영수"
                ]
            }
        ]
    }
}

db.append(st_record)
db.append(cs_record)

with open('./week09.json', 'w+', encoding='utf-8') as f:
    json.dump(db, f, ensure_ascii=False, indent=4)
