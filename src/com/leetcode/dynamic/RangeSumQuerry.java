package com.leetcode.dynamic;

/**
 * Created by Dhaval on 8/13/2016.
 */
public class RangeSumQuerry {

    private int[] buffer;

    public RangeSumQuerry(int nums[]) {

        int len = nums.length;
        buffer = new int[len];
        int curr = 0;
        for (int i = 0; i < len; i++) {
            curr += nums[i];
            buffer[i] =  curr;
        }
    }

    public int sumRange(int i, int j){

        if (i == 0) {
            return buffer[j];
        }
        else {
            return buffer[j]-buffer[i-1];
        }
    }

    public static void main(String[] args) {

        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQuerry rangeSumQuerry = new RangeSumQuerry(nums);
        System.out.println(rangeSumQuerry.sumRange(0,2));
        System.out.println(rangeSumQuerry.sumRange(2,5));
        System.out.println(rangeSumQuerry.sumRange(0,5));


    }
}
