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

    public static void calculate(CalculationModel calculationModel) {
        LOG.info("CalculationModel is " + calculationModel);
    }

    static double d6(int d) {
        if (d < 1 || d > 6) {
            return 0;
        }
        double chance = ((6 - d) + 1) / 6.0;
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
     * Resulting array will contain the rendingChance in [0] and the woundChance
     * - rendingChance in [1].
     */
    static double[] splitRending(double woundChance, int dRending) {
        double rendingChance = woundChance * d6(dRending);
        double[] splittedRending = new double[2];
        splittedRending[0] = woundChance - rendingChance;
        splittedRending[1] = rendingChance;
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
        
        int[] saves = new int [] {armourSave, coverSave, invulnerableSave};
        
        if (ap > 0 && ap < 7 && ap <= armourSave) {
            saves[0] = 7;//ignore armourSave
        }
        
        if (ignoreCover) {
            saves[1] = 7;//ignore coverSave
        }
        
        return chooseBestSave(saves);
    }

    
    @Deprecated
    static double rendingWound(double woundChance, double rendingChance, int armourSave, int invulnerableSave) {
        double chance = (woundChance - rendingChance) * (1 - d6(armourSave)) + rendingChance * (1 - d6(invulnerableSave));
        LOG.info("Chance for rending with woundchance {}, rendingChance {}, armourSave {} and invulnerableSave {} is {}",
                woundChance, rendingChance, armourSave, invulnerableSave, chance);
        return chance;
    }

}
