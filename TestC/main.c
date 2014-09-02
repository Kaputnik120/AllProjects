/* 
 * File:   main.c
 * Author: Uli
 *
 * Created on 23. Oktober 2013, 19:04
 */

#include <stdio.h>
#include <stdlib.h>

void print(); //Funktionsprototyp
int main(int argc, char** argv) {
    //operateBit();
    //print();
    //printTypes();
    //pointFail();
    //point();
    //pointArray();
    mem();
    return (EXIT_SUCCESS);
}

int checkPrime(int number) {
    if (precheckPrime(number) == 0) {
        return 0;
    }

}

int precheckPrime(int number) {

    if (number % 2 == 0 || number % 5 == 0) {
        return 0;
    }
    if (number < 3) {
        return 0;
    }
    return 1;
}

void convertAndPrintNumber(int number, int positions) {
    char str[positions];
    sprintf(str, "%d", number);
    printf(str);
}

