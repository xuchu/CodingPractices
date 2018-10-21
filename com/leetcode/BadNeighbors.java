package com.leetcode;

/**
 * Created by appleuser on 8/27/16.
 */
public class BadNeighbors {
    public int maxDonations(int[] donations){
        int max = 0;
        int len = donations.length;
        int[] d = new int[len];
        if( len < 4 ){
            for( int i = 0; i < len; i++ ){
               max = Math.max(max, donations[i]);
            }
        }
        else{
            //except the last element
            d[0] = donations[0];
            d[1] = donations[1];
            d[2] = donations[2] + d[0];
            for( int i = 3; i < donations.length-1; i++ ){
                d[i] = Math.max(d[i-2], d[i-3]) + donations[i];
            }
            max = Math.max( d[len-2], d[len-3] );
            //except the first element
            d[2] = donations[2];
            d[3] = donations[3] + d[1];
            for( int i = 4; i < donations.length; i++ ){
                d[i] = Math.max(d[i-2], d[i-3]) + donations[i];
            }
            max = Math.max(max, Math.max(d[len-1], d[len-2]));
        }
        return max;
    }
}
