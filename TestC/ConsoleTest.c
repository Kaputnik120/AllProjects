/* 
 * File:   ConsoleTest.c
 * Author: Uli
 *
 * Created on 27. Oktober 2013, 16:35
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
void print() {

    printf("Larfari \n");
    char c = (char) getchar();
    printf("Eingabe ist: %c\n", c);
    printf("Larfari \n");
    //system("PAUSE");
    int tag, monat, jahr;
    printf("Bitte geben Sie ihr Geburtsdatum ein [TT.MM.JJJJ]: ");
    scanf("%d.%d.%d", &tag, &monat, &jahr);
    printf("\nIhr internationales Geburtsdatum: %04d-%02d-%02d\n", jahr, monat, tag);

    return (EXIT_SUCCESS);
}

