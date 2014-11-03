#include <Arduino.h>

extern HardwareSerial Serial;
//
//int INIT_SECONDS = 30;
//int RUN_SECONDS = 60;
//int MEASUREMENT_INTERVAL = 250;
//
//int get_x_basis();
//
//void setup() {
//    Serial.begin(115200);
//    analogReference(INTERNAL);
//    //Set green led to low and red led to high
//    digitalWrite(11, HIGH);
//    digitalWrite(10, LOW);
//
//    //Calibrate accelerometer
////    Serial.println("INITIALIZING");
////    int x_basis = get_x_basis();
////    Serial.println("INITIALZING FINISHED - STARTING LOOP");
//
//    //Set green led to low and red led to high
//    digitalWrite(10, HIGH);
//}
//
//void loop() {
////    Serial.println("STARTED LOOP");
//    //Seconds running the calibration
////    for (int i = 0; i < RUN_SECONDS; i++) {
////        //Time of measurements per second
////        for (long j = 0; j < 1000 / MEASUREMENT_INTERVAL; j++) {
//            int x_acc_voltage = analogRead(7);
//            Serial.println(x_acc_voltage);
////            delayMicroseconds(MEASUREMENT_INTERVAL * 1000);
//            delay(250);
////        }
////    }
//    
////    Serial.println("FINISHED LOOP");
////    digitalWrite(10, LOW);
////    digitalWrite(11, LOW);
//    //NO-OP
////    while (true) {
////    }
//}
//
//int get_x_basis() {
//    //Seconds running the calibration
//    for (int i = 0; i < INIT_SECONDS; i++) {
//        //Time of measurements per second
//        for (long j = 0; j < 1000 / MEASUREMENT_INTERVAL; j++) {
//            int x_acc_voltage = analogRead(7);
////            Serial.print("i=");
////            Serial.print(i);
////            Serial.print(" j=");
////            Serial.print(j);
////            Serial.print(" x_acc_voltage=");
////            Serial.println(x_acc_voltage);
//            delayMicroseconds(MEASUREMENT_INTERVAL * 1000);
//        }
//    }
//}

void setup() {
    Serial.begin(115200);
//    analogReference(INTERNAL);
    pinMode(A0, INPUT);
}

void loop() {
    int sensorValue = analogRead(A0);
//    float voltage= sensorValue * (3.3 / 1023.0);
    Serial.println(sensorValue);
    delay(100);
}