/* 
 * File:   main.c
 * Author: UCB
 *
 * Created on 16. Oktober 2015, 11:00
 */

#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include "processes/processes.h"
#include "errors/handle_errors.h"
#include "asm/asm.h"

/*
 * 
 */
int main(int argc, char** argv) {
    printf("Started!\n");

#ifdef LINUX
    printf("Compiled for Linux!\n");
#endif
#ifdef WINDOWS
    printf("Compiled for Windows!\n");
#endif
    
//    const char hello[] = "Hello World!\n";
//    const size_t hello_size = sizeof(hello);
//    ssize_t ret;
//    asm volatile
//    (
//        "movl $1, %%eax\n\t"
//        "movl $1, %%edi\n\t"
//        "movq %1, %%rsi\n\t"
//        "movl %2, %%edx\n\t"
//        "syscall"
//        : "=a"(ret)
//        : "g"(hello), "g"(hello_size)
//        : "%rdi", "%rsi", "%rdx", "%rcx", "%r11"
//    );
    
    asm ("movq $1,%rax\n movq $0,%rdi\n syscall");
    
//        asm volatile
//    (
//        "movl $3, %%eax\n\t"
//        "movl $0, %%edi\n\t"
//        "syscall"
//        : "=a"(ret)
//        : "g"(hello), "g"(hello_size)
//        : "%rdi"
//    );
    
    
    printf("\n0. ASM \n\n");
//    runAsm();
    printf("\n2. ERRORS:\n\n");
    runHandleErrors();
    printf("\n26. PROCESSES:\n\n");
    runCreateProcess();

    printf("Stopped!\n");
    return (EXIT_SUCCESS);
}

