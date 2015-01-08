/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.common;

import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author uli
 */
public class MathematicsTest {

    public MathematicsTest() {
    }

    /**
     * Test of abs method, of class Mathematics.
     */
    @Test
    public void testAbs() {
        System.out.println("abs");
        double value = -12;
        double expResult = 12;
        double result = Mathematics.abs(value);
        System.out.println("value: " + value + " expResult: " + expResult + " result: " + result);
        assertTrue(result == expResult);

        value = 12;
        expResult = 12;
        result = Mathematics.abs(value);
        System.out.println("value: " + value + " expResult: " + expResult + " result: " + result);
        assertTrue(result == expResult);
    }

    /**
     * Test of nextPos method, of class Mathematics.
     */
    @Test
    public void testNextPos() {
        System.out.println("nextPos");
        short pos = 255;
        short length = 256;
        short expResult = 0;
        short result = Mathematics.nextPos(pos, length);
        System.out.println("pos: " + pos + " length: " + length + " expResult: " + expResult + " result: " + result);
        assertEquals(expResult, result);

        pos = 3;
        length = 256;
        expResult = 4;
        result = Mathematics.nextPos(pos, length);
        assertEquals(expResult, result);
    }

    /**
     * Test of prevPos method, of class Mathematics.
     */
    @Test
    public void testPrevPos() {
        System.out.println("prevPos");
        short pos = 0;
        short length = 256;
        short expResult = 255;
        short result = Mathematics.prevPos(pos, length);
        System.out.println("pos: " + pos + " length: " + length + " expResult: " + expResult + " result: " + result);
        assertEquals(expResult, result);

        pos = 15;
        length = 256;
        expResult = 14;
        result = Mathematics.prevPos(pos, length);
        assertEquals(expResult, result);
    }

    /**
     * Test of substractFromPos method, of class Mathematics.
     */
    @Test
    public void testSubstractFromPos() {
        System.out.println("substractFromPos");
        short pos = 12;
        short length = 256;
        short sub = 13;
        short expResult = 255;
        short result = Mathematics.substractFromPos(pos, length, sub);
        System.out.println("pos: " + pos + " length: " + length + " sub: " + sub + " expResult: " + expResult + " result: " + result);
        assertEquals(expResult, result);

        pos = 0;
        length = 256;
        sub = 1;
        expResult = 255;
        result = Mathematics.substractFromPos(pos, length, sub);
        System.out.println("pos: " + pos + " length: " + length + " sub: " + sub + " expResult: " + expResult + " result: " + result);
        assertEquals(expResult, result);

        pos = 1;
        length = 256;
        sub = 1;
        expResult = 0;
        result = Mathematics.substractFromPos(pos, length, sub);
        System.out.println("pos: " + pos + " length: " + length + " sub: " + sub + " expResult: " + expResult + " result: " + result);
        assertEquals(expResult, result);

        pos = 12;
        length = 256;
        sub = 5;
        expResult = 7;
        result = Mathematics.substractFromPos(pos, length, sub);
        System.out.println("pos: " + pos + " length: " + length + " sub: " + sub + " expResult: " + expResult + " result: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of movingAverage method, of class Mathematics.
     */
    @Test
    public void testMovingAverage() {
        double[] values = new double[]{12, 17, 15, -13, 22, 55, 3, 16, 43, 81};
        short pos = 3;

        double movingAverage = Mathematics.movingAverage(values, pos, (byte) 5);
        System.out.println("Moving average is: " + movingAverage);
        Printer.printBufferArray(pos, values, "Moving average applied to test data: ");
        assertTrue(movingAverage == 22.4);

        values = new double[]{12, 17, 15, -13, 22, 55, 3, 16, 43, 81};
        pos = 3;

        movingAverage = Mathematics.movingAverage(values, pos, (byte) 1);
        System.out.println("Moving average is: " + movingAverage);
        Printer.printBufferArray(pos, values, "Moving average applied to test data: ");
        assertTrue(movingAverage == -13);
    }

    @Test
    public void testApplyThreshold() {
        double value = 199;
        double threshold = 200;
        double expResult = 0;
        double result = Mathematics.applyThreshold(value, threshold);
        System.out.println("value " + value + " threshold " + threshold + " expResult " + expResult + " result " + result);
        assertTrue(expResult == result);
    }

    @Test
    public void testSkewSymmetricCrossProductMatrix3() {

        double[] vector = {1.3, 7.456, 3.2515};
        double[][] controlMatrix = new double[3][3];

        controlMatrix[0][0] = 0;
        controlMatrix[1][0] = 3.2515;
        controlMatrix[2][0] = -7.456;
        controlMatrix[0][1] = -3.2515;
        controlMatrix[1][1] = 0;
        controlMatrix[2][1] = 1.3;
        controlMatrix[0][2] = 7.456;
        controlMatrix[1][2] = -1.3;
        controlMatrix[2][2] = 0;

        double[][] result = Mathematics.skewSymmetriCrossProductMatrix3(vector);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(controlMatrix[i][j] == result[i][j]);
            }
        }

        System.out.println("The skew-symmetric cross-product matrix is: "
                + Arrays.toString(result[0]) + ","
                + Arrays.toString(result[1]) + ","
                + Arrays.toString(result[2]));
    }

