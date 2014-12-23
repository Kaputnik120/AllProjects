package de.buschbaum.java.pathfinder;

import de.buschbaum.java.pathfinder.mpu6050.Mpu6050Controller;
import de.buschbaum.java.pathfinder.mpu6050.Mpu6050Registers;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Initializing MPU6050");
        Mpu6050Controller.initialize();
        Thread.sleep(3000l);
        System.out.println("Reading MPU6050_RA_WHO_AM_I");
        System.out.println(Mpu6050Controller.readMpu6050Register(Mpu6050Registers.MPU6050_RA_WHO_AM_I));
        System.out.println("Reading MPU6050_RA_TEMP_OUT_H");
        System.out.println(Mpu6050Controller.readMpu6050Register(Mpu6050Registers.MPU6050_RA_TEMP_OUT_H));
        System.out.println("Reading MPU6050_RA_TEMP_OUT_L");
        System.out.println(Mpu6050Controller.readMpu6050Register(Mpu6050Registers.MPU6050_RA_TEMP_OUT_L));
        Thread.sleep(3000l);
        System.out.println("Trying to read Gyro values...");
        while (true) {
            Helper.printValueIfNotZero("MPU6050_RA_GYRO_XOUT_L", Mpu6050Controller.readMpu6050Register(Mpu6050Registers.MPU6050_RA_GYRO_XOUT_L));
            Helper.printValueIfNotZero("MPU6050_RA_GYRO_XOUT_H", Mpu6050Controller.readMpu6050Register(Mpu6050Registers.MPU6050_RA_GYRO_XOUT_H));
            Helper.printValueIfNotZero("MPU6050_RA_GYRO_YOUT_L", Mpu6050Controller.readMpu6050Register(Mpu6050Registers.MPU6050_RA_GYRO_YOUT_L));
            Helper.printValueIfNotZero("MPU6050_RA_GYRO_YOUT_H", Mpu6050Controller.readMpu6050Register(Mpu6050Registers.MPU6050_RA_GYRO_YOUT_H));
            Helper.printValueIfNotZero("MPU6050_RA_GYRO_ZOUT_L", Mpu6050Controller.readMpu6050Register(Mpu6050Registers.MPU6050_RA_GYRO_ZOUT_L));
            Helper.printValueIfNotZero("MPU6050_RA_GYRO_ZOUT_H", Mpu6050Controller.readMpu6050Register(Mpu6050Registers.MPU6050_RA_GYRO_ZOUT_H));
            Helper.printValue("MPU6050_RA_TEMP_OUT_L", Mpu6050Controller.readMpu6050Register(Mpu6050Registers.MPU6050_RA_TEMP_OUT_L));
            Helper.printValue("MPU6050_RA_TEMP_OUT_H", Mpu6050Controller.readMpu6050Register(Mpu6050Registers.MPU6050_RA_TEMP_OUT_H));
        }
    }
}
