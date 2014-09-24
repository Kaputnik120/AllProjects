#include <Arduino.h>

extern HardwareSerial Serial;

int ENABLE_1 = 5;
int INPUT_1 = 0;
int INPUT_2 = 1;
int ENABLE_2 = 6;
int INPUT_3 = 2;
int INPUT_4 = 3;

void setup() {

    pinMode(ENABLE_1, OUTPUT);
    pinMode(INPUT_1, OUTPUT);
    pinMode(INPUT_2, OUTPUT);
    pinMode(ENABLE_2, OUTPUT);
    pinMode(INPUT_3, OUTPUT);
    pinMode(INPUT_4, OUTPUT);

}

void loop() {

//    analogWrite(ENABLE_1, 127);
//    digitalWrite(INPUT_1, LOW);
//    digitalWrite(INPUT_2, HIGH);
    digitalWrite(ENABLE_2, HIGH);
    digitalWrite(INPUT_3, HIGH);
    digitalWrite(INPUT_4, LOW);
//    delay(2000);
    digitalWrite(ENABLE_1, HIGH);
    digitalWrite(INPUT_1, HIGH);
    digitalWrite(INPUT_2, LOW);
//    delay(2000);

    //    analogWrite(ENABLE_1, 255);
    //    digitalWrite(INPUT_1, LOW);
    //    digitalWrite(INPUT_2, HIGH);
    //    analogWrite(ENABLE_2, 255);
    //    digitalWrite(INPUT_3, HIGH);
    //    digitalWrite(INPUT_4, LOW);
    //    delay(2000);
    //    
    //    analogWrite(ENABLE_1, 255);
    //    digitalWrite(INPUT_1, HIGH);
    //    digitalWrite(INPUT_2, LOW);
    //    analogWrite(ENABLE_2, 255);
    //    digitalWrite(INPUT_3, LOW);
    //    digitalWrite(INPUT_4, HIGH);
    //    delay(2000);
    //    
    //    analogWrite(ENABLE_1, 255);
    //    digitalWrite(INPUT_1, HIGH);
    //    digitalWrite(INPUT_2, LOW);
    //    analogWrite(ENABLE_2, 255);
    //    digitalWrite(INPUT_3, HIGH);
    //    digitalWrite(INPUT_4, LOW);
    //    delay(2000);

}