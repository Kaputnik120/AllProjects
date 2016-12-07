/*
 * Copyright (c) 2013 Hays AG
 */
package de.buschbaum.battle.statistics.core;

import de.buschbaum.battle.statistics.model.CalculationModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ucb
 */
public class CalculationService {

    private static final Logger LOG = LoggerFactory.getLogger(CalculationService.class);

    public static void calculate(CalculationModel cm) {
        LOG.info("CalculationModel is " + cm);

        double chanceHit = calculateHitChance(cm);

        //[0] = FnP allowd, [1] = no FnP allowed
        double[] loseWoundChance;
        if (cm.getStrength() != -1) {
            loseWoundChance = calculateLoseWoundBeforeFnpUsual(cm.getStrength(), cm.getToughness(), cm.isReroll1sWound(), cm.isRerollWound(), cm.getArmourSave(),
                    cm.getCoverSave(), cm.getInvulnerableSave(), cm.isIgnoreCover(), cm.getAp(), cm.isInstantDeath(), cm.isRending(), chanceHit);
        } else {
            loseWoundChance = calculateLoseWoundBeforeFnpD(cm.getArmourSave(), cm.getCoverSave(), cm.getInvulnerableSave(), cm.isIgnoreCover(), cm.getAp(), chanceHit);
        }

        double finalLoseWoundChance = applySave(loseWoundChance, cm.getFnpSave());

        LOG.info("The final chance to inflict an unsaved wound is {}", finalLoseWoundChance);
    }

    static double calculateHitChance(CalculationModel cm) {
        double chanceHit;
        if (cm.isRerollHit()) {
            chanceHit = d6Reroll(cm.getHit());
        } else if (cm.isReroll1sHit()) {
            chanceHit = d6Reroll1s(cm.getHit());
        } else {
            chanceHit = d6(cm.getHit());
        }
        return chanceHit;
    }

    static double applySave(double[] loseWoundChance, int save) {
        return loseWoundChance[0] * (1 - d6(save)) + loseWoundChance[1];
    }

    static double[] calculateLoseWoundBeforeFnpD(int armourSave, int coverSave, int invulnerableSave, boolean ignoreCover, int ap, double chanceHit) {
        double[] loseWoundChance = new double[2];

        double[] woundResult = splitDestroyer();
        int usualWoundSave = chooseBestSave(armourSave, coverSave, invulnerableSave, ignoreCover, ap);
        int noSavesWoundSave = 7;

        loseWoundChance[0] = calculateLoseWoundBeforeFnp(chanceHit, woundResult[0], usualWoundSave);
        loseWoundChance[1] = calculateLoseWoundBeforeFnp(chanceHit, woundResult[1], noSavesWoundSave);

        return loseWoundChance;
    }

    static double[] calculateLoseWoundBeforeFnpUsual(int strength, int toughness, boolean reroll1sWound, boolean rerollWound,
            int armourSave, int coverSave, int invulnerableSave, boolean ignoreCover, int ap,
            boolean instantDeath, boolean rending, double chanceHit) {

        int woundD6 = calculateWoundD6(strength, toughness);

        double augmentedResult = applyRending(rending, woundD6, reroll1sWound, rerollWound, armourSave, coverSave, invulnerableSave, ignoreCover, ap, chanceHit);

        double[] loseWoundChance = applyFnP(strength, toughness, instantDeath, augmentedResult);
        return loseWoundChance;
    }

    static double[] applyFnP(int strength, int toughness, boolean instantDeath, double augmentedResult) {
        double[] loseWoundChance = new double[2];

        boolean fnpAllowed = !isInstantDeath(strength, toughness, instantDeath);
        if (fnpAllowed) {
            loseWoundChance[0] = augmentedResult;
            loseWoundChance[1] = 0;
        } else {
            loseWoundChance[0] = 0;
            loseWoundChance[1] = augmentedResult;
        }

        return loseWoundChance;
    }

    static double applyRending(boolean rending, int woundD6, boolean reroll1sWound, boolean rerollWound, int armourSave, int coverSave, int invulnerableSave, boolean ignoreCover, int ap, double chanceHit) {
        double augmentedResult;
        
        int noRendingSave = chooseBestSave(armourSave, coverSave, invulnerableSave, ignoreCover, ap);
        
        if (rending) {
            double[] woundResult = splitRending(woundD6, reroll1sWound, rerollWound);
            
            int rendingSave = chooseBestSave(armourSave, coverSave, invulnerableSave, ignoreCover, 2);
            augmentedResult = calculateLoseWoundBeforeFnp(chanceHit, woundResult[0], noRendingSave)
                    + calculateLoseWoundBeforeFnp(chanceHit, woundResult[1], rendingSave);
        } else {
            augmentedResult = calculateLoseWoundBeforeFnp(chanceHit, d6(woundD6), noRendingSave);
        }
        return augmentedResult;
    }

