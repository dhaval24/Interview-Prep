package com.leetcode.arrays.triangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Dhaval on 8/1/2016.
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle

 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]

 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 This is a top down DP Approach with O(m) space where m is the total number of elements
 Formula : MinPath[i][j] = Math.min(MinPath[i-1][j], MinPath[i-1][j-1]) + array[i][j]
 Algo: If the input has only 1 list then return its only element as answer.
 Create a buffer List of size input list
 add the first inner list of the input inside the buffer.
 Start iterating over the input list from index 1 and calculate the buffer[i][j] using the above formula.
 Exception would be if j = 0 then the MinPath[i][j] = MinPath[i-1][j] + array[i][j]
 and if j == i-1 then MinPath[i][j] = MinPath[i-1][j-1] + array[i][j]
 The minimum element in the last row would be the solution
 */
public class TopDownApproach {

    public int minimumTotal(List<List<Integer>> triangle) {

        List<List<Integer>> buffer = new ArrayList<>();
        int len = triangle.size();
        int min = Integer.MAX_VALUE;
        if (len < 1) return 0;
        buffer.add(new ArrayList<>(triangle.get(0)));
        for (int i = 1; i < len; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int curr = triangle.get(i).get(j);
                if (j - 1 >= 0 && j <= i-1) {
                    int addition = Math.min(curr + buffer.get(i-1).get(j-1), curr+buffer.get(i-1).get(j));
                    temp.add(addition);

                }
                else if(j == 0) {
                    int addition = curr + buffer.get(i-1).get(0);
                    temp.add(addition);

                }
                else {
                    temp.add(curr + buffer.get(i-1).get(j-1));
                }
            }
            buffer.add(temp);
        }
        for(int num : buffer.get(len-1)) {
            min = Math.min(min, num);
        }
        return min;
    }

    public static void main(String[] args) {

        List<List<Integer>> input = new ArrayList<>();
        //enter elements in input list here
        System.out.println(new TopDownApproach().minimumTotal(input));
    }

}
