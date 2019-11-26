class student:
    def __init__(self, name, id, major):
        self.name = name
        self.id = id
        self.major = major


class MajorList:
    def __init__(self):
        self.students = []

    def addStudent(self, student):
        self.students.append(student)


def modifyStudentID(mList, name, _id):
    for student in mList.students:
        if(student.name == name):
            student.id = id
            return
    return


def modifyMajor(mList, _name, _major):
    
