import sys
import io
sys.stdout = io.TextIOWrapper(sys.stdout.detach(), encoding='utf-8')
sys.stderr = io.TextIOWrapper(sys.stderr.detach(), encoding='utf-8')


class Student():
    countAll = 0

    def __init__(self, name, grade):
        self.name = name
        self.grade = grade
        Student.countAll += 1

    def introduceMyUniversity(self):
        print("저는 학생입니다.")


class CBNU_Student(Student):
    countCBNU = 0

    def __init__(self, name, grade, studentNumber):
        super().__init__(name, grade)
        self.__studentNumber = studentNumber
        CBNU_Student.countCBNU += 1

    def introduceMyUniversity(self):
        print("저는 충북대학교 학생입니다.")


class CNU_Student(Student):
    countCNU = 0

    def __init__(self, name, grade, studentNumber):
        super().__init__(name, grade)
        self.__studentNumber = studentNumber
        CNU_Student.countCNU += 1

    def getStudentNumber(self):
        return self.__studentNumber

    def introduceMyUniversity(self):
        print("저는 충남대학교 학생입니다.")


if __name__ == '__main__':

    newStudent = Student("a", 1)
    newStudent1 = CBNU_Student("b", 1, 201900000)
    newStudent2 = CBNU_Student("c", 2, 201800001)
    newStudent3 = CBNU_Student("d", 3, 201700002)
    newStudent4 = CBNU_Student("e", 4, 201600003)
    newStudent5 = CBNU_Student("f", 2, 201500004)
    newStudent6 = CNU_Student("g", 1, 201900010)
    newStudent7 = CNU_Student("h", 2, 201900020)
    newStudent8 = CNU_Student("i", 3, 201900030)
    newStudent9 = CNU_Student("j", 4, 201900040)
    newStudent10 = CNU_Student("k", 1, 201900050)

    me = CNU_Student("지명하", 2, 201802162)

    print("충북대학교 학생 수 : ", CBNU_Student.countCBNU, "명")
    print("충남대학교 학생 수 : ", CNU_Student.countCNU, "명")
    print("전체 학생 수 : ", Student.countAll, "명")
    print()
    print("제 이름은 ", me.name, "입니다.")
    print("저는 ", me.grade, " 학년 입니다.")
    print("저의 학번은 ", me.getStudentNumber(), "입니다.")
    me.introduceMyUniversity()

    """
    출력값
    
    충북대학교 학생 수 : 5명
    충남대학교 학생 수 : 6명
    전체 학생 수 : 12명   <---클래스 변수 사용

    제 이름은 OOO 입니다.
    저는 O 학년 입니다.
    저의 학번은 OOOOOOOOO 입니다.
    저는 충남대학교 학생입니다. <---함수 사용
    """
