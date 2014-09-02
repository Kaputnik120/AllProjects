#include  <stdlib.h>
#include <stdio.h>

void mem() {
    int *pos;
    pos = malloc(sizeof(int)*8*1024*1024);
    printf("%p\n", &pos);
    printf("%d\n", *pos);
    
    int *secpos;
    secpos = calloc(8*1024*1024, sizeof(int)*8);
    printf("%p\n", &secpos);
    printf("%d\n", *secpos);
    
    free(pos);
    free(secpos);
    
    //printf("%p\n", &secpos); - Speicher bereits freigegeben - Fehlermeldung
    //printf("%d\n", *secpos);
}
