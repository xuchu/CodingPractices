package com.leetcode;

import static org.junit.Assert.*;

/**
 * Created by appleuser on 8/26/16.
 */
public class ZigZagTest {
    private ZigZag zigZag;

    @org.junit.Before
    public void setUp() throws Exception {
        zigZag = new ZigZag();
    }

    @org.junit.Test
    public void longestZigZagOne() throws Exception {
        int[] seq = { 1, 7, 4, 9, 2, 5 };
        int len = zigZag.longestZigZag(seq);
        assertEquals(len, 6);
    }

    @org.junit.Test
    public void longestZigZagTwo() throws Exception {
        int[] seq = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        int len = zigZag.longestZigZag(seq);
        assertEquals(len, 7);
    }

    @org.junit.Test
    public void longestZigZagWithOneNumber() throws Exception {
        int[] seq = {44};
        int len = zigZag.longestZigZag(seq);
        assertEquals(len, 1);
    }

    @org.junit.Test
    public void longestZigZagWithTwoEqualNumber() throws Exception {
        int[] seq = {44,44};
        int len = zigZag.longestZigZag(seq);
        assertEquals(len, 1);
    }

    @org.junit.Test
    public void longestZigZagWithTwoDiffNumber() throws Exception {
        int[] seq = {44,45};
        int len = zigZag.longestZigZag(seq);
        assertEquals(len, 2);
    }

    @org.junit.Test
    public void longestZigZagFour() throws Exception {
        int[] seq = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int len = zigZag.longestZigZag(seq);
        assertEquals(len, 2);
    }

    @org.junit.Test
    public void longestZigZagFive() throws Exception {
        int[] seq = {70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32};
        int len = zigZag.longestZigZag(seq);
        assertEquals(len, 8);
    }

    @org.junit.Test
    public void longestZigZagSix() throws Exception {
        int[] seq = {374, 40, 854, 203, 203, 156, 362, 279, 812, 955,
                600, 947, 978, 46, 100, 953, 670, 862, 568, 188,
                67, 669, 810, 704, 52, 861, 49, 640, 370, 908,
                477, 245, 413, 109, 659, 401, 483, 308, 609, 120,
                249, 22, 176, 279, 23, 22, 617, 462, 459, 244};
        int len = zigZag.longestZigZag(seq);
        assertEquals(len, 36);
    }
}