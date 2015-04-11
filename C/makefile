#Variables
VERSION = 1.0
CFLAGS = -fno-asynchronous-unwind-tables -ggdb
LDFLAGS_BASIC = 
LDFLAGS_WIN = -lgdi32
LDFLAGS_LINUX = -lX11
OBJS_WIN = win.o
OBJS_LINUX = linux.o
OBJS_BASIC = main.o foo.o bar.o
SRCS_BASIC=$(wildcard *.c)
SRCS_WIN=$(wildcard win/*.c)
SRCS_LINUX=$(wildcard linux/*.c)
ASMS=$(wildcard *.s) $(wildcard *.lst)
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

#Source files specific to OS
ifeq ($(OS),$(OS_WIN))
	SRCS = $(SRCS_BASIC) $(SRCS_WIN) 
endif
ifeq ($(OS),$(OS_LINUX))
	SRCS = $(SRCS_BASIC) $(SRCS_LINUX) 
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
prog: objectFiles
	@echo "Creating binary $(BIN)"
	$(CC) $(CFLAGS) -o $(BIN) $(OBJS) $(LDFLAGS)
	@echo "Finished compilation"

#Object files
objectFiles: $(SRCS)
	@echo "Creating assembly files for $^"
	$(CC) -S -c $^ $(CFLAGS) $(LDFLAGS)
	@echo "Creating assembly files with C code for $^"
	$(CC) -c -g -Wa,-a,-ad $^ > asm.lst
	@echo "Creating object files for $^"
	$(CC) -c $^ $(CFLAGS) $(LDFLAGS)
	
#Removal of all binary files
ifeq ($(OS),$(OS_WIN))
.PHONY: clean
clean: 
	@echo "Deleting files"
	cmd /C del $(OBJS) $(BIN) $(ASMS)
	@echo "Finished deleting files"
endif
ifeq ($(OS),$(OS_LINUX))
.PHONY: clean
clean: 
	@echo "Deleting files"
	rm -rf $(OBJS) $(BIN) $(ASMS)
	@echo "Finished deleting files"
endif

