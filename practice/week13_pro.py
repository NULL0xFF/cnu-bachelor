class Student:
    def __init__(self, name, st, major):
        self.name = name
        self.st_number = st
        self.major = major

    def set_name(self, name):
        self.name = name

    def set_st_number(self, st):
        self.st = st

    def set_major(self, major):
        self.major = major

    def pretty_print(self):
        print("Name : {}\tStudent Nunber : {}\tMajor : {}".format(
            self.name, self.st_number, self.major))


class MStudent:
    def __init__(self):
        self.m_student_list = []

    def add_student(self, student):  # student : object --> class
        self.m_student_list.append(student)

    def pretty_print(self):
        for student in self.m_student_list:
            student.pretty_print()
    
    def change_student_number(self, name, to_st_number):
        for student in self.m_student_list:
            if student.name == name:
                student.st_number = to_st_number
                return
    def change_student_number_bad(self, name, to_st_number):
        student_number_list = [student.st_number for student in self.m_student_list]
        student_number_list[1] = to_st_number

my_m = MStudent()
my_m.add_student(Student("hong", 2017023, "cse"))
my_m.add_student(Student("kang", 2012025, "kse"))
my_m.add_student(Student("kim", 2011025, "zzz"))
my_m.pretty_print()
# ------------------------------ #
my_m.change_student_number("kang", 20)
my_m.pretty_print()