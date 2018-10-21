package com.leetcode.tests;

import com.leetcode.LinearEquation;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by appleuser on 9/8/16.
 */
public class LinearEquationTest {
    private LinearEquation linearEquation;

    @Before
    public void setUp() throws Exception {
        linearEquation = new LinearEquation();
    }

    @Test
    public void getSolution() throws Exception {
        ArrayList<Integer> coeffList = new ArrayList<>(Arrays.asList(2, 2, 3));
        int rhs = 4;
        ArrayList<ArrayList<Integer>> solutions = linearEquation.getSolution(coeffList, rhs);
        assertEquals(solutions.size(), 3);
    }

}