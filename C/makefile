#Variables
VERSION = 1.0
CC = /usr/bin/gcc
CFLAGS = 
LDFLAGS = 

OBJ = main.o foo.o bar.o
BIN = prog

#Default target
prog: $(OBJ)
	$(CC) $(CFLAGS) -o $(BIN) $(OBJ) $(LDFLAGS)

#Removal of all binary files
.PHONY: clean
clean: 
	rm -rf $(OBJ) $(BIN)

#Compilation of all .c files
*.o: *.c
	$(CC) $(CFLAGS) -c $<

