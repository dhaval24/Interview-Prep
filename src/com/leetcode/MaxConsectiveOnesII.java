package com.leetcode;

/**
 * Created by Dhaval on 2/25/2017.
 */
public class MaxConsectiveOnesII {

    public int maxConsecutiveOnesII(int[] nums) {
        int frontSum = 0, backSum = 0, maxSum = 0;
        for (int n : nums) {
            if (n == 0) {
                frontSum = backSum + 1;
                backSum = 0;
            }
            backSum += n;
            maxSum = Math.max(maxSum, frontSum + backSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new MaxConsectiveOnesII().maxConsecutiveOnesII(new int[] {1,1,1,1,1,0,0,0,1,0,1,1,0,1}));
    }
}
