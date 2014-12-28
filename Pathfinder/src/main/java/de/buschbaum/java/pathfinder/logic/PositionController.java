/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.logic;

import de.buschbaum.java.pathfinder.common.Configuration;
import de.buschbaum.java.pathfinder.common.Mathematics;
import de.buschbaum.java.pathfinder.common.Printer;
import de.buschbaum.java.pathfinder.device.mpu6050.Mpu6050Controller;
import java.io.IOException;

/**
 *
 * @author uli
 */
public class PositionController {

    private static int[] position = new int[]{0, 0};

    private static final short[] accXNorm = new short[Configuration.ACC_BUFFER_SIZE];
    private static final short[] accXRaw = new short[Configuration.ACC_BUFFER_SIZE];

    private static short accXNormPos = 0;
    private static short accXRawPos = 0;

    private static int accXSum = 0;

    private static byte accXSpeed = 0;

    public static void initialize() throws Exception {
        System.out.println("Initializing Mpu6050");
        Mpu6050Controller.initialize();
        //TODO read self test values to adjust Mpu6050 data!
        System.out.println("Mpu6050 initialized!");
    }

    public static void update() throws IOException {
        position[0] = 0;
        position[1] = 0;
        updateAccX();
    }

    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public static int[] getPosition() {
        return position;
    }

    public static float getAngle() {
        return 0f;
    }

    private static void updateAccX() throws IOException {
        //RAW
        short accXRawValue = Mpu6050Controller.readAccXRegister();
        accXRawValue = adjustRawAccXValue(accXRawValue);
        System.out.println("accX raw = " + accXRawValue);
        accXRawPos = writeToBufferArray(accXRawPos, accXRaw, accXRawValue);

        //NORM
        accXRawValue = normalizeX(accXRaw, accXRawPos);
        System.out.println("accX normalized = " + accXRawValue);
        accXNormPos = writeToBufferArray(accXNormPos, accXNorm, accXRawValue);

        //SUM
        accXSum += accXRawValue;
        System.out.println("AccXSum = " + accXSum);

        //PRINT
        Printer.printBufferArray(accXNormPos, accXNorm, "AccXNorm buffer: ");
        Printer.printBufferArray(accXRawPos, accXRaw, "AccXRaw buffer: ");
    }

    private static double getAcceleration(short rawAcc) {
        return rawAcc * Configuration.ACC_RESOLUTION;
    }

    @SuppressWarnings("AssignmentToMethodParameter")
    private static short writeToBufferArray(short pos, short[] buffer, short value) {
        //Write value
        buffer[pos] = value;

        //Increment pointer or reset
        pos = Mathematics.nextPos(pos, (short) buffer.length);

        return pos;
    }

    @SuppressWarnings("AssignmentToMethodParameter")
    private static short normalizeX(short[] accXRaw, short pos) {
        //Apply moving Average
        short value = Mathematics.movingAverage(accXRaw, pos, Configuration.MOVING_AVERAGE_WEIGHT, Configuration.MOVING_AVERAGE_SIZE);
        //Apply threshold
        value = applyThreshold(value, Configuration.ACC_THRESHOLD);
        return value;
    }

    private static short adjustRawAccXValue(short value) {
        //Apply correction value
        return (short) (value + Configuration.ACC_X_CORRECTION);
    }

    @SuppressWarnings("AssignmentToMethodParameter")
    private static short applyThreshold(short value, short threshold) {
        if (Mathematics.abs(value) < threshold) {
            value = (short) (value / 20);
        } else if (Mathematics.abs(value) < threshold * 2) {
            value = (short) (value / 10);
        }
        return value;
    }

}
