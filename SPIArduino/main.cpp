// Written by Nick Gammon
// February 2011
/**
 * Send arbitrary number of bits at whatever clock rate (tested at 500 KHZ and 500 HZ).
 * This script will capture the SPI bytes, when a '\n' is recieved it will then output
 * the captured byte stream via the serial.
 */

#include "SPI.h"

void setup(void) {
    Serial.begin(115200); // debugging

    // have to send on master in, *slave out*
    //pinMode(MISO, INPUT);
    //pinMode(MOSI, INPUT);
    //pinMode(SCK, INPUT);

    //Act as slave
    SPCR |= _BV(SPE);
    //Use SPI mode 0 as the raspberry pi does
    SPI.setDataMode(SPI_MODE0);
}

void loop() {
    //    if (digitalRead(MISO) == HIGH) {
    //        Serial.println("MISO is high!");
    //    }
    //    if (digitalRead(MOSI) == HIGH) {
    //        Serial.println("MOSI is high!");
    //    }
    //    if (digitalRead(SCK) == HIGH) {
    //        Serial.println("SCK is high!");
    //    }
    
    int data = 230;
    int bytes = SPI.transfer(data);
    Serial.println("Bytes received");
    Serial.println(bytes);
} 