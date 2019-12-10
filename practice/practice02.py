# -*- coding: utf-8 -*- 

try:
    print("파일을 출력합니다.")
    f = open("test.txt", 'r', encoding='utf-8')
    while True:
        line = f.readline()
        if not line:
            break
        print(line)
    print("파일을 출력하였습니다.")
    print("파일에 붙여쓰기를 시작합니다. (Ctrl-C, Ctrl-D 로 종료)")
    f = open("test.txt", 'a')
    while True:
        print(">> ", end = '')
        try:
            line = input()
            f.write(line + '\n')
        except KeyboardInterrupt:
            break
        except EOFError:
            break
    print("\n파일을 작성하였습니다.")
except FileNotFoundError:
    print("파일이 없습니다.")
    print("파일을 새로 생성하시겠습니까? (Y/n)")
    while True:
        line = input()
        if line == "Y" or line == "y" or line == '\n':
            try:
                f = open("test.txt", 'w', encoding='utf-8')
                f.close()
            except PermissionError:
                raise
            finally:
                break
        elif line == "N" or line == "n":
            break
        else:
            print("다시 입력하세요")
except PermissionError:
    print("파일을 수정할 수 없습니다.")
