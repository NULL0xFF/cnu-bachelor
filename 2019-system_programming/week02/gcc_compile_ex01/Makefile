.SUFFIXES: .c .o

OBJECTS = ex01.o add.o sub.o

CC = gcc
CFLAGS = -W -Wall

TARGET = ex01

$(TARGET) : $(OBJECTS)
	$(CC) $(CFLAGS) -o $(TARGET) $(OBJECTS)

clean :
	rm -rf $(OBJECTS) $(TARGET)

ex01.o : ex01.c

add.o : add.c

sub.o : sub.c
