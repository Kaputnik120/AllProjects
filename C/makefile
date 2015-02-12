#Variables
VERSION = 1.0
CFLAGS = 
LDFLAGS = 
OBJS = main.o foo.o bar.o

#Binary specific to OS
ifeq ($(OS),win)
	BIN = prog.exe
else
	BIN = prog
endif

#Compiler specific to OS
ifeq ($(OS),win)
	CC = gcc.exe
else
	CC = /usr/bin/gcc
endif

#Default target
prog: $(OBJS)
	@echo "Creating binary $(BIN)"
	$(CC) $(CFLAGS) -o $(BIN) $(OBJS) $(LDFLAGS)
	@echo "Finished compilation"

#Removal of all binary files
ifeq ($(OS),win)
.PHONY: clean
clean: 
	@echo "Deleting files"
	cmd del $(OBJS) $(BIN)
	@echo "Finished deleting files"
else
.PHONY: clean
clean: 
	@echo "Deleting files"
	rm -rf $(OBJS) $(BIN)
	@echo "Finished deleting files"
endif

#Compilation of all .c files
*.o: *.c
	@echo "Creating dependency file for $*.c"
	$(CC) $(CFLAGS) -MM $*.c > $*.d
	@echo "Creating object file for $*.c"
	$(CC) $(CFLAGS) -c $*.c -o $*.o

#Pull in dependency information
-include: $(OBJS:$*.o=$*.d)

