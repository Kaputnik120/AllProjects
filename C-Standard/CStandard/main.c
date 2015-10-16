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
    
    runCreateProcess();
    
    printf("Stopped!\n");
    return (EXIT_SUCCESS);
}

