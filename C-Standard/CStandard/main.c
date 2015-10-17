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
    
    runCreateProcess();
    
    printf("Stopped!\n");
    return (EXIT_SUCCESS);
}

