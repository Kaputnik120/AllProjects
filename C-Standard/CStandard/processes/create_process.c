#include "processes.h"
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include "sys/types.h"
#include <sys/wait.h>

int createProcess();

/**
 * Tests some features of the stdlib
 */
void runCreateProcess() {

    //Check for existing Command Processor
    int res = system(NULL);
    if (res > 0) {
        printf("Command Processor available!\n");

        //Create process via system(...))
        printf("Create process with system(...), output is: \n\n");
        int resCreate = createProcess();
        printf("\n");
        if (resCreate == 0) {
            printf("Process creation successful. Return code: %i\n", resCreate);
        } else {
            printf("Process creation failed. Return code: %i\n", resCreate);
        }

        //Make some PID stuff
        pid_t pid = getpid();
        printf("The current PID is %ld\n", pid);
#ifdef LINUX
        pid_t ppid = getppid();
        printf("The parent PID is %ld\n", ppid);
#endif
        //Some fork() stuff
        pid = fork();
        if (pid < 0) {
            printf("Call to pid, didn't succeed - pid %ld\n", pid);
        } else if (pid == 0) {
            //Child-Stdout is not displayed
            printf("Child: Entering the child code path - pid %ld\n", pid);
#ifdef LINUX
            printf("Child: parent pid is %ld\n", getppid());
#endif
            printf("Child: Finished!\n");
            exit(0);
        } else {
            printf("Parent: Waiting for child!\n");
            int * statusPtr;
            waitpid(pid,statusPtr, 0);
            printf("Parent: waitpid returned with %i\n", statusPtr);
            printf("Parent: Entering the parent code path - pid %ld\n", pid);
        }
    } else {
        printf("No Command Processor available!\n");
    }
}

/**
 * Simplest possible process creation with system(...) call. 
 */
int createProcess() {
#ifdef LINUX
    return system("ls");
#endif
#ifdef WINDOWS
    return system("DIR");
#endif
}
