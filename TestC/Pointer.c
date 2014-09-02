#include <stdio.h>

void pointFail() {
    int a = 12;
    int *pointer;
    pointer = &a;
    printf("Pointer ist: %d", *pointer);
    int *nullpointer = NULL;
    printf("NullPointer ist: %d", *nullpointer);
}

void point() {
    int zahl = 7;
    int *zeiger = &zahl;

    printf("Adresse zahl: %p\n", &zahl);
    printf("Wert zahl: %d\n\n", zahl);
    printf("Adresse zeiger: %p\n", &zeiger);
    printf("Wert zeiger: %p\n", zeiger);
    printf("Wert von Adresse %p: %d\n\n", zeiger, *zeiger);

    int **zeigerAufZeiger = &zeiger;
    printf("Adresse von zeigerAufZeiger: %p\n", &zeigerAufZeiger);
    printf("Wert von zeigerAufZeiger: %d\n", **zeigerAufZeiger);
    printf("Adresse von zeiger: %p\n", &zeiger);

}

void pointArray() {
    int punkte[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    // Positionszeiger
    int *pos;

    // Position auf erstes Element setzen (punkte[0]) 
    pos = punkte;
    printf("(punkte[0]) Wert pos: %d\n", *pos);

    // Position auf naechstes Element setzen (punkte[1])
    pos++;
    printf("(punkte[1]) Wert pos: %d\n", *pos);

    // Position auf 5. Element setzen (punkte[4])
    pos = punkte + 4;
    printf("(punkte[4]) Wert pos: %d\n", *pos);

    // Position auf vorheriges Element setzen (punkte[3])
    pos--;
    printf("(punkte[3]) Wert pos: %d\n", *pos);
    
    pos = punkte + 11;
    printf("Aus Array herausgesprungen %d\n", *pos);
}