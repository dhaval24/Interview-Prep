package com.leetcode.arrays;

import java.util.Arrays;

/**
 * Created by Dhaval on 8/8/2016.
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {

        int[] range = new int[2];
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        int index = -1;
        while (start <= end) {

            int mid = start + (end - start)/2;
            if (nums[mid] == target) {
                index = mid;
                break;
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        if (index == -1) {
            range[0] = -1;
            range[1] = -1;
        }
        else {
            range[0] = getLeftRange(nums, 0, index, target);
            range[1] = getRightRange(nums, index, nums.length - 1, target);
        }
        System.out.println(Arrays.toString(range));
        return range;

    }

    private int getLeftRange(int[] nums, int start, int end, int target) {

        while (start >= 0 && start <= end ) {

            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }

        }
        return start;
    }

    private int getRightRange(int[] nums, int start, int end, int target) {

        while (start < nums.length && start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return end;
    }

    public static void main(String[] args) {

        new SearchRange().searchRange(new int[] {5,4,4,4,6}, 4);
    }
}
