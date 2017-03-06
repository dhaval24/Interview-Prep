package com.leetcode.dynamic;

import java.util.Arrays;

/**
 * Created by Dhaval on 2/20/2017.
 */
public class LongestIncreasingSubsequence {

    public int longestIncreasingMethodI(int[] nums) {

        if (nums ==  null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int[] buffer = new int[nums.length];
        Arrays.fill(buffer, 1);
        int i = 0;
        int j = 0;
        int len = nums.length;
        int maxLen = Integer.MIN_VALUE;
        while (j < len) {
            while (i < j) {
                if (nums[j] > nums[i]) {
                    buffer[j] = Math.max(buffer[j], buffer[i]+1);
                }
                i++;
            }
            maxLen = Math.max(maxLen, buffer[j]);
            i = 0;
            j++;
        }
        return maxLen;
    }

    public int longestIncreasingMethodII(int[] nums) {

        if (nums ==  null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int[] T = new int[nums.length];
        int[] R = new int[nums.length];
        int len = 0;
        Arrays.fill(R, -1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[T[0]] > nums[i]) {
                T[0] = i;
            }
            else if (nums[T[len]] < nums[i]) {
               len++;
               T[len] = i;
               R[T[len]] = T[len-1];
            }
            else {
                int index = ceilIndex(nums, T, len, nums[i]);
                T[index] = i;
                R[T[index]] = T[index-1];
            }
        }
        return len + 1;
    }

    private int ceilIndex(int[] nums, int[] T, int len, int target) {
        int start = 0;
        int end = len;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (middle < len && nums[T[middle]] < target && target <= nums[T[middle+1]]) {
                return middle + 1;
            }
            else if (nums[T[middle]] < target) {
                start = middle + 1;
            }
            else {
                end = middle - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] inp = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9};
        System.out.println(new LongestIncreasingSubsequence().longestIncreasingMethodII(inp));
        System.out.println(new LongestIncreasingSubsequence().longestIncreasingMethodI(inp));
    }
}
