package com.leetcode.arrays;

/**
 * Created by Dhaval on 8/9/2016.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int len = height.length;
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            for (int j = i-1; j >= 0; j--) {
                maxArea = Math.max(maxArea, Math.min(height[i],height[j])*(i - j));
            }

        }
        return maxArea;


    }

    public int maxAreaIIPointer(int[] height) {

        int len = height.length;
        int maxArea = 0;
        int left = 0;
        int right = len - 1;


        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left],height[right])*(right - left));
            if (height[left] < height[right] ) {
                left++;
            }
            else {
                right--;
            }
        }
        return maxArea;

    }

    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxAreaIIPointer(new int[]{3,4,2,3,4,5}));
    }
}
