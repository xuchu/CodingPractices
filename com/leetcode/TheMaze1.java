package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze1 {
    private Boolean foundPath = false;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int mazeRowSize = maze.length;
        int mazeColumnSize = maze[0].length;
        char[][] visited = new char[mazeRowSize][mazeColumnSize];
        return roll(start, maze, visited, destination);
    }

    private Boolean roll(int[] start, int[][] maze, char[][] visited, int[] destination){
        visited[start[0]][start[1]] = 1;
        rollOnDirection(start, Direction.LEFT, maze, visited, destination);
        rollOnDirection(start, Direction.RIGHT, maze, visited, destination);
        rollOnDirection(start, Direction.TOP, maze, visited, destination);
        rollOnDirection(start, Direction.BOTTOM, maze, visited, destination);
        return foundPath;
    }

    private void rollOnDirection(int[] start, Direction direction, int[][] maze, char[][] visited, int[] destination){
        if( foundPath ){
            return;
        }
        int[] nextPos = findNextBallPosition(start, direction, maze);
        if( isDestination(nextPos, destination) ){
            foundPath = true;
            return;
        }
        if( visited[nextPos[0]][nextPos[1]] == 1 ){
            return;
        }
        visited[nextPos[0]][nextPos[1]] = 1;
        rollOnDirection(nextPos, Direction.LEFT, maze, visited, destination);
        rollOnDirection(nextPos, Direction.RIGHT, maze, visited, destination);
        rollOnDirection(nextPos, Direction.TOP, maze, visited, destination);
        rollOnDirection(nextPos, Direction.BOTTOM, maze, visited, destination);
    }

    private boolean isDestination(int[] currentPos, int[] destination){
        return currentPos[0] == destination[0] && currentPos[1] == destination[1];
    }

    private int[] findNextBallPosition(int[] pos, Direction direction, int[][] maze){
        int[] currentPos = pos;
        int[] nextPos = null;
        while( (nextPos = calculateNextPosition(currentPos, direction)) != null && !isWall(maze, nextPos) ){
            currentPos = nextPos;
        }
        return currentPos;
    }

    private int[] calculateNextPosition(int[] pos, Direction direction){
        int[] nextPos = null;
        switch (direction){
            case LEFT:
                nextPos = new int[]{pos[0], pos[1] - 1};
                break;
            case RIGHT:
                nextPos = new int[]{pos[0], pos[1] + 1};
                break;
            case TOP:
                nextPos = new int[]{pos[0] - 1, pos[1]};
                break;
            case BOTTOM:
                nextPos = new int[]{pos[0] + 1, pos[1]};
                break;
        }
        return nextPos;
    }

    private boolean isWall(int[][] maze, int[] currentPos){
        int mazeRows = maze.length;
        int mazeColumns = maze[0].length;
        if(  currentPos[0] < 0 || currentPos[0] >= mazeRows || currentPos[1] < 0 || currentPos[1] >= mazeColumns ){
            return true;
        }
        if( maze[currentPos[0]][currentPos[1]] == 1 ){
            return true;
        }
        return false;
    }
}
