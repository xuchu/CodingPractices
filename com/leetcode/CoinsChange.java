package com.leetcode;

import java.util.Arrays;

/**
 * Created by appleuser on 9/10/16.
 */
public class CoinsChange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] arr = new int[amount+1];
        Arrays.fill( arr, -1 );
        arr[0] = 0;
        for( int curAmount = 1; curAmount <= amount; curAmount++ ){
            for( int j = 0; j < coins.length; j++ ){
                if( curAmount - coins[j] >= 0 && arr[curAmount - coins[j]] != -1){
                    if( arr[curAmount] == -1 ){
                        arr[curAmount] = arr[curAmount - coins[j]] + 1;
                    }
                    else{
                        arr[curAmount] = Math.min( arr[curAmount], arr[curAmount - coins[j]] + 1 );
                    }
                }
            }
        }
        return arr[amount];
    }
}
