/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dsa.fighter;

/**
 *
 * @author Uli
 */
public abstract class Fighter {
    
    /**
     * Die Lebenspunkte des Kämpfers
     */
    private int healthPoints;
    
    /**
     * Name des Kämpfers
     */
    private String name;

    
    /**
     * Aktion des Kämpfers
     */
    public void attack(Fighter fighter){
        System.out.println(name + " attakiert " + fighter.getName());
        int hp = fighter.getHealthPoints();
        hp = hp - calculateDamage();
        fighter.setHealthPoints(hp);
        System.out.println(fighter.getName() + " hat aktuell " + hp + " Lebenspunkte");
        
    }
    
    public abstract int calculateDamage ();
    
    
    public abstract boolean isGood();

    /**
     * @return the healthPoints
     */
    public int getHealthPoints() {
        return healthPoints;
    }

    /**
     * @param healthPoints the healthPoints to set
     */
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }    
}
