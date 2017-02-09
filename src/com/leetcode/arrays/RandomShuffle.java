package com.leetcode.arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Dhaval on 11/14/2016.
 */
public class RandomShuffle {

    private int [] nums;
    private int[] org;

    public RandomShuffle(int[] nums) {
        this.nums = nums;
        org = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            org[i] = nums[i];
        }
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return org;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int len = nums.length;
        int min = 0;
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            int index = random.nextInt((i - min) + 1) + min;
            swap(nums, index, i);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        RandomShuffle obj = new RandomShuffle(nums);
        int[] param_1 = obj.reset();
        int[] param_2 = obj.shuffle();
        System.out.println(Arrays.toString(param_1));
        System.out.println(Arrays.toString(param_2));
    }

}
