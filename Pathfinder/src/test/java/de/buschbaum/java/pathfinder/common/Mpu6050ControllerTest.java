/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.common;

import de.buschbaum.java.pathfinder.device.mpu6050.Mpu6050Controller;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author uli
 */
public class Mpu6050ControllerTest {

    public Mpu6050ControllerTest() {
    }

    @Test
    public void testByteShift() {
        byte lowByte = (byte) 0b00001111;
        byte highByte = (byte) 0b11110000;
        short shiftBytesTogether = Mathematics.shiftBytesTogether(lowByte, highByte);
        System.out.println("Shifted: " + Printer.formatBinary(shiftBytesTogether));
        short compare = (short) 0b1111000000001111;
        System.out.println("Control: " + Printer.formatBinary(compare));
        assertTrue(shiftBytesTogether == compare);
    }

}
