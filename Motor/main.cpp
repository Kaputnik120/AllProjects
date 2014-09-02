#include <Arduino.h>

extern HardwareSerial Serial;

int ENABLE_1 = 10;
int INPUT_1 = 1;
int INPUT_2 = 2;

void setup() {

    pinMode(ENABLE_1, OUTPUT);
    pinMode(INPUT_1, OUTPUT);
    pinMode(INPUT_2, OUTPUT);

}

void loop() {
    analogWrite(ENABLE_1, 150);
    digitalWrite(INPUT_1, HIGH);
    digitalWrite(INPUT_2, LOW);

}