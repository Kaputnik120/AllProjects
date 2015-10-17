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
    
    printf("PROCESSES:\n\n");
    runCreateProcess();
    printf("\nERRORS:\n\n");
    runHandleErrors();
    
    printf("Stopped!\n");
    return (EXIT_SUCCESS);
}

