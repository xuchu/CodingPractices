package com.leetcode.tests;

import com.leetcode.TheMaze1;
import org.junit.Assert;
import org.junit.Test;

public class TheMaze1Test {
    @Test
    public void hasPath(){
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        TheMaze1 theMaze = new TheMaze1();
        int[] start = {0,4};
        int[] des = {4,4};
        Assert.assertTrue(theMaze.hasPath(maze, start, des));
    }
}