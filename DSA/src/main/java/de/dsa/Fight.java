/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dsa;

import de.dsa.fighter.Fighter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Uli
 */
public class Fight {

    private List<Fighter> fighters = new ArrayList<Fighter>();

    public void addFighter(Fighter fighter) {
        if (!fighters.contains(fighter)) {
            fighters.add(fighter);
        }
    }


    /**
     * @return the fighters
     */
    public List<Fighter> getFighters() {
        return fighters;
    }

    /**
     * @param fighters the fighters to set
     */
    public void setFighters(List<Fighter> fighters) {
        this.fighters = fighters;
    }
}
