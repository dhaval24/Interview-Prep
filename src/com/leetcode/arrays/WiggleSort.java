package com.leetcode.arrays;

import java.util.Arrays;

/**
 * Created by Dhaval on 12/5/2016.
 */
public class WiggleSort {

        public void wiggleSort(int[] nums) {

            if (nums == null) {
                throw new NullPointerException();
            }

            int len = nums.length;
            if (len == 1) {
                return;
            }

            boolean flag = false;

            for (int i = 0; i < len - 1; i++) {

                if (! flag) {
                    if (nums[i] > nums[i+1]) {
                        swap(nums, i , i+1);
                        flag = true;
                    }
                }
                else {
                    if (nums[i] < nums[i+1]) {
                        swap(nums, i ,i+1);
                        flag  = false;
                    }
                }
            }



            System.out.println(Arrays.toString(nums));

        }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] A = {3,5,2,1,6,4};
        new WiggleSort().wiggleSort(A);
    }

}
