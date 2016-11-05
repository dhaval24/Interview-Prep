package com.leetcode.arrays;

/**
 * Created by Dhaval on 9/1/2016.
 */
public class DuplicateNumber {

    public int findDuplicate(int[] nums) {

        int len = nums.length;
        int curr = nums[0];
        for (int i = 1; i < len; i++) {
            curr = curr ^ (len-1);
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(new DuplicateNumber().findDuplicate(new int[] {1,2,3,4,2}));
    }
}
