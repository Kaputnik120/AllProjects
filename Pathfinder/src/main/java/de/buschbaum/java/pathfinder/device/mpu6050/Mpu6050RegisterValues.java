/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.device.mpu6050;

/**
 *
 * @author uli
 */
public class Mpu6050RegisterValues {

    /**
     * Just wakes the device up, because it sets the sleep bit to 0. Also sets
     * the clock source to internal.
     */
    public static final byte MPU6050_RA_PWR_MGMT_1 = 0b00000000;
    /**
     * Sets the full scale range of the gyroscopes to ± 2000 °/s
     */
    public static final byte MPU6050_RA_GYRO_CONFIG = 0b00011000;
    /**
     * Sets the smaple rate divider for the gyroscopes and accelerometers. This
     * means<br> acc-rate = 1kHz / 1+ sample-rate<br> and <br>gyro-rate = 8kHz /
     * 1+ sample-rate. <br> <br> The concrete value 0 leaves the sample rate on
     * default, which means 1kHz for acc-rate and 8kHz for gyr-rate.
     */
    public static final byte MPU6050_RA_SMPLRT_DIV = 0b00000000;
    /**
     * Setting the digital low pass filter to <br>
     * Acc Bandwidth (Hz) = 184 <br>
     * Acc Delay (ms) = 2.0 <br>
     * Gyro Bandwidth (Hz) = 188 <br>
     * Gyro Delay (ms) = 1.9 <br>
     * Fs (kHz) = 1
     *
     */
    public static final byte MPU6050_RA_CONFIG = 0b00000101;
    /**
     * Setting accelerometer sensitivity to ± 16g
     */
    public static final byte MPU6050_RA_ACCEL_CONFIG = 0b00001000;
    /**
     * Disabling FIFO buffer
     */
    public static final byte MPU6050_RA_FIFO_EN = 0b00000000;
    /**
     * Disabling interrupts
     */
    public static final byte MPU6050_RA_INT_ENABLE = 0b00000000;
    /**
     * Disabling standby modes
     */
    public static final byte MPU6050_RA_PWR_MGMT_2 = 0b00000000;

}
