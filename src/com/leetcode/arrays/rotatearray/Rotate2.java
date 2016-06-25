package com.leetcode.arrays.rotatearray;

import java.util.Arrays;

/**
 * Created by Dhaval on 6/22/2016.
 * Given an array rotate it k times towards its right
 *
 * Sol : O(n) time constant space approach using 3 reverse
 * Reverse a - k, k+1 - length -1 and then reverse entire array
 */
public class Rotate2 {

    public void rotate(int[] nums, int k) {

        k = k % nums.length;
        reverse(nums, 0, k);
        reverse(nums, k + 1, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }

    private void reverse(int[] nums, int start, int end) {

        while (start <= end) {
            swap(nums, start, end);
            start++;
            end--;
        }

    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        Rotate2 r = new Rotate2();
        r.rotate(nums, 2);
    }
}
