package com.leetcode.arrays;

/**
 * Created by Dhaval on 7/26/2016.
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.

 Algorithm :
 initialize the max, min and result as the first element
 Start iterating from 1 to len
 if num is less than 0 we swap minimum and maximum because a negative number decreases the larger number more than
 smaller number and hence this step
 Calculate the maximum of current number and maximum so far * current
 Similarly on the go calculate the minimum of current number and the minimum so far * current
 update the result as max of current max and result

 */
public class MaxProductSubArray {

    public int maxProduct(int[] nums) {

        int len = nums.length;
        if (len < 1) return 0;
        int max = nums[0];
        int min = nums[0];
        int result = max;
        for (int i = 1; i < len; i++) {

            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(new MaxProductSubArray().maxProduct(new int[] {-1,2,3,-4}));
    }
}
