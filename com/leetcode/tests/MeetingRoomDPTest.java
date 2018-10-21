package com.leetcode.tests;

import com.leetcode.MeetingRoomDP;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by appleuser on 9/7/16.
 */
public class MeetingRoomDPTest {
    private MeetingRoomDP meetingRoomDP;

    @Before
    public void setUp() throws Exception {
        meetingRoomDP = new MeetingRoomDP();
    }

    @Test
    public void findLargestWeightOne() throws Exception {
        int[][] meetings = { {1,2,1},{2,3,2},{3,4,3} };
        int maxWeight = meetingRoomDP.findLargestWeight(meetings);
        assertEquals(maxWeight, 6);
    }

    @Test
    public void findLargestWeightTwo() throws Exception {
        //avoid the middle one
        int[][] meetings = { {1,3,1},{2,4,2},{3,4,3} };
        int maxWeight = meetingRoomDP.findLargestWeight(meetings);
        assertEquals(maxWeight, 4);
    }

    @Test
    public void findLargestWeightThree() throws Exception {
        //avoid the first one
        int[][] meetings = { {1,3,1},{2,4,2},{4,6,3} };
        int maxWeight = meetingRoomDP.findLargestWeight(meetings);
        assertEquals(maxWeight, 5);
    }
}