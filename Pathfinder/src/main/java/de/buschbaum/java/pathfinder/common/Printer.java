/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.common;

/**
 *
 * @author uli
 */
public class Printer {

    public static void printValue(String name, byte value) {
        System.out.println(name + ":\t" + Integer.toBinaryString((int) value) + " (" + value + ")");
    }

    public static void printValueIfNotZero(String name, byte value) {
        if (value != 0) {
            System.out.println(name + ":\t" + Integer.toBinaryString((int) value) + " (" + value + ")");
        }
    }

    public static String formatBinary(byte b) {
        String binaryString = Integer.toBinaryString(b);
        if (binaryString.length() > 8) {
            binaryString = binaryString.substring(binaryString.length() - 8);
        }
        if (binaryString.length() < 8) {
            byte fillingZeros = (byte) (8 - binaryString.length());
            for (int j = 1; j <= fillingZeros; j++) {
                binaryString = "0" + binaryString;
            }
        }
        return binaryString;
    }

    public static String formatBinary(short b) {
        String binaryString = Integer.toBinaryString(b);
        if (binaryString.length() > 16) {
            binaryString = binaryString.substring(binaryString.length() - 16);
        }
        if (binaryString.length() < 16) {
            byte fillingZeros = (byte) (16 - binaryString.length());
            for (int j = 1; j <= fillingZeros; j++) {
                binaryString = "0" + binaryString;
            }
        }
        return binaryString;
    }

    public static void printBufferArray(short pos, double[] buffer, String description) {
        System.out.print(description + " (" + pos + ") " + " [");
        for (short i = 0; i < buffer.length; i++) {
            if (i == pos) {
                System.out.print("*");
            }
            if (i < buffer.length - 1) {
                System.out.print(buffer[i] + ",");
            } else {
                System.out.print(buffer[i] + "]");
            }
        }
        System.out.println();
    }
}
