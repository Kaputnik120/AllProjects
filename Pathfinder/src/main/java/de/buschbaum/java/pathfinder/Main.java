package de.buschbaum.java.pathfinder;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 * Hello world!
 *
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello Pi!");
        System.out.println("Creating GpioController...");
        GpioController controller = GpioFactory.getInstance();
        System.out.println("Creating myLed Pin...");
        GpioPinDigitalOutput myLed = controller.provisionDigitalOutputPin(RaspiPin.GPIO_04, "My LED", PinState.LOW);
        while (true) {
            System.out.println("Setting myLed state to high...");
            myLed.setState(PinState.HIGH);
            System.out.println("Waiting 5 seconds");
            Thread.sleep(5000);
            System.out.println("Setting myLed state to low...");
            myLed.setState(PinState.LOW);
            System.out.println("Waiting 5 seconds");
            Thread.sleep(5000);
        }
    }
}
