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

        double chanceHit;
        if (cm.isRerollHit()) {
            chanceHit = d6Reroll(cm.getHit());
        } else if (cm.isReroll1sHit()) {
            chanceHit = d6Reroll1s(cm.getHit());
        } else {
            chanceHit = d6(cm.getHit());
        }

        double woundChance;
        if (cm.isRerollWound()) {

        }
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

    static int chooseBestSave(int armourSave, int coverSave, int invulnerableSave, boolean ignoreCover, int ap, boolean ignoreAllSaves) {
        if (ignoreAllSaves) {
            return 7; //ignore alle saves
        }

        int[] saves = new int[]{armourSave, coverSave, invulnerableSave};

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

    @Deprecated
    static double rendingWound(double woundChance, double rendingChance, int armourSave, int invulnerableSave) {
        double chance = (woundChance - rendingChance) * (1 - d6(armourSave)) + rendingChance * (1 - d6(invulnerableSave));
        LOG.info("Chance for rending with woundchance {}, rendingChance {}, armourSave {} and invulnerableSave {} is {}",
                woundChance, rendingChance, armourSave, invulnerableSave, chance);
        return chance;
    }

}
