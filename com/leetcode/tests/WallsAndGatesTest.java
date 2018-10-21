package com.leetcode.tests;

import com.leetcode.WallsAndGates;
import org.junit.Test;

public class WallsAndGatesTest {
    @Test
    public void test(){
        int[][] rooms = {
                {2147483647,-1,0},
                {2147483647,2147483647,2147483647},
                {2147483647,-1,2147483647}
        };
        WallsAndGates wallsAndGates = new WallsAndGates();
        wallsAndGates.wallsAndGates(rooms);
        System.out.println(rooms);
    }
}