VERSION = 1.0
CC = /usr/bin/gcc
CFLAGS = 
LDFLAGS = 

OBJ = main.o foo.o bar.o


prog: $(OBJ)
	$(CC) $(CFLAGS) -o prog $(OBJ) $(LDFLAGS)

*.o: *.c
	$(CC) $(CFLAGS) -c $<
