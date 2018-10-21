package com.leetcode.tests;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by appleuser on 9/15/16.
 */
public class FindSubarrayWithGivenSumTest {
    private FindSubarrayWithGivenSum hello;
    @Before
    public void setUp() throws Exception {
        hello = new FindSubarrayWithGivenSum();
    }

    @Test
    public void getRangeList() throws Exception {
        int[] arr = {1, 4, 20, 3, 10, 5};
        ArrayList<int[]> result = hello.getRangeList(arr, 33);
        assertEquals(result.size(), 1);
    }

}