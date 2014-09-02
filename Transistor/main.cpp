#include <Arduino.h>

extern HardwareSerial Serial;

#define PIEZO 3

void setup() {
    pinMode(PIEZO, OUTPUT);
    Serial.begin(115200);
}

void loop() {
    Serial.println("Start Loop");
    analogWrite(PIEZO, 32);
    delay(500);
    analogWrite(PIEZO, 64);
    delay(500);
    analogWrite(PIEZO, 128);
    delay(500);
    analogWrite(PIEZO, 160);
    delay(500);
    analogWrite(PIEZO, 192);
    delay(500);
    analogWrite(PIEZO, 224);
    delay(500);
    analogWrite(PIEZO, 256);
    delay(500);
    Serial.println("End Loop");
}