.SUFFIXES: .cpp .o

# json_list.o json_dict.o
OBJECTS = json_object.o data/String.o data/Integer.o
MAIN = main.o $(OBJECTS)

CXX = g++

DATA = data
TARGET = test

$(TARGET) : $(MAIN)
	$(CXX) -o $(TARGET) $(MAIN)

clean :
	rm -rf $(MAIN) $(TARGET)
