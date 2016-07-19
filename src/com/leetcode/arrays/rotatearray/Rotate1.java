package com.leetcode.arrays.rotatearray;

import java.util.Arrays;

/**
 * Created by Dhaval on 6/22/2016.
 */
public class Rotate1 {

    public void rotate(int[] nums, int k) {
        if (nums.length == 0 || k % nums.length == 0) return;
        int start = 0, i = start, curNum = nums[i], count = 0;
        while (count < nums.length) {
            i = (i + k) % nums.length;
            int tmp = nums[i];
            nums[i] = curNum;
            if (i == start) {
                start++;
                i = start;
                curNum = nums[i];
            } else curNum = tmp;
            count++;
        }
        System.out.println(Arrays.toString(nums));

    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5};
        Rotate1 r = new Rotate1();
        double start = System.nanoTime();
        r.rotate(nums, 2);
        System.out.println(System.nanoTime() - start);
    }
}
