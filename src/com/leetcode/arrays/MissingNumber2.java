package com.leetcode.arrays;

/**
 * Created by Dhaval on 2/25/2017.
 */
public class MissingNumber2 {

    public int missing(int[] nums) {
        int start = 0;
        int stop = 0;
        for (int num : nums) {
            start ^= num;
            start &= ~stop;
            stop ^= num;
            stop &= ~start;
        }
        return stop;
    }

    public static void main(String[] args) {
        System.out.println(new MissingNumber2().missing(new int[]{1,1,1,2,2,3,3,3}));
    }
}
