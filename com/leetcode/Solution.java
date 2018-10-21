package com.leetcode;

/**
 * Created by appleuser on 8/29/16.
 */
public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int sumArea = 0;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for( int[] rectangle : rectangles ){
            int leftBottomX = rectangle[0];
            int leftBottomY = rectangle[1];
            int rightTopX = rectangle[2];
            int rightTopY = rectangle[3];
            minX = Math.min( minX, leftBottomX );
            minY = Math.min( minY, leftBottomY);
            maxX = Math.max( maxX, rightTopX);
            maxY = Math.max( maxX, rightTopY);
            sumArea += (rightTopX-leftBottomX) * (rightTopY-leftBottomY);
        }
        int area = (maxX - minX) * (maxY - minY);
        return sumArea == area;
    }
}