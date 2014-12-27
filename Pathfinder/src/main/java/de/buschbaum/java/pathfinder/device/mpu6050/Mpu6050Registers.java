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
public class Mpu6050Registers {

    /**
     * 8-bit unsigned value. The Sample Rate is determined by dividing the
     * gyroscope output rate by this value.
     */
    public static final byte MPU6050_RA_SMPLRT_DIV = 25;
    /**
     * Bit 7 and bit 6 are reserved. Parameters: EXT_SYNC_SET 3-bit unsigned
     * value. Configures the FSYNC pin sampling. DLPF_CFG 3-bit unsigned value.
     * Configures the DLPF setting.
     */
    public static final byte MPU6050_RA_CONFIG = 26;
    /**
     * Bits 2 through 0 are reserved. Parameters: XG_ST Setting this bit causes
     * the X axis gyroscope to perform self test. YG_ST Setting this bit causes
     * the Y axis gyroscope to perform self test. ZG_ST Setting this bit causes
     * the Z axis gyroscope to perform self test. FS_SEL 2-bit unsigned value.
     * Selects the full scale range of gyroscopes:0 ± 250 °/s, 1 ± 500 °/s, 2 ±
     * 1000 °/s, 3 ± 2000 °/s
     */
    public static final byte MPU6050_RA_GYRO_CONFIG = 27;
    /**
     * Parameters: XA_ST YA_ST ZA_ST AFS_SEL When set to 1, the X- Axis
     * accelerometer performs self test. When set to 1, the Y- Axis
     * accelerometer performs self test. When set to 1, the Z- Axis
     * accelerometer performs self test. 2-bit unsigned value. Selects the full
     * scale range of accelerometers: 0 ± 2g, 1 ± 4g, 2 ± 8g, 3 ± 16g
     */
    public static final byte MPU6050_RA_ACCEL_CONFIG = 28;
    /**
     * <strong>Order of bits from 7 to 0: TEMP_ XG_ YG_ ZG_ ACCEL SLV2 SLV1 SLV0
     * 23 35 FIFO_EN FIFO_EN FIFO_EN FIFO_EN _FIFO_EN _FIFO_EN _FIFO_EN
     * _FIFO_EN</strong>
     *
     * Parameters: TEMP_FIFO_EN When set to 1, this bit enables TEMP_OUT_H and
     * TEMP_OUT_L (Registers 65 and 66) to be written into the FIFO buffer. XG_
     * FIFO_EN When set to 1, this bit enables GYRO_XOUT_H and GYRO_XOUT_L
     * (Registers 67 and 68) to be written into the FIFO buffer. YG_ FIFO_EN
     * When set to 1, this bit enables GYRO_YOUT_H and GYRO_YOUT_L (Registers 69
     * and 70) to be written into the FIFO buffer. ZG_ FIFO_EN When set to 1,
     * this bit enables GYRO_ZOUT_H and GYRO_ZOUT_L (Registers 71 and 72) to be
     * written into the FIFO buffer. ACCEL_ FIFO_EN When set to 1, this bit
     * enables ACCEL_XOUT_H, ACCEL_XOUT_L, ACCEL_YOUT_H, ACCEL_YOUT_L,
     * ACCEL_ZOUT_H, and ACCEL_ZOUT_L (Registers 59 to 64) to be written into
     * the FIFO buffer. SLV2_SLV1_SLV0_FIFO_EN FIFO_EN FIFO_EN When set to 1,
     * this bit enables EXT_SENS_DATA registers (Registers 73 to 96) associated
     * with Slave 2 to be written into the FIFO buffer. When set to 1, this bit
     * enables EXT_SENS_DATA registers (Registers 73 to 96) associated with
     * Slave 1 to be written into the FIFO buffer. When set to 1, this bit
     * enables EXT_SENS_DATA registers (Registers 73 to 96) associated with
     * Slave 0 to be written into the FIFO buffer.
     *
     */
    public static final byte MPU6050_RA_FIFO_EN = 35;
    /**
     * Bits 2 and 1 are reserved. Parameters: FIFO_OFLOW_EN I2C_MST_INT_EN
     * DATA_RDY_EN When set to 1, this bit enables a FIFO buffer overflow to
     * generate an interrupt. 2 When set to 1, this bit enables any of the I C
     * Master interrupt sources to generate an interrupt. When set to 1, this
     * bit enables the Data Ready interrupt, which occurs each time a write
     * operation to all of the sensor registers has been completed.
     */
    public static final byte MPU6050_RA_INT_ENABLE = 56;
    /**
     * 16-bit 2’s complement value. Stores the most recent X axis accelerometer
     * measurement.
     */
    public static final byte MPU6050_RA_ACCEL_XOUT_H = 59;
    /**
     * 16-bit 2’s complement value. Stores the most recent X axis accelerometer
     * measurement.
     */
    public static final byte MPU6050_RA_ACCEL_XOUT_L = 60;
    /**
     * 16-bit 2’s complement value. Stores the most recent Y axis accelerometer
     * measurement.
     */
    public static final byte MPU6050_RA_ACCEL_YOUT_H = 61;
    /**
     * 16-bit 2’s complement value. Stores the most recent Y axis accelerometer
     * measurement.
     */
    public static final byte MPU6050_RA_ACCEL_YOUT_L = 62;
    /**
     * 16-bit 2’s complement value. Stores the most recent Z axis accelerometer
     * measurement.
     */
    public static final byte MPU6050_RA_ACCEL_ZOUT_H = 63;
    /**
     * 16-bit 2’s complement value. Stores the most recent Z axis accelerometer
     * measurement.
     */
    public static final byte MPU6050_RA_ACCEL_ZOUT_L = 64;
    /**
     * 16-bit signed value. Stores the most recent temperature sensor
     * measurement.
     */
    public static final byte MPU6050_RA_TEMP_OUT_H = 65;
    /**
     * 16-bit signed value. Stores the most recent temperature sensor
     * measurement.
     */
    public static final byte MPU6050_RA_TEMP_OUT_L = 66;
    /**
     * 16-bit 2’s complement value. Stores the most recent X axis gyroscope
     * measurement.
     */
    public static final byte MPU6050_RA_GYRO_XOUT_H = 67;
    /**
     * 16-bit 2’s complement value. Stores the most recent X axis gyroscope
     * measurement.
     */
    public static final byte MPU6050_RA_GYRO_XOUT_L = 68;
    /**
     * 16-bit 2’s complement value. Stores the most recent Y axis gyroscope
     * measurement.
     */
    public static final byte MPU6050_RA_GYRO_YOUT_H = 69;
    /**
     * 16-bit 2’s complement value. Stores the most recent Y axis gyroscope
     * measurement.
     */
    public static final byte MPU6050_RA_GYRO_YOUT_L = 70;
    /**
     * 16-bit 2’s complement value. Stores the most recent Z axis gyroscope
     * measurement.
     */
    public static final byte MPU6050_RA_GYRO_ZOUT_H = 71;
    /**
     * 16-bit 2’s complement value. Stores the most recent Z axis gyroscope
     * measurement.
     */
    public static final byte MPU6050_RA_GYRO_ZOUT_L = 72;
    /**
     * Bits 7 to 3 are reserved. Parameters: GYRO_RESET When set to 1, this bit
     * resets the gyroscope analog and digital signal paths. ACCEL_RESET When
     * set to 1, this bit resets the accelerometer analog and digital signal
     * paths. TEMP_RESET When set to 1, this bit resets the temperature sensor
     * analog and digital signal paths.
     *
     */
    public static final byte MPU6050_RA_SIGNAL_PATH_RESET = 104;
    /**
     * Bit 4 is reserved. Parameters: DEVICE_RESET SLEEP CYCLE TEMP_DIS CLKSEL
     * When set to 1, this bit resets all internal registers to their default
     * values. The bit automatically clears to 0 once the reset is done. The
     * default values for each register can be found in Section 3. When set to
     * 1, this bit puts the MPU-60X0 into sleep mode. When this bit is set to 1
     * and SLEEP is disabled, the MPU-60X0 will cycle between sleep mode and
     * waking up to take a single sample of data from active sensors at a rate
     * determined by LP_WAKE_CTRL (register 108). When set to 1, this bit
     * disables the temperature sensor. 3-bit unsigned value. Specifies the
     * clock source of the device.
     */
    public static final byte MPU6050_RA_PWR_MGMT_1 = 107;
    /**
     * Bits 0 and 7 are reserved. (Hard coded to 0) Parameters: 2 WHO_AM_I
     * Contains the 6-bit I C address of the MPU-60X0. The Power-On-Reset value
     * of Bit6:Bit1 is 110 100.
     */
    public static final byte MPU6050_RA_WHO_AM_I = 117;
    /**
     * Parameters: LP_WAKE_CTRL 2-bit unsigned value. Specifies the frequency of
     * wake-ups during Accelerometer Only Low Power Mode. STBY_XA When set to 1,
     * this bit puts the X axis accelerometer into standby mode. STBY_YA When
     * set to 1, this bit puts the Y axis accelerometer into standby mode.
     * STBY_ZA When set to 1, this bit puts the Z axis accelerometer into
     * standby mode. STBY_XG When set to 1, this bit puts the X axis gyroscope
     * into standby mode. STBY_YG When set to 1, this bit puts the Y axis
     * gyroscope into standby mode. STBY_ZG When set to 1, this bit puts the Z
     * axis gyroscope into standby mode.
     */
    public static final byte MPU6050_RA_PWR_MGMT_2 = 108;

//    public static final byte MPU6050_RA_XG_OFFS_TC = 0x00;
//    public static final byte MPU6050_RA_YG_OFFS_TC = 0x01;
//    public static final byte MPU6050_RA_ZG_OFFS_TC = 0x02;
//    public static final byte MPU6050_RA_X_FINE_GAIN = 0x03;
//    public static final byte MPU6050_RA_Y_FINE_GAIN = 0x04;
//    public static final byte MPU6050_RA_Z_FINE_GAIN = 0x05;
//    public static final byte MPU6050_RA_XA_OFFS_H = 0x06;
//    public static final byte MPU6050_RA_XA_OFFS_L_TC = 0x07;
//    public static final byte MPU6050_RA_YA_OFFS_H = 0x08;
//    public static final byte MPU6050_RA_YA_OFFS_L_TC = 0x09;
//    public static final byte MPU6050_RA_ZA_OFFS_H = 0x0A;
//    public static final byte MPU6050_RA_ZA_OFFS_L_TC = 0x0B;
//    public static final byte MPU6050_RA_XG_OFFS_USRH = 0x13;
//    public static final byte MPU6050_RA_XG_OFFS_USRL = 0x14;
//    public static final byte MPU6050_RA_YG_OFFS_USRH = 0x15;
//    public static final byte MPU6050_RA_YG_OFFS_USRL = 0x16;
//    public static final byte MPU6050_RA_ZG_OFFS_USRH = 0x17;
//    public static final byte MPU6050_RA_ZG_OFFS_USRL = 0x18;
//    public static final byte MPU6050_RA_FF_THR = 0x1D;
//    public static final byte MPU6050_RA_FF_DUR = 0x1E;
//    public static final byte MPU6050_RA_MOT_THR = 0x1F;
//    public static final byte MPU6050_RA_MOT_DUR = 0x20;
//    public static final byte MPU6050_RA_ZRMOT_THR = 0x21;
//    public static final byte MPU6050_RA_ZRMOT_DUR = 0x22;
//    public static final byte MPU6050_RA_I2C_MST_CTRL = 0x24;
//    public static final byte MPU6050_RA_I2C_SLV0_ADDR = 0x25;
//    public static final byte MPU6050_RA_I2C_SLV0_REG = 0x26;
//    public static final byte MPU6050_RA_I2C_SLV0_CTRL = 0x27;
//    public static final byte MPU6050_RA_I2C_SLV1_ADDR = 0x28;
//    public static final byte MPU6050_RA_I2C_SLV1_REG = 0x29;
//    public static final byte MPU6050_RA_I2C_SLV1_CTRL = 0x2A;
//    public static final byte MPU6050_RA_I2C_SLV2_ADDR = 0x2B;
//    public static final byte MPU6050_RA_I2C_SLV2_REG = 0x2C;
//    public static final byte MPU6050_RA_I2C_SLV2_CTRL = 0x2D;
//    public static final byte MPU6050_RA_I2C_SLV3_ADDR = 0x2E;
//    public static final byte MPU6050_RA_I2C_SLV3_REG = 0x2F;
//    public static final byte MPU6050_RA_I2C_SLV3_CTRL = 0x30;
//    public static final byte MPU6050_RA_I2C_SLV4_ADDR = 0x31;
//    public static final byte MPU6050_RA_I2C_SLV4_REG = 0x32;
//    public static final byte MPU6050_RA_I2C_SLV4_DO = 0x33;
//    public static final byte MPU6050_RA_I2C_SLV4_CTRL = 0x34;
//    public static final byte MPU6050_RA_I2C_SLV4_DI = 0x35;
//    public static final byte MPU6050_RA_I2C_MST_STATUS = 0x36;
//    public static final byte MPU6050_RA_INT_PIN_CFG = 0x37;
//    public static final byte MPU6050_RA_DMP_INT_STATUS = 0x39;
//    public static final byte MPU6050_RA_INT_STATUS = 0x3A;
//    public static final byte MPU6050_RA_EXT_SENS_DATA_00 = 0x49;
//    public static final byte MPU6050_RA_EXT_SENS_DATA_01 = 0x4A;
//    public static final byte MPU6050_RA_EXT_SENS_DATA_02 = 0x4B;
//    public static final byte MPU6050_RA_EXT_SENS_DATA_03 = 0x4C;
//    public static final byte MPU6050_RA_EXT_SENS_DATA_04 = 0x4D;
//    public static final byte MPU6050_RA_EXT_SENS_DATA_05 = 0x4E;
//    public static final byte MPU6050_RA_EXT_SENS_DATA_06 = 0x4F;
//    public static final byte MPU6050_RA_EXT_SENS_DATA_07 = 0x50;
//    public static final byte MPU6050_RA_EXT_SENS_DATA_08 = 0x51;
//    public static final byte MPU6050_RA_EXT_SENS_DATA_09 = 0x52;
//    public static final byte MPU6050_RA_EXT_SENS_DATA_10 = 0x53;
//    public static final byte MPU6050_RA_EXT_SENS_DATA_11 = 0x54;
//    public static final byte MPU6050_RA_EXT_SENS_DATA_12 = 0x55;
//    public static final byte MPU6050_RA_EXT_SENS_DATA_13 = 0x56;
//    public static final byte MPU6050_RA_EXT_SENS_DATA_14 = 0x57;
//    public static final byte MPU6050_RA_EXT_SENS_DATA_15 = 0x58;
//    public static final byte MPU6050_RA_EXT_SENS_DATA_16 = 0x59;
//    public static final byte MPU6050_RA_EXT_SENS_DATA_17 = 0x5A;
//    public static final byte MPU6050_RA_EXT_SENS_DATA_18 = 0x5B;
//    public static final byte MPU6050_RA_EXT_SENS_DATA_19 = 0x5C;
//    public static final byte MPU6050_RA_EXT_SENS_DATA_20 = 0x5D;
//    public static final byte MPU6050_RA_EXT_SENS_DATA_21 = 0x5E;
//    public static final byte MPU6050_RA_EXT_SENS_DATA_22 = 0x5F;
//    public static final byte MPU6050_RA_EXT_SENS_DATA_23 = 0x60;
//    public static final byte MPU6050_RA_MOT_DETECT_STATUS = 0x61;
//    public static final byte MPU6050_RA_I2C_SLV0_DO = 0x63;
//    public static final byte MPU6050_RA_I2C_SLV1_DO = 0x64;
//    public static final byte MPU6050_RA_I2C_SLV2_DO = 0x65;
//    public static final byte MPU6050_RA_I2C_SLV3_DO = 0x66;
//    public static final byte MPU6050_RA_I2C_MST_DELAY_CTRL = 0x67;
//    public static final byte MPU6050_RA_MOT_DETECT_CTRL = 0x69;
//    public static final byte MPU6050_RA_USER_CTRL = 0x6A;
//    public static final byte MPU6050_RA_BANK_SEL = 0x6D;
//    public static final byte MPU6050_RA_MEM_START_ADDR = 0x6E;
//    public static final byte MPU6050_RA_MEM_R_W = 0x6F;
//    public static final byte MPU6050_RA_DMP_CFG_1 = 0x70;
//    public static final byte MPU6050_RA_DMP_CFG_2 = 0x71;
//    public static final byte MPU6050_RA_FIFO_COUNTH = 0x72;
//    public static final byte MPU6050_RA_FIFO_COUNTL = 0x73;
//    public static final byte MPU6050_RA_FIFO_R_W = 0x74;

}