    @Test
    public void testCrossProduct3() {
        double[] a = {1, 2, 3};
        double[] b = {-7, 8, 9};
        double[] control = {-6, -30, 22};

        double[] result = Mathematics.crossProduct3(a, b);

        for (int i = 0; i < 3; i++) {
            assertTrue(control[i] == result[i]);
        }

        System.out.println("The cross-product is: " + Arrays.toString(result));
    }

    @Test
    public void testDotProduct3() {
        double[] a = {1, 2, 3};
        double[] b = {-7, 8, 9};
        double control = 36;

        double result = Mathematics.dotProduct3(a, b);

        assertTrue(control == result);

        System.out.println("The dot-product is: " + result);
    }

    @Test
    public void testLength3() {
        double[] a = {1, 2, 2};
        double control = 3;

        double result = Mathematics.length3(a);

        assertTrue(control == result);

        System.out.println("The length is: " + result);
    }

    @Test
    public void testNormalize3() {
        double[] a = {1, 2, 2};
        double[] control = {0.3333, 0.6666, 0.6666};

        double[] result = Mathematics.normalize3(a);

        for (int i = 0; i < 3; i++) {
            assertTrue((result[i] - control[i]) < 0.0001);
        }

        System.out.println("The normalized vector is: " + Arrays.toString(result));

    }

    @Test
    public void testMultiplyVector3() {
        //[[1 2 3];[3 6 -7];[12 24 -3]]* [3 2 1]' 
        double[] a = {3, 2, 1};
        double[][] matrix = {
            {1, 2, 3},
            {3, 6, -7},
            {12, 24, -3}};
        double[] control = {10, 14, 81};

        double[] result = Mathematics.multiplyVector3(a, matrix);

        for (int i = 0; i < 3; i++) {
            assertTrue(result[i] == control[i]);
        }

        System.out.println("The multiplied vector is: " + Arrays.toString(result));

    }

    @Test
    public void testAddMatrics3() {
        double[][] a = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}};
        double[][] b = {
            {7, 8, 9},
            {4, 5, 6},
            {1, 2, 3}};
        double[][] control = {
            {8, 10, 12},
            {8, 10, 12},
            {8, 10, 12}};

        double[][] result = Mathematics.addMatrices3(a, b);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(result[i][j] == control[i][j]);
            }
        }

        System.out.println("The added matrix is: "
                + Arrays.toString(result[0]) + ","
                + Arrays.toString(result[1]) + ","
                + Arrays.toString(result[2]));
    }

    @Test
    public void testMultiplyMatrics3() {
        double[][] a = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}};
        double[][] b = {
            {7, 8, 9},
            {4, 5, 6},
            {1, 2, 3}};
        double[][] control = {
            {18, 24, 30},
            {54, 69, 84},
            {90, 114, 138}};

        double[][] result = Mathematics.multiplyMatrices3(a, b);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(result[i][j] == control[i][j]);
            }
        }

        System.out.println("The multiplied matrix is: "
                + Arrays.toString(result[0]) + ","
                + Arrays.toString(result[1]) + ","
                + Arrays.toString(result[2]));
    }

    @Test
    public void testDivideMatrics3() {
        double[][] a = {
            {2, 4, 6},
            {8, 10, 12},
            {14, 16, 18}};
        double divider = 2;
        double[][] control = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}};

        double[][] result = Mathematics.divideMatrix3(a, divider);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(result[i][j] == control[i][j]);
            }
        }

        System.out.println("The divided matrix is: "
                + Arrays.toString(result[0]) + ","
                + Arrays.toString(result[1]) + ","
                + Arrays.toString(result[2]));
    }

    @Test
    public void testMultiplyMatrix3() {
        double[][] control = {
            {2, 4, 6},
            {8, 10, 12},
            {14, 16, 18}};
        double factor = 2;
        double[][] a = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}};

        double[][] result = Mathematics.multiplyMatrix3(a, factor);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(result[i][j] == control[i][j]);
            }
        }

        System.out.println("The multiplied matrix is: "
                + Arrays.toString(result[0]) + ","
                + Arrays.toString(result[1]) + ","
                + Arrays.toString(result[2]));
    }

    @Test
    public void testRotationMatrix3() {
        double[] a = {1, 0, 0};
        double[] b = {5, 2, 1};
        double[][] control = {
            {0.912871, -0.365148, -0.182574},
            {0.365148, 0.930297, -0.034852},
            {0.182574, -0.034852, 0.982574}};

        double[][] result = Mathematics.rotationMatrix3(a, b);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                double diff = result[i][j] - control[i][j];
                assertTrue(0.0001 > diff && diff > -0.0001);
            }
        }

        System.out.println("The rotated matrix for 1,0,0 and 5,2,1 is: "
                + Arrays.toString(result[0]) + ","
                + Arrays.toString(result[1]) + ","
                + Arrays.toString(result[2]));
    }

}
