package com.leetcode.tests;

import com.leetcode.Interval;
import com.leetcode.MeetingRooms2;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MeetingRooms2Test {
    @Test
    public void test1(){
        Interval[] intervals = {new Interval(13,15), new Interval(1,13)};
        MeetingRooms2 meetingRooms2 = new MeetingRooms2();
        int minMeetingRooms = meetingRooms2.minMeetingRooms(intervals);
        assertThat(minMeetingRooms, is(1));
    }
}