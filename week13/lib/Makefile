.SUFFIXES: .c .h .o

OBJECTS = getch.o
CPP = getch.c

CXX = g++
CPPFLAGS = -c

TARGET = main

$(TARGET) : $(CPP)
	$(CXX) $(CPPFLAGS) $(CPP)

clean:
	rm -rf $(OBJECTS)

getch.o : getch.cpp