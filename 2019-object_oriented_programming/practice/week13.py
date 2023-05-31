class student:
    def __init__(self, name, id, major):
        self.name = name
        self.id = id
        self.major = major

    def print(self):
        print("Name : {}\tID : {}\tMajor : {}".format(
            self.name, self.id, self.major))


class MajorList:
    def __init__(self):
        self.students = []

    def addStudent(self, student):
        self.students.append(student)

    def print(self):
        for student in self.students:
            student.print()


def modifyStudentNum(majorList, _name, _id):
    for student in majorList.students:
        if(student.name == _name):
            student.id = _id
            return


def modifyMajor(majorList, _name, _major):
    for student in majorList.students:
        if(student.name == _name):
            student.major = _major
            return


def modifyAllMajor(majorList, _major):
    for student in majorList.students:
        student.major = _major


mlist = MajorList()
mlist.addStudent(student("go gil dong", 1, "kumdo"))
mlist.addStudent(student("ho i dooly", 2, "archeology"))
mlist.addStudent(student("jackson michol", 3, "music"))
mlist.print()
print("########################################")
modifyStudentNum(mlist, "ho i dooly", 4)
mlist.print()
print("########################################")
modifyMajor(mlist, "ho i dooly", "magic")
mlist.print()
print("########################################")
modifyAllMajor(mlist, "cse")
mlist.print()
