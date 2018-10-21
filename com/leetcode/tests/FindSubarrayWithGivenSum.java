package com.leetcode.tests;

import java.util.ArrayList;

/**
 * Created by appleuser on 9/15/16.
 */
public class FindSubarrayWithGivenSum {
    public ArrayList<int[]> getRangeList(int[] arr, int target){
        int firstIndex = 0;
        int lastIndex = 1;
        int curSum = arr[firstIndex] + arr[lastIndex];
        ArrayList<int[]> rangeList = new ArrayList<>();
        while( lastIndex < arr.length ){
            if( curSum == target ){
                int[] targetArr = {firstIndex, lastIndex};
                rangeList.add(targetArr);
                break;
            }
            else if( curSum < target ){
                lastIndex++;
                if( lastIndex == arr.length ){
                    break;
                }
                curSum += arr[lastIndex];
            }
            else if( curSum > target ){
                curSum -= arr[firstIndex];
                firstIndex++;
            }
        }
        return rangeList;
    }
}
