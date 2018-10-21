package com.leetcode.tests;

import com.leetcode.Interval;
import com.leetcode.MeetingRoom;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by appleuser on 9/7/16.
 */
public class MeetingRoomTest {
    private MeetingRoom meetingRoom;
    @Before
    public void setUp() throws Exception {
        meetingRoom = new MeetingRoom();
    }

    @Test
    public void minMeetingRooms() throws Exception {
        Interval[] intervals = {new Interval(2,15), new Interval(36,45),
                new Interval(9,29), new Interval(16,23), new Interval(4,9)};
        int minRooms = meetingRoom.minMeetingRooms(intervals);
        assertEquals(minRooms, 2);
    }

}