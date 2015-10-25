#Define module object files
obj-m += HelloWorldModule.o

UNAME_R = $(shell uname -r)
ENV_VAR = $(KERNEL_VERSION)

ifeq ($(ENV_VAR),)
all:
	make -C /lib/modules/$(UNAME_R)/build M=$(PWD) modules
clean:
	make -C /lib/modules/$(UNAME_R)/build M=$(PWD) clean
else
all:
	make -C /lib/modules/$(ENV_VAR)/build M=$(PWD) modules
clean:
	make -C /lib/modules/$(ENV_VAR)/build M=$(PWD) clean
endif