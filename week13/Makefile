.SUFFIXES: .cpp .hpp .c .h .o

CSOURCES := $(shell find . -name '*.c')
CPPSOURCES := $(shell find . -name '*.cpp')
COBJECTS := $(CSOURCES:.c=.o)
CPPOBJECTS := $(CPPSOURCES:.cpp=.o)

OBJECTS = $(COBJECTS) $(CPPOBJECTS)

CXX = g++
CXXFLAGS = -W -Wall -O2 -pthread

TARGET = main

$(TARGET) : $(OBJECTS)
	$(CXX) $(OBJECTS) $(CXXFLAGS) -o $(TARGET)

clean :
	rm -rf $(TARGET) $(OBJECTS)