package com.leetcode.arrays;

/**
 * Created by Dhaval on 7/30/2016.
 * Alogrithm : 1. Iterate through the array from index 1 to length
 * 2. Check if the current elemet is maximum till now or adding current to maximum till now makes maximum
 * 3. Update result to maximum current result and updated maximum
 * 4. Return result
 * 5. O(n) time and O(1) space algorithm 
 */
public class MaxSumSubArray {

    public int getMaxSum(int[] nums) {

        int len = nums.length;
        if (len < 1) return 0;
        if (len < 2) return nums[0];
        int max = nums[0];
        int result = nums[0];
        for (int i = 1; i < len; i++) {
            int curr = nums[i];
            max = Math.max(curr, max+curr);
            //curr = max;
            result = Math.max(result, max);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSumSubArray().getMaxSum(new int[] {2,1,-3,4,-1,2,1,-5,4}));
    }
}
