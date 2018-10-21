package com.leetcode.tests;

import com.leetcode.DividingCoins;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by appleuser on 9/10/16.
 */
public class DividingCoinsTest {
    private DividingCoins dividingCoins;
    @Before
    public void setUp() throws Exception {
        dividingCoins = new DividingCoins();
    }

    @Test
    public void getMinimumDifferenceOne() throws Exception {
        int[] coins = {2,5,3};
        int minDiff = dividingCoins.getMinimumDifference(coins);
        assertEquals(minDiff, 0);
    }

    @Test
    public void getMinimumDifferenceTwo() throws Exception {
        int[] coins = {2,5,3,5,100};
        int minDiff = dividingCoins.getMinimumDifference(coins);
        assertEquals(minDiff, 85);
    }

}