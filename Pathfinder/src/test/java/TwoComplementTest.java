/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import de.buschbaum.java.pathfinder.Helper;
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
public class TwoComplementTest {

    public TwoComplementTest() {
    }

    @Test
    public void testTwoComplement() {

        byte b = (byte) 0b10101001;
        System.out.println(""+b);
        System.out.println(Byte.toString(b));
        System.out.println(Integer.highestOneBit(b));
        System.out.println(Integer.lowestOneBit(b));
        

    }
}
