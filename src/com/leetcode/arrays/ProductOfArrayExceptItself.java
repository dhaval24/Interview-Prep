package com.leetcode.arrays;

import java.util.Arrays;

/**
 * Created by Dhaval on 7/7/2016.
 *  Given an array of n integers where n > 1, nums, return an array output such that output[i]
 *  is equal to the product of all the elements of nums except nums[i].
 *  Solve it without division and in O(n).
 *  For example, given [1,2,3,4], return [24,12,8,6].
 *
 *  Algorithm : Constant space (except output array) O(n) time
 *  1. Initialize the Output array with 1 and of length = length of input array
 *  2. Iterate through the original array in reverse direction upto index 1
 *  3. Multiply each value in the array and store it in the i-1 index in output array
 *  4. Iterate through the original array in forward direction, keep multiplication of elements until i-1
 *  5. Update the output array at i index with the value = multiplication of output array current value with value of current
 */
public class ProductOfArrayExceptItself {

    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;
        int[] output = new int[len];
        int curr = 1;
        for(int i = 0; i < len; i++) {
            output[i] = 1;
        }
        for (int i = len - 1; i > 0; i--) {
            curr *= nums[i];
            output[i-1] = curr;
        }
        curr = 1;
        for (int i = 1; i < len; i++) {
            curr *= nums[i-1];
            output[i] = output[i] * curr;
        }
        return output;

    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,0};
        System.out.println(Arrays.toString(new ProductOfArrayExceptItself().productExceptSelf(nums)));
    }
}
