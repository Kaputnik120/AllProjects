/*
 * Copyright (c) 2013 Hays AG
 */
package de.buschbaum.battle.statistics.core;

import de.buschbaum.battle.statistics.model.CalculationModel;

/**
 *
 * @author ucb
 */
public class CalculationService {

    public static void calculate(CalculationModel calculationModel) {
        System.out.println("CalculationModel is " + calculationModel);
        System.out.println(d6Reroll1s(3));

    }

    private static double d6(int d) {
        if (d < 1 || d > 6) {
            return 0;
        }
        double chance = ((6 - d) + 1) / 6.0;
        return chance;
    }

    private static double d6Reroll(int d) {
        double chance = d6(d) + (1 - d6(d)) * d6(d);
        return chance;
    }

    private static double d6Reroll1s(int d) {
        double chance = d6(d) + (1.0 / 6.0) * d6(d);
        return chance;
    }

    private static double rendingWound(double woundChance, double rendingChance, int armourSave, int invulnerableSave) {      
        double chance = (woundChance - rendingChance) * (1 - d6(armourSave)) + rendingChance * (1 - d6(invulnerableSave));
        return chance;
    }
}
