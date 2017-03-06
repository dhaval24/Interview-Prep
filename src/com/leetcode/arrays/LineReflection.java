package com.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dhaval on 2/19/2017.
 *
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

 Example 1:
 Given points = [[1,1],[-1,1]], return true.

 Example 2:
 Given points = [[1,1],[-1,-1]], return false.

 Follow up:
 Could you do better than O(n2)?


 Algorithm : The question asks us to find if there is a reflection plane around the Y-axis and if we see intutively if there is
 one it would be the one which is the middle of two farthest point respective of x-axis. This can be done in a very efficient way
 using a HashSet and then problem resembles to a 2-sum problem

 In the first pass we find the two farthest point wrt X-axis in the given input and add every point in the hashset by composing a string of
 the points

 we then calculate the sum of X-coordinates of the two farthest points

 We then make one more pass over the points array to see if the complementary points lie already in the hashset. Complementary points are
 determined by subtracting the X-coordinate from the sum.
 */
public class LineReflection {

    public boolean isReflectedAlongY(int[][] points) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < points.length; i++) {
            max = Math.max(max, points[i][0]);
            min = Math.min(min, points[i][0]);
            String s = points[i][0] +"," + points[i][1];
            set.add(s);
        }

        int partition = max + min;
        for (int i = 0; i < points.length; i++) {
            String s = (partition - points[i][0]) +"," + points[i][1];
            if (!set.contains(s)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {-1,1}};
        System.out.println(new LineReflection().isReflectedAlongY(points));
    }
}
