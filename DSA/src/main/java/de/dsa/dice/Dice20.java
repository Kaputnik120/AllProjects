/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dsa.dice;

/**
 *
 * @author Uli
 */
public class Dice20 implements Dice{

    public short role() {
        short result = (short) Math.rint(Math.random()*20);
        if (result == 0) result = 1;
        return result;
    }
    
}
