#include <Arduino.h>

extern HardwareSerial Serial;

void setup() {
    Serial.begin(115200);
}

void loop() {


    float sensor = analogRead(0);
    float fractial5v = sensor / 1024;
    float fractial1v = fractial5v * 5;
    float celsius = fractial1v * 100;



    Serial.println(sensor);
    Serial.println(fractial5v);
    Serial.println(fractial1v);
    Serial.println(celsius);
    Serial.println("-------------------");
    delay(250);

}