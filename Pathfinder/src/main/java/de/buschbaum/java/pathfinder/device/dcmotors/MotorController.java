/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.device.dcmotors;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

/**
 * Controller for the dc-motors. The vehicle is driving towards the breadboard
 * direction and not in direction of the raspberry pi.
 *
 * @author uli
 */
public class MotorController {

    private static GpioPinDigitalOutput frontRightMotorForwardPin;
    private static GpioPinDigitalOutput backLeftMotorForwardPin;
    private static GpioPinDigitalOutput frontRightMotorBackwardPin;
    private static GpioPinDigitalOutput backLeftMotorBackwardPin;

    public static void initialize() {
        System.out.println("Configuring motor pins");
        final GpioController gpioController = GpioFactory.getInstance();

        frontRightMotorForwardPin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_23);
        frontRightMotorBackwardPin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_14);

        backLeftMotorForwardPin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_24); //Chosen because gpio 22 seems to be default high
        backLeftMotorBackwardPin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_25);

        System.out.println("Setting initial motor pin values");
        stop();
        System.out.println("DC motors initialized");
    }
    
    public static void test() {
        frontRightMotorForwardPin.setState(true);
        System.out.println("Setting pin " + frontRightMotorForwardPin.getPin().getAddress() + " to " + true);
        frontRightMotorBackwardPin.setState(true);
        System.out.println("Setting pin " + frontRightMotorBackwardPin.getPin().getAddress() + " to " + true);
        backLeftMotorBackwardPin.setState(true);
        System.out.println("Setting pin " + backLeftMotorBackwardPin.getPin().getAddress() + " to " + true);
        backLeftMotorForwardPin.setState(true);
        System.out.println("Setting pin " + backLeftMotorForwardPin.getPin().getAddress() + " to " + true);
    }
    
    public static void driveForward() {
        System.out.println("Driving forward");
        setFrontRightMotorForward();
        setBackLeftMotorForward();
    }

    public static void driveBackward() {
        System.out.println("Driving backward");
        setFrontRightMotorBackward();
        setBackLeftMotorBackward();
    }

    public static void turnLeft() {
        System.out.println("Turning left");
        setFrontRightMotorForward();
        setBackLeftMotorBackward();
    }

    public static void turnRight() {
        System.out.println("Turning right");
        setFrontRightMotorBackward();
        setBackLeftMotorForward();
    }

    public static void stop() {
        System.out.println("Stopping");
        setFrontRightMotorStop();
        setBackLeftMotorStop();
    }

    private static void setFrontRightMotorForward() {
        System.out.println("Setting pin " + frontRightMotorForwardPin.getPin().getAddress() + " to " + true);
        frontRightMotorForwardPin.setState(true);
        System.out.println("Setting pin " + frontRightMotorBackwardPin.getPin().getAddress() + " to " + false);
        frontRightMotorBackwardPin.setState(false);
    }

    private static void setFrontRightMotorBackward() {
        System.out.println("Setting pin " + frontRightMotorForwardPin.getPin().getAddress() + " to " + false);
        frontRightMotorForwardPin.setState(false);
        System.out.println("Setting pin " + frontRightMotorBackwardPin.getPin().getAddress() + " to " + true);
        frontRightMotorBackwardPin.setState(true);
    }

    private static void setBackLeftMotorForward() {
        System.out.println("Setting pin " + backLeftMotorForwardPin.getPin().getAddress() + " to " + true);
        backLeftMotorForwardPin.setState(true);
        System.out.println("Setting pin " + backLeftMotorBackwardPin.getPin().getAddress() + " to " + false);
        backLeftMotorBackwardPin.setState(false);
    }

    private static void setBackLeftMotorBackward() {
        System.out.println("Setting pin " + backLeftMotorForwardPin.getPin().getAddress() + " to " + false);
        backLeftMotorForwardPin.setState(false);
        System.out.println("Setting pin " + backLeftMotorBackwardPin.getPin().getAddress() + " to " + true);
        backLeftMotorBackwardPin.setState(true);
    }

    private static void setFrontRightMotorStop() {
        System.out.println("Setting pin " + frontRightMotorForwardPin.getPin().getAddress() + " to " + false);
        frontRightMotorForwardPin.setState(false);
        System.out.println("Setting pin " + frontRightMotorBackwardPin.getPin().getAddress() + " to " + false);
        frontRightMotorBackwardPin.setState(false);
    }

    private static void setBackLeftMotorStop() {
        System.out.println("Setting pin " + backLeftMotorForwardPin.getPin().getAddress() + " to " + false);
        backLeftMotorForwardPin.setState(false);
        System.out.println("Setting pin " + backLeftMotorBackwardPin.getPin().getAddress() + " to " + false);
        backLeftMotorBackwardPin.setState(false);
    }
}
