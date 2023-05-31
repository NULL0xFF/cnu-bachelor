.SUFFIXES : .cpp .o

OBJECTS = Integer.o Float.o Complex.o
TEST = test.o $(OBJECTS)

CXX = g++

TARGET = test

$(TARGET) : $(TEST)
	$(CXX) -o $(TARGET) $(TEST)

clean :
	rm -rf $(TEST) $(TARGET)

Integer.o : Integer.cpp
Float.o : Float.cpp
Complex.o : Complex.cpp
test.o : test.cpp