    static double calculateLoseWoundBeforeFnp(double hitChance, double woundChance, int bestSave) {
        return hitChance * woundChance * (1 - d6(bestSave));
    }

    static boolean isInstantDeath(int strength, int toughness, boolean instantDeath) {
        return strength >= toughness * 2 || instantDeath;
    }

    static double d6(int d) {
        double chance;
        if (d < 1 || d > 6) {
            chance = 0;
        } else if (d > 1) {
            chance = ((6 - d) + 1) / 6.0;
        } else if (d == 1) {
            chance = 1 / 6.0;
        } else {
            chance = 0;
        }

        LOG.info("Chance for rolling {} is {}", d, chance);
        return chance;
    }

    static double d6Reroll(int d) {
        double chance = d6(d) + (1 - d6(d)) * d6(d);
        LOG.info("Chance for rolling {} with reroll is {}", d, chance);
        return chance;
    }

    static double d6Reroll1s(int d) {
        double chance = d6(d) + (1.0 / 6.0) * d6(d);
        LOG.info("Chance for rolling {} with reroll 1s is {}", d, chance);
        return chance;
    }

    /**
     * Resulting array will contain the woundChance without rending in [0] and
     * the rending chance in [1].
     */
    static double[] splitRending(int woundD6, boolean reroll1s, boolean reroll) {

        double[] splittedRending = new double[2];

        if (reroll1s) {
            double woundChanceNoRending = d6(woundD6 + 1) + d6(1) * d6(woundD6 + 1);
            double rendingChance = d6(6) + d6(1) * d6(6);
            splittedRending[0] = woundChanceNoRending;
            splittedRending[1] = rendingChance;
        } else if (reroll) {
            double woundChanceNoRending = d6(woundD6 + 1) + (1 - d6(woundD6)) * d6(woundD6 + 1);
            double rendingChance = d6(6) + (1 - d6(woundD6)) * d6(6);
            splittedRending[0] = woundChanceNoRending;
            splittedRending[1] = rendingChance;
        } else {
            double woundChanceNoRending = d6(woundD6 + 1);
            double rendingChance = d6(6);
            splittedRending[0] = woundChanceNoRending;
            splittedRending[1] = rendingChance;
        }
        return splittedRending;
    }

    /**
     * Resulting array will contain the woundChance with any saves allowed
     * (D-table 2-5) in [0] and the chance of a no saves allowed wound (D-table
     * 6) in [1].
     */
    static double[] splitDestroyer() {
        double[] splittedDestroyer = new double[2];

        splittedDestroyer[0] = d6(3);
        splittedDestroyer[1] = d6(6);

        return splittedDestroyer;
    }

    /**
     * The given array must contain exactly 3 values.
     */
    static int chooseBestSave(int[] saves) {
        int bestSave = saves[0];
        if (saves[1] < bestSave) {
            bestSave = saves[1];
        }
        if (saves[2] < bestSave) {
            bestSave = saves[2];
        }
        return bestSave;
    }

    static int chooseBestSave(int armourSave, int coverSave, int invulnerableSave, boolean ignoreCover, int ap) {
        int[] saves = new int[]{armourSave, coverSave, invulnerableSave};

        //coverSave=0 better than armourSave=6?
        
        if (ap > 0 && ap < 7 && ap <= armourSave) {
            saves[0] = 7;//ignore armourSave
        }

        if (ignoreCover) {
            saves[1] = 7;//ignore coverSave
        }

        return chooseBestSave(saves);
    }

    static int calculateWoundD6(int strength, int toughness) {
        if (strength - toughness <= -4) {
            return 7; //impossible wound
        }
        if (strength - toughness == -3 || strength - toughness == -2) {
            return 6;
        }
        if (strength - toughness == -1) {
            return 5;
        }
        if (strength - toughness == 0) {
            return 4;
        }
        if (strength - toughness == 1) {
            return 3;
        }
        if (strength - toughness >= 2) {
            return 2;
        }

        return 7; //never happens, stupid compiler
    }
}
