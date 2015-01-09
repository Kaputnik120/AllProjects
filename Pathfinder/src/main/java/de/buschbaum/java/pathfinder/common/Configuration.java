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
public class Configuration {

    /**
     * The size of one time slot in ms
     */
    public static final byte TIME_SLOT_LENGTH = 10;
    /**
     * The size of the buffer of the accelerator measurements
     */
    public static final short ACC_BUFFER_SIZE = 1000 / TIME_SLOT_LENGTH;
    /**
     * The divider for getting 1g out of the register values of the MPU6050 at a
     * full scale range of 8g
     */
    public static final short ACC_DIVIDER = 8192;
    /**
     * Formula for getting the actual g-value applied
     */
    public static final double ACC_RESOLUTION = (1.0 / ACC_DIVIDER) * (9.80665 * (TIME_SLOT_LENGTH / 1000.0));
    /**
     * The minimum speed to survive setting speed to 0 every second. Corrects
     * acceleration measurements.
     */
    public static final double MINIMUM_SPEED = 0.005;
    /**
     * Defines how many times the sensor values are read for calibration. The
     * first half of reads is used for calibrating the rotation matrix. The
     * second half of reads is used to calculate the noise of the signal.
     */
    public static final short CALIBRATION_COUNT = 500;
    /**
     * The time to wait after every read of all sensor values.
     */
    public static final byte CALIBRATION_TIME_SLOT = TIME_SLOT_LENGTH;
    /**
     * The aligned vector for the vehicle not moving and only 1g applied to the
     * z-axis.
     */
    public static final double[] CALIBRATION_VECTOR = {0, 0, ACC_DIVIDER};
    /**
     * The calculated rotation matrix to correct the misalignment of the MPU6050
     * with the vehicle
     */
    public static double[][] CALIBRATION_ROTATION_MATRIX = null;
    /**
     * The maximum absolute value which is handeled as noise
     */
    public static final double CALIBRATION_NOISE_THRESHOLD = 300;
}
