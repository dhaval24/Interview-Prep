package com.leetcode.arrays;

import java.util.Random;

/**
 * Created by Dhaval on 11/12/2016.
 */
public class KLargest {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) return nums[0];
        int maxNo = len - k ;
        int lo = 0;
        int hi = len - 1;
        while (hi > lo) {
            int j = partition(nums, lo, hi);
            if (j > maxNo) hi = j - 1;
            else if (j < maxNo) lo = j + 1;
            else return nums[maxNo];
        }
        return nums[maxNo];
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (nums[++i] < nums[lo])
                if (i == hi) break;
            while (nums[lo] < nums[--j])
                if (j == lo) break;
            if (i >= j) break;
            swap(nums, i , j);
        }
        swap(nums, lo, j);
        return j;
    }

    private void randomShuffle(int[] nums) {
        Random r = new Random();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            swap(nums, i, r.nextInt(i+1));
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new KLargest().findKthLargest(new int[]{2,1}, 1));
    }
}
