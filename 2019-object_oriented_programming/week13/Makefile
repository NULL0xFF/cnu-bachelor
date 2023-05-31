.SUFFIXES: .cpp .hpp .h .o

OBJECTS = block.o canvas.o visual.o puyo.o
MAIN = main.o $(OBJECTS)

CXX = g++
CXXFLAGS = -Wall -W -O2 -pthread -g


TARGET = main

$(TARGET) : $(MAIN)
	$(CXX) $(CXXFLAGS) $(MAIN) -o $(TARGET)

clean :
	rm -rf $(MAIN) $(TARGET)
