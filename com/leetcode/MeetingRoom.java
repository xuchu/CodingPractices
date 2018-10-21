package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by appleuser on 9/7/16.
 */

public class MeetingRoom {

    private class Room implements Comparable<Room>{
        public int availableTime;
        public ArrayList<Interval> meetingList = new ArrayList<>();

        public void add(Interval interval){
            meetingList.add(interval);
            availableTime = interval.end;
        }

        @Override
        public int compareTo(Room otherRoom){
            return this.availableTime - otherRoom.availableTime;
        }
    }

    public int minMeetingRooms(Interval[] intervals) {
        int numMeetingRoom = 0;
        Arrays.sort( intervals, new Comparator<Interval>(){
            @Override
            public int compare( Interval interval1, Interval interval2 ){
                return interval1.start - interval2.start;
            }
        });
        PriorityQueue<Room> pq = new PriorityQueue<>();
        for( Interval meeting : intervals ){
            Room room = pq.peek();
            if( room == null || room.availableTime > meeting.start ){
                room = new Room();
                room.add(meeting);
                pq.add(room);

            }
            else{
                room = pq.poll();
                room.add(meeting);
                pq.add(room);
            }
        }
        return pq.size();
    }
}
