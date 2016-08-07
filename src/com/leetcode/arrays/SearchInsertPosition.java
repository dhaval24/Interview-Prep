package com.leetcode.arrays;

/**
 * Created by Dhaval on 8/2/2016.
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0

 Algorithm : Apply binary search
 1. If the nums[mid] == target then return mid;
 2. If nums[mid] > target then update end = mid -1;
 3. If nums[mid] < target then update start = mid + 1;

 In the end if the target is not in the array then if nums[start] < target then return start + 1
 else return start
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        int start = 0;

        if (nums == null) return -1;
        int len = nums.length;
        if (len < 1) return -1;

        int end = len - 1;
        int mid;
        while (start < end) {
            mid = start + (end - start)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;

        }

        if (nums[start] < target) return start + 1;
        return start;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInsertPosition().searchInsert(new int[] {1,3,5,6}, 4));
    }
}
