#include <Arduino.h>

extern HardwareSerial Serial;

#define DATA 6
#define LATCH 8
#define CLOCK 10

void blink(byte cols, byte rows);

void setup() {
    pinMode(LATCH, OUTPUT);
    pinMode(CLOCK, OUTPUT);
    pinMode(DATA, OUTPUT);
}

void loop() {
    blink(B00000000, B11111111);
    delay(500);
    blink(B11111111, B00000000);
    delay(500);
    blink(B11110000, B00001111);
    delay(500);
    blink(B00001111, B11110000);
    delay(500);
    blink(B00000000, B01010101);
   delay(500);
    blink(B00000000, B10101010);
    delay(500);
    blink(B10101010, B01010101);
    delay(500);
//    do {
//    } while (1);

}

void blink (byte cols, byte rows) {
    digitalWrite(LATCH, LOW);
    //Spalten
    shiftOut(DATA, CLOCK, MSBFIRST, cols);
    //Zeilen
    shiftOut(DATA, CLOCK, MSBFIRST, rows);
    digitalWrite(LATCH, HIGH);
}