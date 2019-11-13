.SUFFIXES: .cpp .o

OBJECTS = human.o student.o smart_obj.o shared_ref.o weak_pointer.o
TEST = test.o $(OBJECTS)

CXX = g++

TARGET = test

$(TARGET) : $(TEST)
	$(CXX) -o $(TARGET) $(TEST)

clean :
	rm -rf $(TEST) $(TARGET)

human.o : human.cpp
student.o : student.cpp
smart_obj.o : smart_obj.cpp
shared_ref.o : shared_ref.cpp
weak_pointer.o : weak_pointer.cpp
test.o : test.cpp