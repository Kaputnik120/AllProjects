#Variables
VERSION = 1.0
CFLAGS = 
LDFLAGS_BASIC = 
LDFLAGS_WIN = -lgdi32
LDFLAGS_LINUX = 
OBJS_WIN = win.o
OBJS_LINUX = linux.o
OBJS_BASIC = main.o foo.o bar.o
OS_WIN = win
OS_LINUX = linux

#Libraries specific to OS
ifeq ($(OS),$(OS_WIN))
	LDFLAGS = $(LDFLAGS_BASIC) $(LDFLAGS_WIN) 
endif
ifeq ($(OS),$(OS_LINUX))
	LDFLAGS = $(LDFLAGS_BASIC) $(LDFLAGS_LINUX) 
endif

#Object files specific to OS
ifeq ($(OS),$(OS_WIN))
	OBJS = $(OBJS_BASIC) $(OBJS_WIN) 
endif
ifeq ($(OS),$(OS_LINUX))
	OBJS = $(OBJS_BASIC) $(OBJS_LINUX) 
endif

#Binary specific to OS
ifeq ($(OS),$(OS_WIN))
	BIN = prog.exe
endif
ifeq ($(OS),$(OS_LINUX))
	BIN = prog
endif

#Compiler specific to OS
ifeq ($(OS),$(OS_WIN))
	CC = gcc.exe
endif
ifeq ($(OS),$(OS_LINUX))
	CC = /usr/bin/gcc
endif

#Default target
prog: $(OBJS)
	@echo "Creating binary $(BIN)"
	$(CC) $(CFLAGS) -o $(BIN) $(OBJS) $(LDFLAGS)
	@echo "Finished compilation"

#Removal of all binary files
ifeq ($(OS),$(OS_WIN))
.PHONY: clean
clean: 
	@echo "Deleting files"
	cmd /C del $(OBJS) $(BIN)
	@echo "Finished deleting files"
endif
ifeq ($(OS),$(OS_LINUX))
.PHONY: clean
clean: 
	@echo "Deleting files"
	rm -rf $(OBJS) $(BIN)
	@echo "Finished deleting files"
endif

#Compilation and dependency file creation of all .c files
*.o: *.c
	@echo "Creating dependency file for $*.c"
	$(CC) $(CFLAGS) -MM $*.c > $*.d
	@echo "Creating object file for $*.c"
	$(CC) $(CFLAGS) -c $*.c -o $*.o

#Pull in dependency information
-include: $(OBJS:$*.o=$*.d)

