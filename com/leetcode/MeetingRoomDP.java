package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by appleuser on 9/7/16.
 * 现在只有一个room，然后每个meeting都有权重，要求在不冲突的情况下使得最后安排下来的权重和最大
 * Parameter: int[][] meetings = { {1,3,2}, {3,4,3} };
 * {1,3,2} -> start:1, end:3, weight:2
 */
public class MeetingRoomDP {
    public int findLargestWeight(int[][] meetings){
        Arrays.sort(meetings, new Comparator<int[]>(){
            @Override
            public int compare(int[] meetingA, int[] meetingB) {
                return meetingA[0] - meetingB[0];
            }});
        int[] S = new int[meetings.length];
        S[0] = meetings[0][2];
        int maxWeight = 0;
        for( int i = 1; i < meetings.length; i++ ){
            S[i] = meetings[i][2];
            for( int j = 0; j < i; j++ ){
                if( meetings[j][1] <= meetings[i][0] ){
                    S[i] = Math.max(S[i], S[j]+meetings[i][2]);
                }
            }
            maxWeight = Math.max(maxWeight, S[i]);
        }
        return maxWeight;
    }
}
