.SUFFIXES: .cpp .hpp .o

OBJECTS = puyo.o
CPP = puyo.cpp

CXX = g++
CPPFLAGS = -c

TARGET = main

$(TARGET) : $(CPP)
	$(CXX) $(CPPFLAGS) $(CPP)

clean:
	rm -rf $(OBJECTS)

puyo.o : puyo.cpp