package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created by appleuser on 8/31/16.
 */

public class PerfectRectangle {
    private class Event implements Comparable<Event> {
        int time;
        int[] rect;

        public Event(int time, int[] rect) {
            this.time = time;
            this.rect = rect;
        }
        //PriorityQueue allows duplicates.
        public int compareTo(Event that) {
            if (this.time != that.time){
                return this.time - that.time;
            }
            else{
                return this.rect[0] - that.rect[0];
            }
        }
    }

    private boolean isOverlapping( int[] rect1, int[] rect2 ){
        boolean notOverlapping = (rect1[0] >= rect2[2])||(rect1[2]<=rect2[0])||(rect1[3]<=rect2[1])||(rect1[1]>=rect2[3]);
        return !notOverlapping;
    }

    public boolean isRectangleCover(int[][] rectangles) {
        PriorityQueue<Event> pq = new PriorityQueue<Event> ();
        // border of y-intervals
        int sumArea = 0;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int[] rectangle : rectangles) {
            Event e1 = new Event(rectangle[0], rectangle);
            Event e2 = new Event(rectangle[2], rectangle);
            pq.add(e1);
            pq.add(e2);

            int leftBottomX = rectangle[0];
            int leftBottomY = rectangle[1];
            int rightTopX = rectangle[2];
            int rightTopY = rectangle[3];
            minX = Math.min( minX, leftBottomX );
            minY = Math.min( minY, leftBottomY);
            maxX = Math.max( maxX, rightTopX);
            maxY = Math.max( maxY, rightTopY);
            sumArea += (rightTopX-leftBottomX) * (rightTopY-leftBottomY);
        }

        int area = (maxX - minX) * (maxY - minY);
        if( area != sumArea ){
            return false;
        }

        TreeSet<int[]> set = new TreeSet<int[]> (new Comparator<int[]>() {
            @Override
            public int compare (int[] rect1, int[] rect2) {
               return rect1[1] - rect2[1];
            }
        });

            while (!pq.isEmpty()) {
                Event e = pq.poll();
                int time = e.time;
                int[] rect = e.rect;
                if (time == rect[0]) {
                    if (!set.add(rect)){
                        return false;
                    }
                    int[] pre = set.higher(rect);
                    if( pre != null ){
                        if( isOverlapping(pre, rect) ){
                            return false;
                        }
                    }

                    int[] succ = set.lower(rect);
                    if( succ != null ){
                        if( isOverlapping(rect, succ) ){
                            return false;
                        }
                    }

                }
                else if( time == rect[2] ){
                    set.remove(rect);
                }
            }
        return true;
    }
}
