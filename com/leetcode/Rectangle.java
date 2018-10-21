package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by appleuser on 8/29/16.
 */
public class Rectangle {
    public List<Rec> getUnitRecs(int[] rectangle){
        List<Rec> unitRecs = new ArrayList<Rec>();
        int leftBottomX = rectangle[0];
        int leftBottomY = rectangle[1];
        int rightTopX = rectangle[2];
        int rightTopY = rectangle[3];
        for( int y = leftBottomY; y < rightTopY; y++ ) {
            for (int x = leftBottomX; x < rightTopX; x++) {
                unitRecs.add(new Rec(x, y));
            }
        }
        return unitRecs;
    }
}
