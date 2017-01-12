/*
 * Copyright (c) 2013 Hays AG
 */
package de.buschbaum.battle.statistics.core;

import de.buschbaum.battle.statistics.model.CalculationModel;
import de.buschbaum.battle.statistics.model.CalculationResult;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.distribution.BinomialDistribution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ucb
 */
public class CalculationService {

    private static final Logger LOG = LoggerFactory.getLogger(CalculationService.class);

    private static final List<String> messages = new ArrayList<>(2);

    public static CalculationResult calculate(CalculationModel cm) {
        LOG.info("CalculationModel is " + cm);

        messages.clear();
        double chanceHit = caculateD6Chance(cm.getHit(), cm.isReroll1sHit(), cm.isRerollHit());

        //[0] = FnP allowd, [1] = no FnP allowed
        double[] loseWoundChance;
        if (cm.getStrength() != -1) {
            loseWoundChance = calculateLoseWoundUsual(cm.getStrength(), cm.getToughness(), cm.isReroll1sWound(), cm.isRerollWound(),
                    cm.getArmourSave(), cm.isReroll1sArmourSave(), cm.isRerollArmourSave(),
                    cm.getCoverSave(), cm.isReroll1sCoverSave(), cm.isRerollCoverSave(),
                    cm.getInvulnerableSave(), cm.isReroll1sInvulnerableSave(), cm.isRerollInvulnerableSave(),
                    cm.isIgnoreCover(), cm.getAp(), cm.isInstantDeath(), cm.isRending(), chanceHit);
        } else {
            loseWoundChance = calculateLoseWoundD(cm.getArmourSave(), cm.isReroll1sArmourSave(), cm.isRerollArmourSave(),
                    cm.getCoverSave(), cm.isReroll1sCoverSave(), cm.isRerollCoverSave(),
                    cm.getInvulnerableSave(), cm.isReroll1sInvulnerableSave(), cm.isRerollInvulnerableSave(), cm.isIgnoreCover(), cm.getAp(), chanceHit);
            messages.add("Remind that only the D weapon rules regarding saves are applied,");
            messages.add("but no multiple wounds (D3 or D6) will be calculated!");
        }

        double finalLoseWoundChance = applySave(loseWoundChance, cm.getFnpSave());
        String finalWoundMsg = "The chance to inflict an unsaved wound with one shot is " + String.format("%.2f", finalLoseWoundChance * 100) + "%";
        messages.add(finalWoundMsg);
        LOG.info(finalWoundMsg);

        BinomialDistribution binomialDistribution = new BinomialDistribution(cm.getShots(), finalLoseWoundChance);

        CalculationResult calculationResult = new CalculationResult();

        List<Double> binomialResults = new ArrayList<>(cm.getShots());
        for (int i = 1; i <= cm.getShots(); i++) {
            double cumulativeProbability = binomialDistribution.cumulativeProbability(i - 1, cm.getShots());
            LOG.info("The chance for inflicting {} or more unsaved wounds is: {}", i, String.format("%.4f", cumulativeProbability));
            binomialResults.add(cumulativeProbability);
        }
        calculationResult.setBinomialResults(binomialResults);

        calculationResult.setMessages(messages);

        return calculationResult;
    }

    static double applySave(double[] loseWoundChance, int save) {
        return loseWoundChance[0] * (1 - d6(save)) + loseWoundChance[1];
    }

    static double[] calculateLoseWoundD(int armourSave, boolean reroll1sArmourSave, boolean rerollArmourSave,
            int coverSave, boolean reroll1sCoverSave, boolean rerollCoverSave,
            int invulnerableSave, boolean reroll1sInvulnerableSave, boolean rerollInvulnerableSave,
            boolean ignoreCover, int ap, double chanceHit) {

        double[] loseWoundChance = new double[2];

        double[] woundResult = splitDestroyer();
        double usualWoundSaveChance = calculateBestSaveChance(armourSave, reroll1sArmourSave, rerollArmourSave,
                coverSave, reroll1sCoverSave, rerollCoverSave,
                invulnerableSave, reroll1sInvulnerableSave, rerollInvulnerableSave,
                ignoreCover, ap);
        double noSavesWoundSaveChance = 0;

        loseWoundChance[0] = calculateLoseWoundBeforeFnp(chanceHit, woundResult[0], usualWoundSaveChance);
        loseWoundChance[1] = calculateLoseWoundBeforeFnp(chanceHit, woundResult[1], noSavesWoundSaveChance);

        return loseWoundChance;
    }

