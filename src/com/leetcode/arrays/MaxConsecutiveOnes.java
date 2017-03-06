package com.leetcode.arrays;

/**
 * Created by Dhaval on 2/25/2017.
 */
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {

        if (nums == null) throw new NullPointerException();
        if (nums.length == 1) return nums[0] == 1? 1: 0;
        int maxOnes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int j = i;
            while (i < nums.length && nums[i] == 1) {
                i++;
            }
            maxOnes = Math.max(maxOnes, i - j);
        }
        return maxOnes;

    }

    public static void main(String[] args) {
        System.out.println(new MaxConsecutiveOnes().findMaxConsecutiveOnes(new int[] {1,0,1,1,0,1}));
    }
}
