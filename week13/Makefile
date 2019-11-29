.SUFFIXES: .cpp .hpp .h .o

OBJECTS = lib/getch.o object/object.o object/object_gray.o puyo/puyo.o
MAIN = main.o $(OBJECTS)

CXX = g++
LIB_DIR = lib
PUYO_DIR = puyo
OBJ_DIR = object
CPPFLAGS = -Wall -O -std=c++11 -pthread

TARGET = main

$(TARGET) : $(MAIN)
	$(MAKE) -C $(LIB_DIR)
	$(MAKE) -C $(OBJ_DIR)
	$(MAKE) -C $(PUYO_DIR)
	$(CXX) $(MAIN) $(CPPFLAGS) -o $(TARGET) 

clean :
	rm -rf $(TARGET) $(MAIN)

main.o : main.cpp