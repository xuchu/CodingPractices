package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



enum MeetingStatus{
    START, END;
}

class MeetingTime{
    public int timestamp;
    public MeetingStatus status;

    public MeetingTime(int timestamp, MeetingStatus status){
        this.timestamp = timestamp;
        this.status = status;
    }
}

public class MeetingRooms2 {

    public int minMeetingRooms(Interval[] intervals) {
        List<MeetingTime> meetingTimes = new ArrayList<>();
        for( Interval interval : intervals ){
            MeetingTime startMeetingTime = new MeetingTime(interval.start, MeetingStatus.START);
            MeetingTime endMeetingTime = new MeetingTime(interval.end, MeetingStatus.END);
            meetingTimes.add(startMeetingTime);
            meetingTimes.add(endMeetingTime);
        }
        Collections.sort(meetingTimes, (x, y) -> {
            if( x.timestamp != y.timestamp ){
                return x.timestamp - y.timestamp;
            }else{
                return x.status == MeetingStatus.START ? 1 : -1;
            }
        });
        int numMeetingRoom = 0;
        int maxNumMeetingRoom = 0;
        for( MeetingTime meetingTime :  meetingTimes ){
            if( meetingTime.status == MeetingStatus.START ){
                numMeetingRoom++;
            }
            if( meetingTime.status == MeetingStatus.END ){
                numMeetingRoom--;
            }
            if( numMeetingRoom >  maxNumMeetingRoom ){
                maxNumMeetingRoom = numMeetingRoom;
            }
        }
        return maxNumMeetingRoom;
    }
}