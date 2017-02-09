package com.leetcode.arrays;

/**
 * Created by Dhaval on 1/16/2017.
 */
public class SmallestRotatedSortedArray {

    public int findSmallest(int[] nums) {

        if (nums == null) throw new NullPointerException();
        int len = nums.length;
        int lo = 0;
        int hi = len - 1;
        while (lo < hi - 1) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid] <= nums[hi]) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        return nums[lo] < nums[hi] ? nums[lo] : nums[hi];
    }

    public int findLargest(int[] nums) {

        if (nums == null) throw new NullPointerException();
        int len = nums.length;
        int lo = 0;
        int hi = len - 1;
        while (lo < hi - 1) {
            int mid = lo + (hi - lo)/2;
            if (nums[lo] <= nums[mid]) {
                lo = mid;
            }
            else {
                hi = mid - 1;
            }
        }
        return nums[lo] > nums[hi] ? nums[lo] : nums[hi];
    }



    public static void main(String[] args) {
        int[] nums = {3,4,5,1,3};
        System.out.println(new SmallestRotatedSortedArray().findLargest(nums));
    }
}
