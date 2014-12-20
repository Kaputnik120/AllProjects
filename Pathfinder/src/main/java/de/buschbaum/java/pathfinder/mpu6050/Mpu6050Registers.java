/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.mpu6050;

/**
 *
 * @author uli
 */
public class Mpu6050Registers {

    public static final byte MPU6050_RA_XG_OFFS_TC = 0x00;
    public static final byte MPU6050_RA_YG_OFFS_TC = 0x01;
    public static final byte MPU6050_RA_ZG_OFFS_TC = 0x02;
    public static final byte MPU6050_RA_X_FINE_GAIN = 0x03;
    public static final byte MPU6050_RA_Y_FINE_GAIN = 0x04;
    public static final byte MPU6050_RA_Z_FINE_GAIN = 0x05;
    public static final byte MPU6050_RA_XA_OFFS_H = 0x06;
    public static final byte MPU6050_RA_XA_OFFS_L_TC = 0x07;
    public static final byte MPU6050_RA_YA_OFFS_H = 0x08;
    public static final byte MPU6050_RA_YA_OFFS_L_TC = 0x09;
    public static final byte MPU6050_RA_ZA_OFFS_H = 0x0A;
    public static final byte MPU6050_RA_ZA_OFFS_L_TC = 0x0B;
    public static final byte MPU6050_RA_XG_OFFS_USRH = 0x13;
    public static final byte MPU6050_RA_XG_OFFS_USRL = 0x14;
    public static final byte MPU6050_RA_YG_OFFS_USRH = 0x15;
    public static final byte MPU6050_RA_YG_OFFS_USRL = 0x16;
    public static final byte MPU6050_RA_ZG_OFFS_USRH = 0x17;
    public static final byte MPU6050_RA_ZG_OFFS_USRL = 0x18;
    public static final byte MPU6050_RA_SMPLRT_DIV = 27;
    public static final byte MPU6050_RA_CONFIG = 28;
    public static final byte MPU6050_RA_GYRO_CONFIG = 0x1B;
    public static final byte MPU6050_RA_ACCEL_CONFIG = 0x1C;
    public static final byte MPU6050_RA_FF_THR = 0x1D;
    public static final byte MPU6050_RA_FF_DUR = 0x1E;
    public static final byte MPU6050_RA_MOT_THR = 0x1F;
    public static final byte MPU6050_RA_MOT_DUR = 0x20;
    public static final byte MPU6050_RA_ZRMOT_THR = 0x21;
    public static final byte MPU6050_RA_ZRMOT_DUR = 0x22;
    public static final byte MPU6050_RA_FIFO_EN = 0x23;
    public static final byte MPU6050_RA_I2C_MST_CTRL = 0x24;
    public static final byte MPU6050_RA_I2C_SLV0_ADDR = 0x25;
    public static final byte MPU6050_RA_I2C_SLV0_REG = 0x26;
    public static final byte MPU6050_RA_I2C_SLV0_CTRL = 0x27;
    public static final byte MPU6050_RA_I2C_SLV1_ADDR = 0x28;
    public static final byte MPU6050_RA_I2C_SLV1_REG = 0x29;
    public static final byte MPU6050_RA_I2C_SLV1_CTRL = 0x2A;
    public static final byte MPU6050_RA_I2C_SLV2_ADDR = 0x2B;
    public static final byte MPU6050_RA_I2C_SLV2_REG = 0x2C;
    public static final byte MPU6050_RA_I2C_SLV2_CTRL = 0x2D;
    public static final byte MPU6050_RA_I2C_SLV3_ADDR = 0x2E;
    public static final byte MPU6050_RA_I2C_SLV3_REG = 0x2F;
    public static final byte MPU6050_RA_I2C_SLV3_CTRL = 0x30;
    public static final byte MPU6050_RA_I2C_SLV4_ADDR = 0x31;
    public static final byte MPU6050_RA_I2C_SLV4_REG = 0x32;
    public static final byte MPU6050_RA_I2C_SLV4_DO = 0x33;
    public static final byte MPU6050_RA_I2C_SLV4_CTRL = 0x34;
    public static final byte MPU6050_RA_I2C_SLV4_DI = 0x35;
    public static final byte MPU6050_RA_I2C_MST_STATUS = 0x36;
    public static final byte MPU6050_RA_INT_PIN_CFG = 0x37;
    public static final byte MPU6050_RA_INT_ENABLE = 0x38;
    public static final byte MPU6050_RA_DMP_INT_STATUS = 0x39;
    public static final byte MPU6050_RA_INT_STATUS = 0x3A;
    public static final byte MPU6050_RA_ACCEL_XOUT_H = 0x3B;
    public static final byte MPU6050_RA_ACCEL_XOUT_L = 0x3C;
    public static final byte MPU6050_RA_ACCEL_YOUT_H = 0x3D;
    public static final byte MPU6050_RA_ACCEL_YOUT_L = 0x3E;
    public static final byte MPU6050_RA_ACCEL_ZOUT_H = 0x3F;
    public static final byte MPU6050_RA_ACCEL_ZOUT_L = 0x40;
    public static final byte MPU6050_RA_TEMP_OUT_H = 0x41;
    public static final byte MPU6050_RA_TEMP_OUT_L = 0x42;
    public static final byte MPU6050_RA_GYRO_XOUT_H = 0x43;
    public static final byte MPU6050_RA_GYRO_XOUT_L = 0x44;
    public static final byte MPU6050_RA_GYRO_YOUT_H = 0x45;
    public static final byte MPU6050_RA_GYRO_YOUT_L = 0x46;
    public static final byte MPU6050_RA_GYRO_ZOUT_H = 0x47;
    public static final byte MPU6050_RA_GYRO_ZOUT_L = 0x48;
    ;
    public static final byte MPU6050_RA_EXT_SENS_DATA_00 = 0x49;
    public static final byte MPU6050_RA_EXT_SENS_DATA_01 = 0x4A;
    public static final byte MPU6050_RA_EXT_SENS_DATA_02 = 0x4B;
    public static final byte MPU6050_RA_EXT_SENS_DATA_03 = 0x4C;
    public static final byte MPU6050_RA_EXT_SENS_DATA_04 = 0x4D;
    public static final byte MPU6050_RA_EXT_SENS_DATA_05 = 0x4E;
    public static final byte MPU6050_RA_EXT_SENS_DATA_06 = 0x4F;
    public static final byte MPU6050_RA_EXT_SENS_DATA_07 = 0x50;
    public static final byte MPU6050_RA_EXT_SENS_DATA_08 = 0x51;
    public static final byte MPU6050_RA_EXT_SENS_DATA_09 = 0x52;
    public static final byte MPU6050_RA_EXT_SENS_DATA_10 = 0x53;
    public static final byte MPU6050_RA_EXT_SENS_DATA_11 = 0x54;
    public static final byte MPU6050_RA_EXT_SENS_DATA_12 = 0x55;
    public static final byte MPU6050_RA_EXT_SENS_DATA_13 = 0x56;
    public static final byte MPU6050_RA_EXT_SENS_DATA_14 = 0x57;
    public static final byte MPU6050_RA_EXT_SENS_DATA_15 = 0x58;
    public static final byte MPU6050_RA_EXT_SENS_DATA_16 = 0x59;
    public static final byte MPU6050_RA_EXT_SENS_DATA_17 = 0x5A;
    public static final byte MPU6050_RA_EXT_SENS_DATA_18 = 0x5B;
    public static final byte MPU6050_RA_EXT_SENS_DATA_19 = 0x5C;
    public static final byte MPU6050_RA_EXT_SENS_DATA_20 = 0x5D;
    public static final byte MPU6050_RA_EXT_SENS_DATA_21 = 0x5E;
    public static final byte MPU6050_RA_EXT_SENS_DATA_22 = 0x5F;
    public static final byte MPU6050_RA_EXT_SENS_DATA_23 = 0x60;
    public static final byte MPU6050_RA_MOT_DETECT_STATUS = 0x61;
    public static final byte MPU6050_RA_I2C_SLV0_DO = 0x63;
    public static final byte MPU6050_RA_I2C_SLV1_DO = 0x64;
    public static final byte MPU6050_RA_I2C_SLV2_DO = 0x65;
    public static final byte MPU6050_RA_I2C_SLV3_DO = 0x66;
    public static final byte MPU6050_RA_I2C_MST_DELAY_CTRL = 0x67;
    public static final byte MPU6050_RA_SIGNAL_PATH_RESET = 0x68;
    public static final byte MPU6050_RA_MOT_DETECT_CTRL = 0x69;
    public static final byte MPU6050_RA_USER_CTRL = 0x6A;
    public static final byte MPU6050_RA_PWR_MGMT_1 = 0x6B;
    public static final byte MPU6050_RA_PWR_MGMT_2 = 0x6C;
    public static final byte MPU6050_RA_BANK_SEL = 0x6D;
    public static final byte MPU6050_RA_MEM_START_ADDR = 0x6E;
    public static final byte MPU6050_RA_MEM_R_W = 0x6F;
    public static final byte MPU6050_RA_DMP_CFG_1 = 0x70;
    public static final byte MPU6050_RA_DMP_CFG_2 = 0x71;
    public static final byte MPU6050_RA_FIFO_COUNTH = 0x72;
    public static final byte MPU6050_RA_FIFO_COUNTL = 0x73;
    public static final byte MPU6050_RA_FIFO_R_W = 0x74;
    public static final byte MPU6050_RA_WHO_AM_I = 0x75;
}
