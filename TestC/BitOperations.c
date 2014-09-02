#include <stdio.h>

void operateBit() {
    unsigned int a = 7; //0111
    unsigned int b = 15;//1111
    unsigned int c = a & b;
    //ACHTUNG %d ist für signed Variablen
    printf("UND: %u\n", c);
    c = a | b;
    printf("ODER: %u\n", c);
    c = a ^ b;
    printf("XOR: %u\n", c);
    c = ~b;
    printf("NICHT b: %u\n", c);
    c = b >> 1;
    printf("15 SHIFT 1 RECHTS: %u\n", c);
    
}
