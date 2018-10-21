import com.leetcode.PerfectRectangle;

import java.util.*;


class Solution {
    public boolean isRectangleCover(int[][] rectangles) {

        TreeSet<int[]> set = new TreeSet<int[]>(new Comparator<int[]>(){
            public int compare(int[] rect1, int[] rect2){
                boolean notOverlapping = (rect1[0] >= rect2[2])||(rect1[2]<=rect2[0])||(rect1[3]<=rect2[1])||(rect1[1]>=rect2[3]);
                if(!notOverlapping){
                    System.out.println("Overlapping");
                    return 0;
                }
                else{
                    System.out.println("Not overlapping");
                }
                for(int i = 0; i < 4; i++){
                    if(rect1[i] > rect2[i]) return 1;
                    if(rect1[i] < rect2[i]) return -1;
                }
                return 0;
            }
        });


        int xmin = Integer.MAX_VALUE, xmax = Integer.MIN_VALUE;
        int ymin = Integer.MAX_VALUE, ymax = Integer.MIN_VALUE;
        int area = 0;
        for(int[] rec : rectangles){
            xmin = Math.min(xmin, rec[0]);
            ymin = Math.min(ymin, rec[1]);
            xmax = Math.max(xmax, rec[2]);
            ymax = Math.max(ymax, rec[3]);
            if(set.add(rec) == false) {
                return false;
            }
            else{
                area += (rec[2]-rec[0])*(rec[3]-rec[1]);
            }
        }
        return area == (xmax-xmin)*(ymax-ymin);
    }
}

public class Main {
    public static void main(String[] args) {

        List<Integer>[] graph = new List[4];
        for( int i = 0; i < 4; i++){
            graph[i] = new LinkedList<>();
        }
        System.out.println(graph.length);

    }
}
