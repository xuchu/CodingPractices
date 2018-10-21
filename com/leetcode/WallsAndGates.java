package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        int rows = rooms.length;
        if( rows == 0 ){
            return;
        }
        int columns = rooms[0].length;
        if( columns == 0 ){
            return;
        }
        for( int i = 0; i < rows; i++ ){
            for( int j = 0; j < columns; j++ ){
                if( rooms[i][j] == 0 ){
                    //nice, start from here
                    searchAndMarkDistances( rooms, i, j );
                }
            }
        }
    }

    private void searchAndMarkDistances(int[][] rooms, int i, int j){
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{i, j});
        while( !queue.isEmpty() ){
            Integer[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            int val = rooms[x][y];
            processPosition(x-1, y, val, rooms, queue);
            processPosition(x+1, y, val, rooms, queue);
            processPosition(x, y-1, val, rooms, queue);
            processPosition(x, y+1, val, rooms, queue);
        }
    }

    private void processPosition(int i, int j, int val, int[][] rooms, Queue<Integer[]> queue){
        if( isValidRoom(rooms, i, j) ){
            if( rooms[i][j] > 0 || rooms[i][j] >  val + 1 ){
                rooms[i][j] = val + 1;
                queue.add( new Integer[]{i, j});
            }
        }
    }

    private Boolean isValidRoom(int[][] rooms, int i, int j){
        int rows = rooms.length;
        int columns = rooms[0].length;
        if( i < 0 || i == rows || j < 0 || j == columns ){
            return false;
        }
        return rooms[i][j] > 0;
    }
}
