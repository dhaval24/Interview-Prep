package com.leetcode.arrays;

import java.util.Arrays;

/**
 * Created by Dhaval on 3/4/2017.
 *
 * Total Accepted: 9466
 Total Submissions: 17369
 Difficulty: Medium
 Contributors: Admin
 Assume you have an array of length n initialized with all 0's and are given k update operations.
 Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
 Return the modified array after all k operations were executed.
 Example:
 Given:
 length = 5,
 updates = [
 [1,  3,  2],
 [2,  4,  3],
 [0,  2, -2]
 ]

 Output:

 [-2, 0, 3, 5, 3]

 Algorithm : We initialze the output array with all 0's.
 1. Whenever we get an update query we update the ith index in the result array with +update and j+1th index if it exist
 in the result array with -update.
 2. We traverse across the result array maintaining the running sum and then fill the array indices with the running sum
 and return the result array
 */
public class RangeAddition {

    public int[] getModifiedArray(int length, int[][] updates) {
        if (length < 0 || updates == null) throw new IllegalArgumentException();
        int[] result = new int[length];
        for (int i = 0; i < updates.length; i++) {
            result[updates[i][0]] += updates[i][2];
            if (updates[i][1] + 1 < length) {
                result[updates[i][1]+1] += -updates[i][2];
            }
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += result[i];
            result[i] = sum;
        }
        return result;
    }

    public static void main(String[] args) {
        int len = 5;
        int[][] updates = { {1,  3,  2},{2,  4,  3},{0,  2, -2}};
        RangeAddition ra = new RangeAddition();
        System.out.println(Arrays.toString(ra.getModifiedArray(5, updates)));
    }
}
