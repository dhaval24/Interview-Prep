package com.leetcode.arrays;

/**
 * Created by Dhaval on 11/9/2016.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int a : nums) {
            xor ^= a;
        }
        return xor;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumber().singleNumber(new int[]{1,1,2,2,3}));
    }
}
