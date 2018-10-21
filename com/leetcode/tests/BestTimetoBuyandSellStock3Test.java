package com.leetcode.tests;

import com.leetcode.BestTimetoBuyandSellStock3;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BestTimetoBuyandSellStock3Test {
    private BestTimetoBuyandSellStock3 stock;
    @Before
    public void setUp() throws Exception {
        stock = new BestTimetoBuyandSellStock3();
    }

    @Test
    public void maxProfit() throws Exception {
        int[] prices = {2,1};
        int maxProfit = stock.maxProfit(prices);
        assertEquals(maxProfit, 0);
    }

    @Test
    public void maxProfitTwo() throws Exception {
        int[] prices = {8,3,6,2,8,8,8,4,2,0,7,2,9,4,9};
        int maxProfit = stock.maxProfit(prices);
        assertEquals(maxProfit, 2);
    }

}