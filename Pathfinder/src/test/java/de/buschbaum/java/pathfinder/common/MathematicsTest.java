/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.common;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author uli
 */
public class MathematicsTest {

    public MathematicsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of abs method, of class Mathematics.
     */
    @Test
    public void testAbs() {
        System.out.println("abs");
        short value = -12;
        short expResult = 12;
        short result = Mathematics.abs(value);
        System.out.println("value: " + value + " expResult: " + expResult + " result: " + result);
        assertEquals(expResult, result);

        value = 12;
        expResult = 12;
        result = Mathematics.abs(value);
        assertEquals(expResult, result);
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
        short[] values = new short[]{12, 17, 15, -13, 22, 55, 3, 16, 43, 81};
        byte weight = 8;
        short pos = 3;

        short movingAverage = Mathematics.movingAverage(values, pos, weight, (byte) 5);
        System.out.println("Moving average is: " + movingAverage);
        Printer.printBufferArray(pos, values, "Moving average applied to test data: ");
        assertTrue(movingAverage == 4);
    }

}