    static double[] calculateLoseWoundUsual(int strength, int toughness, boolean reroll1sWound, boolean rerollWound,
            int armourSave, boolean reroll1sArmourSave, boolean rerollArmourSave,
            int coverSave, boolean reroll1sCoverSave, boolean rerollCoverSave,
            int invulnerableSave, boolean reroll1sInvulnerableSave, boolean rerollInvulnerableSave,
            boolean ignoreCover, int ap,
            boolean instantDeath, boolean rending, double chanceHit) {

        int woundD6 = calculateWoundD6(strength, toughness);

        double augmentedResult = calculateRendingAndFirstSave(rending, woundD6, reroll1sWound, rerollWound,
                armourSave, reroll1sArmourSave, rerollArmourSave,
                coverSave, reroll1sCoverSave, rerollCoverSave,
                invulnerableSave, reroll1sInvulnerableSave, rerollInvulnerableSave,
                ignoreCover, ap, chanceHit);

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

    static double calculateRendingAndFirstSave(boolean rending, int woundD6, boolean reroll1sWound, boolean rerollWound,
            int armourSave, boolean reroll1sArmourSave, boolean rerollArmourSave,
            int coverSave, boolean reroll1sCoverSave, boolean rerollCoverSave,
            int invulnerableSave, boolean reroll1sInvulnerableSave, boolean rerollInvulnerableSave,
            boolean ignoreCover, int ap, double chanceHit) {

        double augmentedResult;

        double noRendingSaveChance = calculateBestSaveChance(armourSave, reroll1sArmourSave, rerollArmourSave,
                coverSave, reroll1sCoverSave, rerollCoverSave,
                invulnerableSave, reroll1sInvulnerableSave, rerollInvulnerableSave,
                ignoreCover, ap);

        if (rending) {
            double[] woundResult = splitRending(woundD6, reroll1sWound, rerollWound);

            double rendingSaveChance = calculateBestSaveChance(armourSave, reroll1sArmourSave, rerollArmourSave,
                    coverSave, reroll1sCoverSave, rerollCoverSave,
                    invulnerableSave, reroll1sInvulnerableSave, rerollInvulnerableSave,
                    ignoreCover, 2);

            augmentedResult = calculateLoseWoundBeforeFnp(chanceHit, woundResult[0], noRendingSaveChance)
                    + calculateLoseWoundBeforeFnp(chanceHit, woundResult[1], rendingSaveChance);
        } else {

            augmentedResult = calculateLoseWoundBeforeFnp(chanceHit, caculateD6Chance(woundD6, reroll1sWound, rerollWound), noRendingSaveChance);
        }
        return augmentedResult;
    }

    static double calculateLoseWoundBeforeFnp(double hitChance, double woundChance, double bestSaveChance) {
        return hitChance * woundChance * (1 - bestSaveChance);
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

    static double caculateD6Chance(int d, boolean reroll1s, boolean reroll) {
        double chance;
        if (reroll) {
            chance = d6Reroll(d);
        } else if (reroll1s) {
            chance = d6Reroll1s(d);
        } else {
            chance = d6(d);
        }
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
    static double chooseBestSaveChance(double[] saves) {
        double bestSave = saves[0];
        if (saves[1] > bestSave) {
            bestSave = saves[1];
        }
        if (saves[2] > bestSave) {
            bestSave = saves[2];
        }
        return bestSave;
    }

    static double calculateBestSaveChance(int armourSave, boolean reroll1sArmourSave, boolean rerollArmourSave,
            int coverSave, boolean reroll1sCoverSave, boolean rerollCoverSave,
            int invulnerableSave, boolean reroll1sInvulnerableSave, boolean rerollInvulnerableSave,
            boolean ignoreCover, int ap) {

        double[] saves = new double[3];

        if (ap > 0 && ap < 7 && ap <= armourSave) {
            saves[0] = 0;
        } else {
            saves[0] = caculateD6Chance(armourSave, reroll1sArmourSave, rerollArmourSave);
        }

        if (ignoreCover) {
            saves[1] = 0;
        } else {
            saves[1] = caculateD6Chance(coverSave, reroll1sCoverSave, rerollCoverSave);
        }

        saves[2] = caculateD6Chance(invulnerableSave, reroll1sInvulnerableSave, rerollInvulnerableSave);

        return chooseBestSaveChance(saves);
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
