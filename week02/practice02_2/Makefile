.SUFFIXES : .c .o

CC = gcc
CFLAGS = -W -Wall

OBJECTS = main.o add.o sub.o mul.o div.o memo.o calendar.o

TARGET = diary.out

$(TARGET) : $(OBJECTS)
	$(CC) $(CFLAGS) -o $(TARGET) $(OBJECTS)

clean :
	rm -rf $(OBJECTS) $(TARGET)

main.o : main.c
add.o : add.c
sub.o : sub.c
mul.o : mul.c
div.o : div.c
memo.o : memo.c
calendar.o : calendar.c
