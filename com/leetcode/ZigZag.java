package com.leetcode;

/**
 * Created by appleuser on 8/26/16.
 */
public class ZigZag {
    public int longestZigZag(int[] sequence){
        if(sequence.length < 2){
            return sequence.length;
        }
        int[] d = new int[sequence.length];
        d[0] = 1;
        d[1] = sequence[0] == sequence[1] ? 1 : 2;
        int len = d[1];
        for( int i = 2; i < d.length; i++ ){
            d[i] = 1;
            for( int j = 1; j < i; j++ ){
                if((sequence[j] > sequence[i] && sequence[j] > sequence[j-1]) ||
                        (sequence[j] < sequence[i] && sequence[j] < sequence[j-1])){
                    d[i] = Math.max( d[i], d[j]+1 );
                }
            }
            len = Math.max( len, d[i] );
        }
        return  len;
    }
}
