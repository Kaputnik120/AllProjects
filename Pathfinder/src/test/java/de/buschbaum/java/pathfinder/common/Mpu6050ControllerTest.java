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
        short shiftBytesTogether = Mpu6050Controller.shiftBytesTogether(lowByte, highByte);
        System.out.println("Shifted: " + Printer.formatBinary(shiftBytesTogether));
        short compare = (short) 0b1111000000001111;
        System.out.println("Control: " + Printer.formatBinary(compare));
        assertTrue(shiftBytesTogether == compare);
    }

    @Test
    public void testApplyLsb() {
        //2059(0000100000001011)       
        //This is 100000001011 as a two-complement value, which is
        //-2037, when lsb = 12!!

        short data = 0b0000100000001011; // = 2059, with lsb=12 it's -2037
        System.out.println("data: " + Printer.formatBinary(data));
        byte lsb = 12;
        int result = Mpu6050Controller.applyLeastSignificantBit(data, lsb);
        System.out.println("result: " + Printer.formatBinary((short) result));
        assertTrue(result == -2037);
    }

}
