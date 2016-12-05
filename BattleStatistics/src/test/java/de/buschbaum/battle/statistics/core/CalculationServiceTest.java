/*
 * Copyright (c) 2013 Hays AG
 */
package de.buschbaum.battle.statistics.core;

import static de.buschbaum.battle.statistics.core.CalculationService.*;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ucb
 */
public class CalculationServiceTest {

    @Test
    public void testd6() {
        double d6_6 = d6(6);
        Assert.assertTrue(littleDifference(d6_6, 0.1666666666666));
        double d6_5 = d6(5);
        Assert.assertTrue(littleDifference(d6_5, 0.3333333333333));
        double d6_2 = d6(2);
        Assert.assertTrue(littleDifference(d6_2, 0.8333333333333));
        double d6_0 = d6(0);
        Assert.assertTrue(littleDifference(d6_0, 0));
        double d6_7 = d6(7);
        Assert.assertTrue(littleDifference(d6_7, 0));
    }

    @Test
    public void testd6Reroll() {
        double d6_5rr = d6Reroll(5);
        Assert.assertTrue(littleDifference(d6_5rr, 0.55555555));
        double d6_2rr = d6Reroll(2);
        Assert.assertTrue(littleDifference(d6_2rr, 0.97222222));
    }

    @Test
    public void testd6Reroll1s() {
        double d6_4rr1s = d6Reroll1s(4);
        Assert.assertTrue(littleDifference(d6_4rr1s, 0.58333333));
        double d6_3rr1s = d6Reroll1s(3);
        Assert.assertTrue(littleDifference(d6_3rr1s, 0.77777777));
    }

    @Test
    public void testRending() {
        double[] rending = splitRending(0.5, 6);
        Assert.assertTrue(littleDifference(rending[1], 0.08333333));
        Assert.assertTrue(littleDifference(rending[0], 0.416666666));
    }

    @Test
    public void testBestSave() {
        int bestSave = chooseBestSave(new int[]{2, 4, 5});
        Assert.assertTrue(bestSave == 2);

        bestSave = chooseBestSave(new int[]{6, 6, 3});
        Assert.assertTrue(bestSave == 3);

        bestSave = chooseBestSave(new int[]{5, 4, 6});
        Assert.assertTrue(bestSave == 4);
    }
    
    
    @Test
    public void testBestSaveRules() {
        int bestSave = chooseBestSave(2, 4, 5, false, 5, false);
        Assert.assertTrue(bestSave == 2);
        bestSave = chooseBestSave(2, 4, 5, false, 2, false);
        Assert.assertTrue(bestSave == 4);
        bestSave = chooseBestSave(2, 4, 5, true, 2, false);
        Assert.assertTrue(bestSave == 5);
        bestSave = chooseBestSave(6, 4, 7, true, 7, false);
        Assert.assertTrue(bestSave == 6);
        bestSave = chooseBestSave(3, 3, 3, true, 4, false);
        Assert.assertTrue(bestSave == 3);
        bestSave = chooseBestSave(2, 2, 2, false, 7, true);
        Assert.assertTrue(bestSave == 7);
    }

    private boolean littleDifference(double a, double b) {
        return Math.abs(a - b) < 0.000001;
    }

    @Test
    public void testRendingDeprecated() {
        double woundChance = 0.44444444;
        double rending = rendingWound(woundChance, woundChance * CalculationService.d6(6), 2, 4);
        Assert.assertTrue(littleDifference(rending, 0.09876543));

        woundChance = 0.69444444;
        rending = rendingWound(woundChance, woundChance * CalculationService.d6(6), 3, 5);
        Assert.assertTrue(littleDifference(rending, 0.27006173));
    }

}
