/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dsa.fighter;

import de.dsa.dice.Dice;
import de.dsa.dice.Dice20;
import de.dsa.dice.Dice6;

/**
 *
 * @author Uli
 */
public class Hero extends Fighter {
    
    @Override
    public boolean isGood () {
        return true;
    }

 public int calculateDamage() {
        Dice dice20 = new Dice20();
        if (dice20.role () <= 13) {
            Dice dice6 = new Dice6();
            int damage = dice6.role() + 4;
            System.out.println("Treffer! " + damage + " Schadenspunkte!" );
            return damage;
        } 
        else {
            int damage = 0;
            System.out.println("Fehlschlag!");
            return damage;
        }
 }
}
