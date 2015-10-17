#include "processes.h"
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include "sys/types.h"

int createProcess();

pid_t getPid();

#ifdef LINUX
pid_t getParentPid();
#endif

/**
 * Tests some features of the stdlib
 */
void runCreateProcess() {

    //Check for existing Command Processor
    int res = system(NULL);
    if (res > 0) {
        printf("Command Processor available!\n");

        //Create process
        printf("Create process with system(...)\n");
        int resCreate = createProcess();
        if (resCreate == 0) {
            printf("Process creation successful. Return code: %i\n", resCreate);
        } else {
            printf("Process creation failed. Return code: %i\n", resCreate);
        }

        //Make some PID stuff
        pid_t pid = getPid();
        printf("The current PID is %ld\n", pid);
#ifdef LINUX
        pid_t ppid = getParentPid();
        printf("The parent PID is %ld\n", ppid);
#endif

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

/**
 * Returns the PID of the current process.
 * @return 
 */
pid_t getPid() {
    return getpid();
}

#ifdef LINUX

/**
 * Returns the PID of the parent process.
 * @return 
 */
pid_t getParentPid() {
    return getppid();
}
#endif

