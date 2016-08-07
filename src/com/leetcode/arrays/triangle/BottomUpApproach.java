package com.leetcode.arrays.triangle;

import java.util.List;

/**
 * Created by Dhaval on 8/1/2016.
 * Algorithm : This is a bottom up approach. We start from the last row of traingle and move upwards.
 * Essentially our last update gives us the min path sum. We update the path sum as we go up.
 * We maintain one list which is of size num of rows in triangle + 1
 * Moving from down to up initially the buffer will be filled with all the elements of the last row
 * Then again the min path till now in the second last row would be buffer[j] , buffer[j+1] + currentElement
 * The last update would be only of the 0th element and rest all values in the buffer are garbage
 * We return the first value of the buffer array
 *
 *
 */
public class BottomUpApproach {

    public int minimumTotal(List<List<Integer>> triangle) {

        int[] buffer = new int[triangle.size() + 1];
        int len = triangle.size();
        for (int i = len - 1; i >= 0; i--) {
            List<Integer> temp = triangle.get(i);
            int len1 = temp.size();
            for (int j = 0; j < len1; j++ ) {
                buffer[j] = Math.min(buffer[j], buffer[j+1]) + temp.get(j);
            }
        }
        return buffer[0];
    }

}
