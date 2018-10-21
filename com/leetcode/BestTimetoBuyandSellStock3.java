package com.leetcode;

import java.util.ArrayList;

/**
 * Created by appleuser on 9/14/16.
 */
public class BestTimetoBuyandSellStock3 {
    public int maxProfit(int[] prices) {
        if( prices.length < 2 ){
            return 0;
        }
        int numberDays = prices.length;
        ArrayList<int[]> increasingIntervals = new ArrayList<>();
        for( int dayIndex = 0; dayIndex < numberDays; dayIndex++ ){
            int curDay = dayIndex;
            int nextDay = dayIndex+1;
            while( nextDay < numberDays && prices[curDay] <= prices[nextDay] ){
                curDay++;
                nextDay++;
            }
            if( curDay > dayIndex ) {
                int[] interval = {prices[dayIndex], prices[curDay]};
                increasingIntervals.add(interval);
                dayIndex = curDay;
            }
        }
        if( increasingIntervals.size() == 0){
            return 0;
        }
        int intervalNum = increasingIntervals.size();
        int[][] opt = new int[2][intervalNum];
        int[] firstInterval = increasingIntervals.get(0);
        int min = firstInterval[0];
        opt[0][0] = ( firstInterval[1] - firstInterval[0] );
        opt[1][0] = ( firstInterval[1] - firstInterval[0] );
        for( int i = 1; i < intervalNum; i++ ){
            int[] ithInterval = increasingIntervals.get(i);
            int curIntervalProfit = ithInterval[1] - ithInterval[0];
            min = Math.min(min, ithInterval[0]);
            opt[0][i] = Math.max( opt[0][i-1], ithInterval[1] - min );
            opt[1][i] = Math.max( opt[1][i-1], opt[0][i-1] + curIntervalProfit );
        }
        return Math.max( opt[0][intervalNum -1], opt[1][intervalNum -1] );
    }
}
