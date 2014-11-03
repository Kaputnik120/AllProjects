#include <Arduino.h>

#define newLED 10
#define okLED 11
#define oldLED 12

int analogValue = 0;
float voltage = 0;
int ledDelay = 2000;

extern HardwareSerial Serial;

void setup() {
    analogReference(EXTERNAL);
    Serial.begin(115200);
    pinMode(newLED, OUTPUT);
    pinMode(okLED, OUTPUT);
    pinMode(oldLED, OUTPUT);

}

void loop() {
    analogValue = analogRead(0);
    voltage = 0.0048 * analogValue;
    Serial.println(voltage);
    if (voltage >= 1.6) {
        digitalWrite(newLED, HIGH);
        delay(ledDelay);
        digitalWrite(newLED, LOW);
    } else if (voltage < 1.6 && voltage > 1.4) {
        digitalWrite(okLED, HIGH);
        delay(ledDelay);
        digitalWrite(okLED, LOW);
    } else if (voltage <= 1.4) {
        digitalWrite(oldLED, HIGH);
        delay(ledDelay);
        digitalWrite(oldLED, LOW);
    }
}