#include <Arduino.h>

#define westButton 7
#define westRed 5
#define westYellow 4
#define westGreen 3

#define eastButton 8
#define eastRed 12
#define eastYellow 11
#define eastGreen 10

#define yellowBlinkTime 500

boolean trafficWest = true;
int flowTime = 2000;
int changeDelay = 1000;

extern HardwareSerial Serial;

void setup() {
    Serial.begin(115200);
    Serial.println("Starting after 2 seconds...");
    delay(2000);
    Serial.println("Initializing...");
    pinMode(westButton, INPUT);
    pinMode(eastButton, INPUT);
    pinMode(westRed, OUTPUT);
    pinMode(westYellow, OUTPUT);
    pinMode(westGreen, OUTPUT);
    pinMode(eastRed, OUTPUT);
    pinMode(eastYellow, OUTPUT);
    pinMode(eastGreen, OUTPUT);

    digitalWrite(westRed, LOW);
    digitalWrite(westYellow, LOW);
    digitalWrite(westGreen, HIGH);
    digitalWrite(eastRed, HIGH);
    digitalWrite(eastYellow, LOW);
    digitalWrite(eastGreen, LOW);
    Serial.println("Initialized!");
}

void loop() {
    Serial.println("DoingLoop...");
    if (digitalRead(westButton) == HIGH) {
        Serial.println("WestButton is HIGH");
        if (trafficWest != true) {
            trafficWest = true;
            delay(flowTime);
            digitalWrite(eastGreen, LOW);
            digitalWrite(eastYellow, HIGH);
            delay(flowTime);
            digitalWrite(eastYellow, LOW);
            digitalWrite(eastRed, HIGH);
            delay(changeDelay);
            for (int i = 0; i < 5; i++) {
                digitalWrite(westYellow, LOW);
                delay(yellowBlinkTime);
                digitalWrite(westYellow, LOW);
                delay(yellowBlinkTime);
            }
            digitalWrite(westYellow, LOW);
            digitalWrite(westRed, LOW);
            digitalWrite(westGreen, HIGH);
        }
    } else {
        Serial.println("WestButton is LOW");
    }
    if (digitalRead(eastButton) == HIGH) {
        Serial.println("EastButton is HIGH");
        if (trafficWest == true) {
            trafficWest = false;
            delay(flowTime);
            digitalWrite(westGreen, LOW);
            digitalWrite(westYellow, HIGH);
            delay(changeDelay);
            digitalWrite(westYellow, LOW);
            digitalWrite(westRed, HIGH);
            delay(changeDelay);
            for (int i = 0; i < 5; i++) {
                digitalWrite(eastYellow, LOW);
                delay(yellowBlinkTime);
                digitalWrite(eastYellow, HIGH);
                delay(yellowBlinkTime);
            }
            digitalWrite(eastYellow, LOW);
            digitalWrite(eastRed, LOW);
            digitalWrite(eastGreen, HIGH);
        }
    } else {
        Serial.println("EastButton is LOW");
    }
    Serial.println("Loop ended.");
}