package com.leetcode.arrays;

/**
 * Created by Dhaval on 8/3/2016.
 */
public class SearchInRotatedArray {

    public int search(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) return mid;

            if (nums[lo] <= nums[mid]) {
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return nums[lo] == target ? lo : -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedArray().search(new int[] {3,4,5,6,1,2}, 2));
    }
}
