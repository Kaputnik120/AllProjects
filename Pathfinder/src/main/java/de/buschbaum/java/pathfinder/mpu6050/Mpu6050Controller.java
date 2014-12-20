/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.mpu6050;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import java.io.IOException;

/**
 *
 * @author uli
 */
public class Mpu6050Controller {

    private static I2CBus bus = null;
    private static I2CDevice mpu6050 = null;

    public static void initialize() throws IOException {
        initializeI2C();
        configureMpu6050();
    }

    private static void initializeI2C() throws IOException {
        System.out.println("Creating I2C bus");
        bus = I2CFactory.getInstance(I2CBus.BUS_1);
        System.out.println("Creating I2C device");
        mpu6050 = bus.getDevice(0x68);
    }

    private static void configureMpu6050() throws IOException {

        //Hex to Dec not working correctly
        //RegisterAndCheck method can't work this way as registers do not always reflect the set value
        //Check all defined registers as some are wrong and read documentation to determine which to be set.
        System.out.println("Setting sample rate to 8000/1+7 = 1000Hz");
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_SMPLRT_DIV, (byte) 0x07);
        System.out.println("Disable FSync, 256Hz DLPF");
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_CONFIG, (byte) 0x00);
        System.out.println("Disable gyro self tests, scale of 500 degrees/s");
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_GYRO_CONFIG, (byte) 0b00001000);
        System.out.println("Disable accel self tests, scale of +-2g, no DHPF");
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_ACCEL_CONFIG, (byte) 0x00);
        System.out.println("Freefall threshold of |0mg|");
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_FF_THR, (byte) 0x00);
        System.out.println("Freefall duration limit of 0");
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_FF_DUR, (byte) 0x00);
        System.out.println("Motion threshold of 0mg");
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_MOT_THR, (byte) 0x00);
        System.out.println("Motion duration of 0s");
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_MOT_DUR, (byte) 0x00);
        System.out.println("Zero motion threshold");
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_ZRMOT_THR, (byte) 0x00);
        System.out.println("Zero motion duration threshold");
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_ZRMOT_DUR, (byte) 0x00);
        System.out.println("Disable sensor output to FIFO buffer");
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_FIFO_EN, (byte) 0x00);

        System.out.println("AUX I2C setup");
        System.out.println("Sets AUX I2C to single master control, plus other config");
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_I2C_MST_CTRL, (byte) 0x00);
        System.out.println("Setup AUX I2C slaves");
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_I2C_SLV0_ADDR, (byte) 0x00);
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_I2C_SLV0_REG, (byte) 0x00);
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_I2C_SLV0_CTRL, (byte) 0x00);
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_I2C_SLV1_ADDR, (byte) 0x00);
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_I2C_SLV1_REG, (byte) 0x00);
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_I2C_SLV1_CTRL, (byte) 0x00);
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_I2C_SLV2_ADDR, (byte) 0x00);
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_I2C_SLV2_REG, (byte) 0x00);
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_I2C_SLV2_CTRL, (byte) 0x00);
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_I2C_SLV3_ADDR, (byte) 0x00);
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_I2C_SLV3_REG, (byte) 0x00);
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_I2C_SLV3_CTRL, (byte) 0x00);
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_I2C_SLV4_ADDR, (byte) 0x00);
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_I2C_SLV4_REG, (byte) 0x00);
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_I2C_SLV4_DO, (byte) 0x00);
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_I2C_SLV4_CTRL, (byte) 0x00);
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_I2C_SLV4_DI, (byte) 0x00);

        System.out.println("Setup INT pin and AUX I2C pass through");
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_INT_PIN_CFG, (byte) 0x00);
        System.out.println("Enable data ready interrupt");
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_INT_ENABLE, (byte) 0x00);
        System.out.println("Slave out, dont care");
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_I2C_SLV0_DO, (byte) 0x00);
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_I2C_SLV1_DO, (byte) 0x00);
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_I2C_SLV2_DO, (byte) 0x00);
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_I2C_SLV3_DO, (byte) 0x00);
        System.out.println("More slave config");
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_I2C_MST_DELAY_CTRL, (byte) 0x00);
        System.out.println("Reset sensor signal paths");
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_SIGNAL_PATH_RESET, (byte) 0x00);
        System.out.println("Motion detection control");
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_MOT_DETECT_CTRL, (byte) 0x00);
        System.out.println("Disables FIFO, AUX I2C, FIFO and I2C reset bits to 0");
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_USER_CTRL, (byte) 0x00);
        System.out.println("Sets clock source to gyro reference w/ PLL");
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_PWR_MGMT_1, (byte) 0b00000010);
        System.out.println("Controls frequency of wakeups in accel low power mode plus the sensor standby modes");
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_PWR_MGMT_2, (byte) 0x00);
        System.out.println("Data transfer to and from the FIFO buffer");
        writeMpu6050RegisterAndCheck(Mpu6050Registers.MPU6050_RA_FIFO_R_W, (byte) 0x00);
    }

    private static void writeMpu6050RegisterAndCheck(byte register, byte data) throws IOException {
        mpu6050.write(register);
        mpu6050.write(data);
//        mpu6050.write(register);
        int read = mpu6050.read();
        if (read != data) {
            throw new RuntimeException("Register " + register + " value " + data + " not set correctly. Value is " + read);
        }
    }

    public static int readMpu6050Register(byte register) throws IOException {
        mpu6050.write(register);
        return mpu6050.read();
    }
}
