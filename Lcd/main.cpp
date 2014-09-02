#include <Arduino.h>
#include <LiquidCrystal.h>

extern HardwareSerial Serial;

LiquidCrystal lcd(4,5,6,7,8,9);

byte my_char[8] = {
  B00000,  
  B01010,  
  B01010,  
  B00000,  
  B00100,  
  B10001,  
  B01110,  
  B00000 };

void setup() {
    lcd.begin(16,2);
    lcd.createChar(0, my_char);
    lcd.clear();
}

void loop() {
    lcd.setCursor(0,0);
    lcd.print("Buschbaum");
    lcd.setCursor(0,1);
    lcd.print("geht ab!!!");
    lcd.write(byte(0));
    delay(10000);

}