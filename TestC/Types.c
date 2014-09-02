#include <stdio.h>
void printTypes() {
    
    printf("short:\t\t%d Bit\n", sizeof(short)*8);
    printf("int:\t\t%d Bit\n", sizeof(int)*8);
    printf("long:\t\t%d Bit\n", sizeof(long)*8);
    printf("long long:\t%d Bit\n", sizeof(long long)*8);
    
    printf("float:\t\t%d Bit\n", sizeof(float)*8);
    printf("double:\t\t%d Bit\n", sizeof(double)*8);
    printf("long double:\t%d Bit\n", sizeof(long double)*8);
    
    char str = 'A';
    int a= (int) str;
    printf("Cast 'A' to int: %d\n", a);
}
