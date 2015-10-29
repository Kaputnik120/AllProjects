#include "asm.h"
#include <stdio.h>

void runAsm() {

    char msg[] = "test";
    unsigned int res = 0;
    asm("movl $12, %%edx\n\t" //Message length
            "movl %0, %%ecx\n\t" //Message
            "movl $1, %%ebx\n\t" //file descriptor (1=stdout)
            "movl $4, %%eax\n\t" //syscall number (4=sys_write)
            "syscall"
            : "=r"(res) /* output */
            : "r"(msg) /* input */
            );
    printf("Result of asm syscall is %i\n", res);

    //    res = 0;
    printf("Beginning syscall.\n");
    int res = -14235;

    asm("mov $3,%%rax;"
            "mov $0,%%rdi;"
            "syscall"
            : "=r" (res)
            :
            );

    printf("Syscall ended. Result is %i\n", res);
    //    printf("Result of asm syscall is %i\n", res);
}
