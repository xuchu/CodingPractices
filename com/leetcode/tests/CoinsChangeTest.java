package com.leetcode.tests;

import com.leetcode.CoinsChange;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by appleuser on 9/10/16.
 */
public class CoinsChangeTest {
    private CoinsChange coinsChange;
    @Before
    public void setUp() throws Exception {
        coinsChange = new CoinsChange();
    }

    @Test
    public void coinChange() throws Exception {
        int[] coins = {1};
        int changes = coinsChange.coinChange(coins, 2);
        assertEquals(changes, 2);
    }

}