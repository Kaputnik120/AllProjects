#include "handle_errors.h"
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <errno.h>
#include <string.h>

void runHandleErrors() {
    
    int ret = close(123);
    printf("Return code of close(...) is %i\n",ret);
    if (ret < 0) {
        printf("Error Code is %i\n", errno);
        char* msg = strerror(errno);
        printf("%s\n",msg);
    }
    
}
