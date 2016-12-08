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

    private boolean reroll1sWound;

    private boolean rending;

    private boolean instantDeath;

    private boolean ignoreCover;

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

    /**
     * Append "+" to the value for human readibility. No cover save is
     * represented as -1.
     */
    private int coverSave;

    private boolean rerollCoverSave;

    private boolean reroll1sCoverSave;

    private boolean rerollArmourSave;

    private boolean reroll1sArmourSave;

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
        return "CalculationModel{" + "hit=" + hit + ", rerollHit=" + rerollHit + ", reroll1sHit=" + reroll1sHit + ", strength=" + strength + ", rerollWound=" + rerollWound + ", reroll1sWound=" + reroll1sWound + ", rending=" + rending + ", instantDeath=" + instantDeath + ", ignoreCover=" + ignoreCover + ", ap=" + ap + ", shots=" + shots + ", shootingPoints=" + shootingPoints + ", toughness=" + toughness + ", armourSave=" + armourSave + ", coverSave=" + coverSave + ", rerollCoverSave=" + rerollCoverSave + ", reroll1sCoverSave=" + reroll1sCoverSave + ", rerollArmourSave=" + rerollArmourSave + ", reroll1sArmourSave=" + reroll1sArmourSave + ", invulnerableSave=" + invulnerableSave + ", rerollInvulnerableSave=" + rerollInvulnerableSave + ", reroll1sInvulnerableSave=" + reroll1sInvulnerableSave + ", fnpSave=" + fnpSave + ", rerollFnpSave=" + rerollFnpSave + ", reroll1sFnpSave=" + reroll1sFnpSave + ", wounds=" + wounds + ", points=" + points + '}';
    }

    /**
     * Append + for human readibility. E.g. 3 is interpreted as 3+. -1 indicates
     * automatic hit.
     *
     * @return the hit
     */
    public int getHit() {
        return hit;
    }

    /**
     * Append + for human readibility. E.g. 3 is interpreted as 3+. -1 indicates
     * automatic hit.
     *
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
     * Strength "D" will be represented as -1.
     *
     * @return the strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Strength "D" will be represented as -1.
     *
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
     * @return the reroll1sWound
     */
    public boolean isReroll1sWound() {
        return reroll1sWound;
    }

    /**
     * @param reroll1sWound the reroll1sWound to set
     */
    public void setReroll1sWound(boolean reroll1sWound) {
        this.reroll1sWound = reroll1sWound;
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
     * @return the instantDeath
     */
    public boolean isInstantDeath() {
        return instantDeath;
    }

    /**
     * @param instantDeath the instantDeath to set
     */
    public void setInstantDeath(boolean instantDeath) {
        this.instantDeath = instantDeath;
    }

    /**
     * @return the ignoreCover
     */
    public boolean isIgnoreCover() {
        return ignoreCover;
    }

    /**
     * @param ignoreCover the ignoreCover to set
     */
    public void setIgnoreCover(boolean ignoreCover) {
        this.ignoreCover = ignoreCover;
    }

    /**
     * If ap is "-", it's represented as -1.
     *
     * @return the ap
     */
    public int getAp() {
        return ap;
    }

    /**
     * If ap is "-", it's represented as -1.
     *
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
     * Append "+" to the value for human readibility. No armour save is
     * represented as -1.
     *
     * @return the armourSave
     */
    public int getArmourSave() {
        return armourSave;
    }

    /**
     * Append "+" to the value for human readibility. No armour save is
     * represented as -1.
     *
     * @param armourSave the armourSave to set
     */
    public void setArmourSave(int armourSave) {
        this.armourSave = armourSave;
    }

    /**
     * Append "+" to the value for human readibility. No cover save is
     * represented as -1.
     *
     * @return the coverSave
     */
    public int getCoverSave() {
        return coverSave;
    }

    /**
     * Append "+" to the value for human readibility. No cover save is
     * represented as -1.
     *
     * @param coverSave the coverSave to set
     */
    public void setCoverSave(int coverSave) {
        this.coverSave = coverSave;
    }

    /**
     * @return the rerollCoverSave
     */
    public boolean isRerollCoverSave() {
        return rerollCoverSave;
    }

    /**
     * @param rerollCoverSave the rerollCoverSave to set
     */
    public void setRerollCoverSave(boolean rerollCoverSave) {
        this.rerollCoverSave = rerollCoverSave;
    }

    /**
     * @return the reroll1sCoverSave
     */
    public boolean isReroll1sCoverSave() {
        return reroll1sCoverSave;
    }

    /**
     * @param reroll1sCoverSave the reroll1sCoverSave to set
     */
    public void setReroll1sCoverSave(boolean reroll1sCoverSave) {
        this.reroll1sCoverSave = reroll1sCoverSave;
    }

    /**
     * @return the rerollArmourSave
     */
    public boolean isRerollArmourSave() {
        return rerollArmourSave;
    }

    /**
     * @param rerollArmourSave the rerollArmourSave to set
     */
    public void setRerollArmourSave(boolean rerollArmourSave) {
        this.rerollArmourSave = rerollArmourSave;
    }

    /**
     * @return the reroll1sArmourSave
     */
    public boolean isReroll1sArmourSave() {
        return reroll1sArmourSave;
    }

    /**
     * @param reroll1sArmourSave the reroll1sArmourSave to set
     */
    public void setReroll1sArmourSave(boolean reroll1sArmourSave) {
        this.reroll1sArmourSave = reroll1sArmourSave;
    }

    /**
     * Append "+" to the value for human readibility. No armour save is
     * represented as -1.
     *
     * @return the invulnerableSave
     */
    public int getInvulnerableSave() {
        return invulnerableSave;
    }

    /**
     * Append "+" to the value for human readibility. No armour save is
     * represented as -1.
     *
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
     * Append "+" to the value for human readibility. No armour save is
     * represented as -1.
     *
     * @return the fnpSave
     */
    public int getFnpSave() {
        return fnpSave;
    }

    /**
     * Append "+" to the value for human readibility. No armour save is
     * represented as -1.
     *
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
