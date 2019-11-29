.SUFFIXES: .cpp .hpp .o

OBJECTS = object.o object_gray.o
CPP = object.cpp object_gray.o

CXX = g++
CPPFLAGS = -c

TARGET = main

$(TARGET) : $(CPP)
	$(CXX) $(CPPFLAGS) $(CPP)

clean:
	rm -rf $(OBJECTS)

object.o : object.cpp
object_gray : object_gray.cpp