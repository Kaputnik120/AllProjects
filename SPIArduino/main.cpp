#include <Arduino.h>
#include "SPI.h"

extern HardwareSerial Serial;

void setup() {
    pinMode(10, OUTPUT);
    digitalWrite(10, HIGH);
    SPI.begin();
    SPI.setBitOrder(MSBFIRST);
}

void loop() {
    digitalWrite(10, LOW);
    SPI.transfer(0xFF);
    digitalWrite(10, HIGH);
//    delay(5000);
}