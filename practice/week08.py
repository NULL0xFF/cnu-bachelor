# Overloading Practice
# import numpy as np


# class Box:
#     def __init__(self):
#         self.width = 3
#         self.height = 5

#     def __str__(self):
#         return "{} + {} BOX".format(self.width, self.height)


# b = Box()
# print(b)

# a = np.array([1, 2, 3])
# print(a)

########################################
########################################

class Quadrangle:
    def __init__(self, width, height):
        self.width = width
        self.height = height

    def __add__(self, other):
        if type(other) == int:
            return Quadrangle(self.width + other, self.height + other)
        return Quadrangle(self.width + other.width, self.height + other.height)

    def __str__(self):
        return "width : {}, height : {}".format(self.width, self.height)

    def __mul__(self, other):
        if type(other) == int:
            return Quadrangle(self.width * other, self.height * other)
        return Quadrangle(self.width * other.width, self.height * other.height)

    def __len__(self):
        return (self.width * 2) + (self.height * 2)

    def __getitem__(self, value):
        return self.width if value == 0 else self.height if value == 1 else -1


q1 = Quadrangle(2, 3)
q2 = Quadrangle(4, 5)

print(q1)
print(q2)
print(q1 + 10)
print(q1 + q2)
print(q1 * 2)
print(len(q1))
print(q1[0], q1[1])

########################################
########################################

word = "computer science"
without_vowels = [consonant for consonant in word if consonant not in {
    'a', 'i', 'u', 'o', 'e'}]

print(without_vowels)

########################################
########################################

matrix = [
    [1, 2, 3, 4],
    [5, 6, 7, 8],
    [9, 10, 11, 12],
]
flatten = [e for r in matrix for e in r]
print(flatten)

########################################
########################################

subjects = ['math', 'history', 'english', 'computer engineering']
scores = [90, 80, 95, 100]
score_dict = {subject: score for subject, score in zip(subjects, scores)}
print(score_dict)
