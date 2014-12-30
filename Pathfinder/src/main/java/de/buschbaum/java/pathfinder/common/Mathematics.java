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
public class Mathematics {

    public static short abs(short value) {
        if (value < 0) {
            return (short) (value * ((short) -1));
        } else {
            return value;
        }
    }

    /**
     * Calculates the moving average and writes it at position pos. The value at
     * position pos is weighted with the full weight as a multiplicator. The
     * value pos-1 is weighted witch weight/2. All other values are weighted
     * with 1. Instead of the value of values[pos] the paramter value is used.
     * This allows manipulation of the value before calling movingAverage
     * without changing the actual array.
     *
     * @param values
     * @param pos
     * @param weight
     * @param size
     * @return
     */
    public static short movingAverage(short[] values, short pos, byte weight, byte size) {
        if (size > 1) {
            int sum = 0;
            short count = (short) ((short) size + ((short) (weight / 2 - 1)) + ((short) (weight - 1)));
            short prevPos = prevPos(pos, (short) values.length);

            //Loop backward through values until size is reached
            for (byte i = 0; i < size; i++) {
                short pointer = substractFromPos(pos, (short) values.length, i);
                //Apply weight
                if (pointer == pos) {
                    sum += values[pointer] * weight;
                } else if (pointer == prevPos) {
                    sum += values[pointer] * (weight / 2);
                } else {
                    sum += values[pointer];
                }
            }
            return (short) (sum / count);
        } else {
            return values[pos];
        }
    }

    @SuppressWarnings("AssignmentToMethodParameter")
    public static short nextPos(short pos, short length) {
        if (pos >= length - 1) {
            pos = 0;
        } else {
            pos++;
        }
        return pos;
    }

    @SuppressWarnings("AssignmentToMethodParameter")
    public static short prevPos(short pos, short length) {
        if (pos <= 0) {
            pos = (short) (length - 1);
        } else {
            pos--;
        }
        return pos;
    }

    @SuppressWarnings("AssignmentToMethodParameter")
    public static short substractFromPos(short pos, short length, short sub) {
        pos = (short) (pos - sub);
        if (pos < 0) {
            pos = (short) (length - abs(pos));
        }
        return pos;
    }

    /**
     * Applies to values lower than the threshold. Values lower than the
     * threshold are divided by 10 - the value's threshold decile.
     *
     * @param value
     * @param threshold
     * @return
     */
    @SuppressWarnings("AssignmentToMethodParameter")
    public static short applyThreshold(short value, short threshold) {
        if (value != 0 && Mathematics.abs(value) < threshold) {
            int decile = (int) (((float) Mathematics.abs(value) / (float) threshold) * 10);
            decile = Math.min(decile + 1, 10);
            value = (short) (value / Math.max((10 - decile) * (10 - decile), 1));
        }
        return value;
    }

}
