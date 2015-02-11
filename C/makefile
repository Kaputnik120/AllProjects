#Variables
VERSION = 1.0
CC = /usr/bin/gcc
CFLAGS = 
LDFLAGS = 

OBJS = main.o foo.o bar.o
BIN = prog

#Default target
prog: $(OBJS)
	$(CC) $(CFLAGS) -o $(BIN) $(OBJS) $(LDFLAGS)

#Removal of all binary files
.PHONY: clean
clean: 
	rm -rf $(OBJ) $(BIN)

#Compilation of all .c files
*.o: *.c
	$(CC) $(CFLAGS) -MM $*.c > $*.d
	$(CC) $(CFLAGS) -c $*.c -o $*.o

#Pull in dependency information
-include: $(OBJS:$*.o=$*.d)
