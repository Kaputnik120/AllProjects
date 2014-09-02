package de.dsa;

import de.dsa.fighter.Hero;
import de.dsa.fighter.Fighter;
import de.dsa.fighter.Enemy;
import de.dsa.dice.Dice;
import de.dsa.dice.Dice20;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        //User Input
        Hero dredor = new Hero();
        dredor.setName("Dredor");
        dredor.setHealthPoints(30);

        //NPC
        Enemy orc = new Enemy();
        orc.setName("Guffnuck");
        orc.setHealthPoints(25);
        
        //NPC
        Fight fight = new Fight();
        fight.addFighter(dredor);
        fight.addFighter(orc);
        
        //User Input
        while (dredor.getHealthPoints() > 0  && orc.getHealthPoints() > 0){
        dredor.attack(orc);
        orc.attack(dredor);
        }
       
    }

   
}
