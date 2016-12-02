/*
 * Copyright (c) 2013 Hays AG
 */
package de.buschbaum.battle.statistics.model;

/**
 *
 * @author ucb
 */
public class CalculationModel {

    /**
     * Append + for human readibility. E.g. 3 is interpreted as 3+. -1 indicates
     * automatic hit.
     */
    private int hit;

    private boolean rerollHit;

    private boolean reroll1sHit;

    /**
     * Strength "D" will be represented as -1.
     */
    private int strength;

    private boolean rerollWound;

    private boolean rending;

    /**
     * If ap is "-", it's represented as -1.
     */
    private int ap;

    private int shots;

    private int shootingPoints;

    private int toughness;

    /**
     * Append "+" to the value for human readibility. No armour save is
     * represented as -1.
     */
    private int armourSave;

    private boolean rerollArmourSaves;

    private boolean reroll1sArmourSaves;

    /**
     * Append "+" to the value for human readibility. No armour save is
     * represented as -1.
     */
    private int invulnerableSave;

    private boolean rerollInvulnerableSave;

    private boolean reroll1sInvulnerableSave;

    /**
     * Append "+" to the value for human readibility. No armour save is
     * represented as -1.
     */
    private int fnpSave;

    private boolean rerollFnpSave;

    private boolean reroll1sFnpSave;

    private int wounds;

    private int points;

