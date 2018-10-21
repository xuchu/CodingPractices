package com.leetcode.tests;

import com.leetcode.PerfectRectangle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by appleuser on 8/31/16.
 */
public class PerfectRectangleTest {
    private PerfectRectangle perfectRectangle;
    @Before
    public void setUp() throws Exception {
        perfectRectangle = new PerfectRectangle();
    }

    @Test
    public void isRectangleCoverOne() throws Exception {
        int[][] rects = {{1,0,2,1},{0,0,2,1},{0,2,1,3},{0,1,2,2}};
        boolean result = perfectRectangle.isRectangleCover(rects);
        assertEquals(result, false);
    }

    @Test
    public void isRectangleCoverTwo() throws Exception {
        int[][] rects = {{1,1,3,3},{3,1,4,2},{1,3,2,4},{2,2,4,4}};
        boolean result = perfectRectangle.isRectangleCover(rects);
        assertEquals(result, false);
    }

    @Test
    public void isRectangleCoverThree() throws Exception {
        int[][] rects = {{1,1,3,3}, {3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
        boolean result = perfectRectangle.isRectangleCover(rects);
        assertEquals(result, true);
    }

    @Test
    public void isRectangleCoverFour() throws Exception {
        int[][] rects = {{0,0,4,1},{7,0,8,2},{6,2,8,3},{5,1,6,3},{4,0,5,1},{6,0,7,2},{4,2,5,3},{2,1,4,3},{0,1,2,2},{0,2,2,3},{4,1,5,2},{5,0,6,1}};
        boolean result = perfectRectangle.isRectangleCover(rects);
        assertEquals(result, true);
    }
}