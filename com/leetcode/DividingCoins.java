package com.leetcode;

import java.util.Arrays;

/**
 * Created by appleuser on 9/9/16.
 */
public class DividingCoins {
    public int getMinimumDifference(int[] coins){
        int sum = 0;
        for( int coin : coins ){
            sum += coin;
        }
        Arrays.sort(coins);
        return helper(coins, sum);
    }

    private int helper( int[] coins, int sum ){
        boolean[] arr = new boolean[sum+1];
        Arrays.fill(arr, false);
        arr[0] = true;
        for( int i = 0; i < coins.length; i++ ){
            for( int j = sum; j >= coins[i]; j-- ){
                if( arr[j - coins[i]]){
                    arr[j] = true;
                }
            }
        }
        int mid = sum / 2;
        for( int i = 0; i <= mid; i++ ){
            int moneyGetByA = mid - i;
            if( arr[moneyGetByA] ){
                int moneyGetByB = sum - moneyGetByA;
                return Math.abs(moneyGetByA-moneyGetByB);
            }
        }
        return -1;
    }
}
