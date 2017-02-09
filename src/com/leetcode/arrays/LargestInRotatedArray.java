package com.leetcode.arrays;

/**
 * Created by Dhaval on 1/3/2017.
 */
public class LargestInRotatedArray {

    public int findLargestInRotatedArray(int[] nums) {

        if (nums == null) throw new NullPointerException();
        if (nums.length == 1) return nums[0];

        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi - 1) {

            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return nums[mid];
            if (nums[lo] <= nums[mid]) {
                lo = mid;
            }
            else {
                hi = mid - 1;
            }
        }
        return nums[lo] < nums[hi] ? nums[hi] : nums[lo];
    }

    public static void main(String[] args) {
        int[] a1 = {1,2,3};
        int[] a2 = {2,3,1};
        int[] a3 = {3,1,2};

        LargestInRotatedArray l = new LargestInRotatedArray();
        System.out.println(l.findLargestInRotatedArray(a1));
        System.out.println( l.findLargestInRotatedArray(a2));
        System.out.println(l.findLargestInRotatedArray(a3));


    }
}
