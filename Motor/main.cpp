#include <Arduino.h>

extern HardwareSerial Serial;

int BIN_1 = 3;
int BIN_2 = 5;
int AIN_1 = 6;
int AIN_2 = 9;
int MAX_PWM_VOLTAGE = 240;

void setup() {
    pinMode(BIN_1, OUTPUT);
    pinMode(BIN_2, OUTPUT);
    pinMode(AIN_1, OUTPUT);
    pinMode(AIN_2, OUTPUT);
}

void loop() {
    
    digitalWrite(BIN_2, LOW);
    digitalWrite(AIN_2, LOW);
    analogWrite(BIN_1, MAX_PWM_VOLTAGE);
    analogWrite(AIN_1, MAX_PWM_VOLTAGE);
    delay(2000);
    
    digitalWrite(BIN_1, LOW);
    digitalWrite(AIN_2, LOW);
    analogWrite(BIN_2, MAX_PWM_VOLTAGE);
    analogWrite(AIN_1, MAX_PWM_VOLTAGE);
    delay(2000);
    
    digitalWrite(BIN_2, LOW);
    digitalWrite(AIN_1, LOW);
    analogWrite(BIN_1, MAX_PWM_VOLTAGE);
    analogWrite(AIN_2, MAX_PWM_VOLTAGE);
    delay(2000);
    
    digitalWrite(BIN_1, LOW);
    digitalWrite(AIN_1, LOW);
    analogWrite(BIN_2, MAX_PWM_VOLTAGE);
    analogWrite(AIN_2, MAX_PWM_VOLTAGE);
    delay(2000);
}