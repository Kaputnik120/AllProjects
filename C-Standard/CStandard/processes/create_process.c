#include "processes.h"
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include "sys/types.h"
#include <sys/wait.h>
#include <errno.h>
#include <string.h>

int createProcess();

#ifdef LINUX
char bin[] = "ls";
#endif
#ifdef WINDOWS
char bin[] = "bin";
#endif

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
            printf("Call to pid, didn't succeed - pid = %ld\n", pid);
        } else if (pid == 0) {
            printf("Child: Entering the child code path - pid = %ld\n", pid);
#ifdef LINUX
            printf("Child: parent pid is %ld\n", getppid());
#endif
            printf("Child: Try changing to ls: \n\n");
            char* params[2] = {"-v", NULL};
            int res = execvp("ls", &params);
            if (res == 0) {
                printf("\nChild: Changed executing program to ls!\n");
            } else {
                printf("Child: Error while changing executing program to ls!\n");
                printf("Child: Error is %s\n", strerror(errno));
            }


            printf("Child: Finished!\n");
            exit(0);
        } else {
            printf("Parent: Waiting for child!\n");
            int * statusPtr;
            waitpid(pid, &statusPtr, 0);
            printf("Parent: waitpid set the status pointer to %i\n", statusPtr);
            int normExit = WIFEXITED(statusPtr);
            printf("Parent: WIFEXITED is %i\n", normExit);
            if (normExit > 0) {
                printf("The child process terminated normally.\n");
            } else {
                printf("The child process didn't terminate normally.\n");
            }
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
    return system(bin);
}
