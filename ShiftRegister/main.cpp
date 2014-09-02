#include <Arduino.h>

extern HardwareSerial Serial;

#define DATA 6
#define LATCH 8
#define CLOCK 10

void setup() {
    pinMode(LATCH, OUTPUT);
    pinMode(CLOCK, OUTPUT);
    pinMode(DATA, OUTPUT);
    Serial.begin(115200);
}

void loop() {
    for (int i = 0; i < 256; i++) {
        Serial.println("Loop begin");
        Serial.println(i);
        digitalWrite(LATCH, LOW);
        shiftOut(DATA, CLOCK, MSBFIRST, i);
        digitalWrite(LATCH, HIGH);
        delay(50);
        Serial.println("Loop end");
    }
}