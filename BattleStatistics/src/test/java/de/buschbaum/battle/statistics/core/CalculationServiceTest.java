/*
 * Copyright (c) 2013 Hays AG
 */
package de.buschbaum.battle.statistics.core;

import static de.buschbaum.battle.statistics.core.CalculationService.*;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ucb
 */
public class CalculationServiceTest {

    private final static Logger LOG = LoggerFactory.getLogger(CalculationServiceTest.class);

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
        double[] rending = splitRending(3, false, false);
        Assert.assertTrue(littleDifference(rending[0], 0.5));
        Assert.assertTrue(littleDifference(rending[1], 0.16666666));

        rending = splitRending(4, false, false);
        Assert.assertTrue(littleDifference(rending[0], 0.33333333));
        Assert.assertTrue(littleDifference(rending[1], 0.16666666));

        rending = splitRending(5, false, false);
        Assert.assertTrue(littleDifference(rending[0], 0.16666666));
        Assert.assertTrue(littleDifference(rending[1], 0.16666666));

        rending = splitRending(6, false, false);
        Assert.assertTrue(littleDifference(rending[0], 0));
        Assert.assertTrue(littleDifference(rending[1], 0.16666666));

        rending = splitRending(4, true, false);
        Assert.assertTrue(littleDifference(rending[0], 0.38888888));
        Assert.assertTrue(littleDifference(rending[1], 0.19444444));

        rending = splitRending(5, true, false);
        Assert.assertTrue(littleDifference(rending[0], 0.19444444));
        Assert.assertTrue(littleDifference(rending[1], 0.19444444));

        rending = splitRending(6, true, false);
        Assert.assertTrue(littleDifference(rending[0], 0));
        Assert.assertTrue(littleDifference(rending[1], 0.19444444));
        
        rending = splitRending(4, false, true);
        Assert.assertTrue(littleDifference(rending[0], 0.5));
        Assert.assertTrue(littleDifference(rending[1], 0.25));

        rending = splitRending(5, false, true);
        Assert.assertTrue(littleDifference(rending[0], 0.27777777));
        Assert.assertTrue(littleDifference(rending[1], 0.27777777));

        rending = splitRending(6, false, true);
        Assert.assertTrue(littleDifference(rending[0], 0));
        Assert.assertTrue(littleDifference(rending[1], 0.30555555));
    }

    @Test
    public void testBestSave() {
        double bestSaveChance = chooseBestSaveChance(new double[]{0.222222, 0.44444, 0.5555});
        Assert.assertTrue(littleDifference(bestSaveChance, 0.5555));

        bestSaveChance = chooseBestSaveChance(new double[]{0.7892, 0.9999, 0.1234});
        Assert.assertTrue(littleDifference(bestSaveChance, 0.9999));

        bestSaveChance = chooseBestSaveChance(new double[]{0.1234, 0.41232, 0.6436436});
        Assert.assertTrue(littleDifference(bestSaveChance, 0.6436436));
    }

    @Test
    public void testBestSaveRules() {
        double bestSaveChance = calculateBestSaveChance(2, false, false, 
                3, false, false, 
                5, false, false, 
                false, 5);
        Assert.assertTrue(littleDifference(bestSaveChance, 0.8333333333));

    }

    @Test
    public void testCalculateWoundD6() {
        int woundD6 = calculateWoundD6(7, 2);
        Assert.assertTrue(woundD6 == 2);
        woundD6 = calculateWoundD6(3, 2);
        Assert.assertTrue(woundD6 == 3);
        woundD6 = calculateWoundD6(4, 4);
        Assert.assertTrue(woundD6 == 4);
        woundD6 = calculateWoundD6(1, 4);
        Assert.assertTrue(woundD6 == 6);
        woundD6 = calculateWoundD6(6, 8);
        Assert.assertTrue(woundD6 == 6);
        woundD6 = calculateWoundD6(5, 10);
        Assert.assertTrue(woundD6 == 7);
        woundD6 = calculateWoundD6(10, 4);
        Assert.assertTrue(woundD6 == 2);
    }

    //Calculate
    //calculateLoseWoundBeforeFnpD
    //calculateLoseWoundBeforeFnpUsual
    //applyRending
    @Test
    public void testCalculateWoundBeforeFnp() {
        double woundChance = calculateLoseWoundBeforeFnp(0.5, 0.5, 5.0/6);
        Assert.assertTrue(littleDifference(woundChance, 0.04166666));
        woundChance = calculateLoseWoundBeforeFnp(0.5, 0.5, 0);
        Assert.assertTrue(littleDifference(woundChance, 0.25));
        woundChance = calculateLoseWoundBeforeFnp(0.654, 0.234, 4.0/6);
        Assert.assertTrue(littleDifference(woundChance, 0.051012));
    }

    @Test
    public void testApplySave() {
        double applySave = applySave(new double[]{0.66666666, 0}, 5);
        Assert.assertTrue(littleDifference(applySave, 0.444444444));
        applySave = applySave(new double[]{0.23456, 0}, 4);
        Assert.assertTrue(littleDifference(applySave, 0.11728));
        applySave = applySave(new double[]{0.216431642152, 0}, 7);
        Assert.assertTrue(littleDifference(applySave, 0.216431642152));
        applySave = applySave(new double[]{0, 0.42312}, 2);
        Assert.assertTrue(littleDifference(applySave, 0.42312));
    }

    @Test
    public void testSplitDestroyer() {
        double[] splitDestroyer = splitDestroyer();
        Assert.assertTrue(littleDifference(splitDestroyer[1], 0.1666666));
        Assert.assertTrue(littleDifference(splitDestroyer[0], 0.6666666));
    }

    @Test
    public void testIsInstantDeath() {
        boolean instantDeath = isInstantDeath(10, 5, false);
        Assert.assertTrue(instantDeath);
        instantDeath = isInstantDeath(7, 5, false);
        Assert.assertTrue(!instantDeath);
        instantDeath = isInstantDeath(7, 5, true);
        Assert.assertTrue(instantDeath);
        instantDeath = isInstantDeath(2, 5, false);
        Assert.assertTrue(!instantDeath);
        instantDeath = isInstantDeath(6, 3, false);
        Assert.assertTrue(instantDeath);
    }

    private boolean littleDifference(double a, double b) {
        LOG.info("Checking {} and {}", a, b);
        return Math.abs(a - b) < 0.0001;
    }
}
