package com.leetcode.arrays;

/**
 * Created by Dhaval on 9/14/2016.
 */
public class TrappingRainWater {

    public int trap(int[] A) {

        int len = A.length;
        int left = 0;
        int right = len - 1;
        int trapWater = 0;
        int maxLeftRightHeight = 0;

        while (left < right) {
            if (A[left] < A[right]) {
                maxLeftRightHeight = Math.max(maxLeftRightHeight, A[left]);;
                trapWater += maxLeftRightHeight - A[left];
                left++;
            }
            else {
                maxLeftRightHeight = Math.max(maxLeftRightHeight, A[right]);
                trapWater += maxLeftRightHeight - A[right];
                right--;
            }

        }
        return trapWater;
    }

    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