    @Override
    public String toString() {
        return "CalculationModel{" + "hit=" + hit + ", rerollHit=" + rerollHit + ", reroll1sHit=" + reroll1sHit + ", strength=" + strength + ", rerollWound=" + rerollWound + ", rending=" + rending + ", ap=" + ap + ", shots=" + shots + ", shootingPoints=" + shootingPoints + ", toughness=" + toughness + ", armourSave=" + armourSave + ", rerollArmourSaves=" + rerollArmourSaves + ", reroll1sArmourSaves=" + reroll1sArmourSaves + ", invulnerableSave=" + invulnerableSave + ", rerollInvulnerableSave=" + rerollInvulnerableSave + ", reroll1sInvulnerableSave=" + reroll1sInvulnerableSave + ", fnpSave=" + fnpSave + ", rerollFnpSave=" + rerollFnpSave + ", reroll1sFnpSave=" + reroll1sFnpSave + ", wounds=" + wounds + ", points=" + points + '}';
    }

    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.getHit();
        hash = 71 * hash + (this.isRerollHit() ? 1 : 0);
        hash = 71 * hash + (this.isReroll1sHit() ? 1 : 0);
        hash = 71 * hash + this.getStrength();
        hash = 71 * hash + (this.isRerollWound() ? 1 : 0);
        hash = 71 * hash + (this.isRending() ? 1 : 0);
        hash = 71 * hash + this.getAp();
        hash = 71 * hash + this.getShots();
        hash = 71 * hash + this.getShootingPoints();
        hash = 71 * hash + this.getToughness();
        hash = 71 * hash + this.getArmourSave();
        hash = 71 * hash + (this.isRerollArmourSaves() ? 1 : 0);
        hash = 71 * hash + (this.isReroll1sArmourSaves() ? 1 : 0);
        hash = 71 * hash + this.getInvulnerableSave();
        hash = 71 * hash + (this.isRerollInvulnerableSave() ? 1 : 0);
        hash = 71 * hash + (this.isReroll1sInvulnerableSave() ? 1 : 0);
        hash = 71 * hash + this.getFnpSave();
        hash = 71 * hash + (this.isRerollFnpSave() ? 1 : 0);
        hash = 71 * hash + (this.isReroll1sFnpSave() ? 1 : 0);
        hash = 71 * hash + this.getWounds();
        hash = 71 * hash + this.getPoints();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CalculationModel other = (CalculationModel) obj;
        if (this.getHit() != other.getHit()) {
            return false;
        }
        if (this.isRerollHit() != other.isRerollHit()) {
            return false;
        }
        if (this.isReroll1sHit() != other.isReroll1sHit()) {
            return false;
        }
        if (this.getStrength() != other.getStrength()) {
            return false;
        }
        if (this.isRerollWound() != other.isRerollWound()) {
            return false;
        }
        if (this.isRending() != other.isRending()) {
            return false;
        }
        if (this.getAp() != other.getAp()) {
            return false;
        }
        if (this.getShots() != other.getShots()) {
            return false;
        }
        if (this.getShootingPoints() != other.getShootingPoints()) {
            return false;
        }
        if (this.getToughness() != other.getToughness()) {
            return false;
        }
        if (this.getArmourSave() != other.getArmourSave()) {
            return false;
        }
        if (this.isRerollArmourSaves() != other.isRerollArmourSaves()) {
            return false;
        }
        if (this.isReroll1sArmourSaves() != other.isReroll1sArmourSaves()) {
            return false;
        }
        if (this.getInvulnerableSave() != other.getInvulnerableSave()) {
            return false;
        }
        if (this.isRerollInvulnerableSave() != other.isRerollInvulnerableSave()) {
            return false;
        }
        if (this.isReroll1sInvulnerableSave() != other.isReroll1sInvulnerableSave()) {
            return false;
        }
        if (this.getFnpSave() != other.getFnpSave()) {
            return false;
        }
        if (this.isRerollFnpSave() != other.isRerollFnpSave()) {
            return false;
        }
        if (this.isReroll1sFnpSave() != other.isReroll1sFnpSave()) {
            return false;
        }
        if (this.getWounds() != other.getWounds()) {
            return false;
        }
        if (this.getPoints() != other.getPoints()) {
            return false;
        }
        return true;
    }

    /**
     * @return the hit
     */
    public int getHit() {
        return hit;
    }

    /**
     * @param hit the hit to set
     */
    public void setHit(int hit) {
        this.hit = hit;
    }

    /**
     * @return the rerollHit
     */
    public boolean isRerollHit() {
        return rerollHit;
    }

    /**
     * @param rerollHit the rerollHit to set
     */
    public void setRerollHit(boolean rerollHit) {
        this.rerollHit = rerollHit;
    }

    /**
     * @return the reroll1sHit
     */
    public boolean isReroll1sHit() {
        return reroll1sHit;
    }

    /**
     * @param reroll1sHit the reroll1sHit to set
     */
    public void setReroll1sHit(boolean reroll1sHit) {
        this.reroll1sHit = reroll1sHit;
    }

    /**
     * @return the strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * @param strength the strength to set
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * @return the rerollWound
     */
    public boolean isRerollWound() {
        return rerollWound;
    }

    /**
     * @param rerollWound the rerollWound to set
     */
    public void setRerollWound(boolean rerollWound) {
        this.rerollWound = rerollWound;
    }

    /**
     * @return the rending
     */
    public boolean isRending() {
        return rending;
    }

    /**
     * @param rending the rending to set
     */
    public void setRending(boolean rending) {
        this.rending = rending;
    }

    /**
     * @return the ap
     */
    public int getAp() {
        return ap;
    }

    /**
     * @param ap the ap to set
     */
    public void setAp(int ap) {
        this.ap = ap;
    }

    /**
     * @return the shots
     */
    public int getShots() {
        return shots;
    }

    /**
     * @param shots the shots to set
     */
    public void setShots(int shots) {
        this.shots = shots;
    }

    /**
     * @return the shootingPoints
     */
    public int getShootingPoints() {
        return shootingPoints;
    }

    /**
     * @param shootingPoints the shootingPoints to set
     */
    public void setShootingPoints(int shootingPoints) {
        this.shootingPoints = shootingPoints;
    }

    /**
     * @return the toughness
     */
    public int getToughness() {
        return toughness;
    }

    /**
     * @param toughness the toughness to set
     */
    public void setToughness(int toughness) {
        this.toughness = toughness;
    }

    /**
     * @return the armourSave
     */
    public int getArmourSave() {
        return armourSave;
    }

    /**
     * @param armourSave the armourSave to set
     */
    public void setArmourSave(int armourSave) {
        this.armourSave = armourSave;
    }

    /**
     * @return the rerollArmourSaves
     */
    public boolean isRerollArmourSaves() {
        return rerollArmourSaves;
    }

    /**
     * @param rerollArmourSaves the rerollArmourSaves to set
     */
    public void setRerollArmourSaves(boolean rerollArmourSaves) {
        this.rerollArmourSaves = rerollArmourSaves;
    }

    /**
     * @return the reroll1sArmourSaves
     */
    public boolean isReroll1sArmourSaves() {
        return reroll1sArmourSaves;
    }

    /**
     * @param reroll1sArmourSaves the reroll1sArmourSaves to set
     */
    public void setReroll1sArmourSaves(boolean reroll1sArmourSaves) {
        this.reroll1sArmourSaves = reroll1sArmourSaves;
    }

    /**
     * @return the invulnerableSave
     */
    public int getInvulnerableSave() {
        return invulnerableSave;
    }

    /**
     * @param invulnerableSave the invulnerableSave to set
     */
    public void setInvulnerableSave(int invulnerableSave) {
        this.invulnerableSave = invulnerableSave;
    }

    /**
     * @return the rerollInvulnerableSave
     */
    public boolean isRerollInvulnerableSave() {
        return rerollInvulnerableSave;
    }

    /**
     * @param rerollInvulnerableSave the rerollInvulnerableSave to set
     */
    public void setRerollInvulnerableSave(boolean rerollInvulnerableSave) {
        this.rerollInvulnerableSave = rerollInvulnerableSave;
    }

    /**
     * @return the reroll1sInvulnerableSave
     */
    public boolean isReroll1sInvulnerableSave() {
        return reroll1sInvulnerableSave;
    }

    /**
     * @param reroll1sInvulnerableSave the reroll1sInvulnerableSave to set
     */
    public void setReroll1sInvulnerableSave(boolean reroll1sInvulnerableSave) {
        this.reroll1sInvulnerableSave = reroll1sInvulnerableSave;
    }

    /**
     * @return the fnpSave
     */
    public int getFnpSave() {
        return fnpSave;
    }

    /**
     * @param fnpSave the fnpSave to set
     */
    public void setFnpSave(int fnpSave) {
        this.fnpSave = fnpSave;
    }

    /**
     * @return the rerollFnpSave
     */
    public boolean isRerollFnpSave() {
        return rerollFnpSave;
    }

    /**
     * @param rerollFnpSave the rerollFnpSave to set
     */
    public void setRerollFnpSave(boolean rerollFnpSave) {
        this.rerollFnpSave = rerollFnpSave;
    }

    /**
     * @return the reroll1sFnpSave
     */
    public boolean isReroll1sFnpSave() {
        return reroll1sFnpSave;
    }

    /**
     * @param reroll1sFnpSave the reroll1sFnpSave to set
     */
    public void setReroll1sFnpSave(boolean reroll1sFnpSave) {
        this.reroll1sFnpSave = reroll1sFnpSave;
    }

    /**
     * @return the wounds
     */
    public int getWounds() {
        return wounds;
    }

    /**
     * @param wounds the wounds to set
     */
    public void setWounds(int wounds) {
        this.wounds = wounds;
    }

    /**
     * @return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(int points) {
        this.points = points;
    }

}
