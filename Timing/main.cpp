#include <Arduino.h>

extern HardwareSerial Serial;

#define DATA 6
#define LATCH 8
#define CLOCK 10

void wait(unsigned long start, unsigned long end, unsigned int duration);

void setup() {
    pinMode(LATCH, OUTPUT);
    pinMode(CLOCK, OUTPUT);
    pinMode(DATA, OUTPUT);
    Serial.begin(115200);
}

void loop() {
    Serial.println("Loop begin");

    unsigned long start = millis();
    Serial.println(start);

    for (int i = 0; i < 2; i++) {

        Serial.println(i);
        digitalWrite(LATCH, LOW);
        shiftOut(DATA, CLOCK, MSBFIRST, i);
        digitalWrite(LATCH, HIGH);
        delay(50);

    }

    Serial.println("Loop end");

    unsigned long end = millis();
    Serial.println(end);

    wait(start, end, 2);

    Serial.println("Real end");
    Serial.println(millis());
}

void wait(unsigned long start, unsigned long end, unsigned int duration) {
    Serial.println("Is more than duration?");
    Serial.println(end - start < duration * 1000);
    Serial.println("How long to wait?");
    Serial.println(duration * 1000 - (end - start));
    if (end - start < duration * 1000) {
        delay(duration * 1000 - (end - start));
    }
}