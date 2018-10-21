package com.leetcode.tests;

import com.leetcode.BadNeighbors;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by appleuser on 8/27/16.
 */
public class BadNeighborsTest {
    private BadNeighbors badNeighbors;

    @Before
    public void setUp() throws Exception {
        badNeighbors = new BadNeighbors();
    }

    @Test
    public void maxDonations1() throws Exception {
        int[] donations = { 7, 7, 7, 7, 7, 7, 7 };
        int max = badNeighbors.maxDonations(donations);
        assertEquals(max, 21);
    }

    @Test
    public void maxDonations2() throws Exception {
        int[] donations = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
        int max = badNeighbors.maxDonations(donations);
        assertEquals(max, 16);
    }

    @Test
    public void maxDonations3() throws Exception {
        int[] donations = {94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,
                6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
                52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72};
        int max = badNeighbors.maxDonations(donations);
        assertEquals(max, 2926);
    }

    @Test
    public void maxDonations4() throws Exception {
        int[] donations = { 10, 3, 2, 5, 7, 8 };
        int max = badNeighbors.maxDonations(donations);
        assertEquals(max,19);
    }

}