package com.leetcode.arrays.PeakElement;

/**
 * Created by Dhaval on 7/11/2016.
 * Created by Dhaval on 7/11/2016.
 * A peak element is an element that is greater than its neighbors.
  Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
  The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
  You may imagine that num[-1] = num[n] = -∞.
  For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
  Algorithm:
    scan through entire array. isPeak() returns if the element at index i is peak or not.
    isPeak() uses a loop from index-1 to index+1 excluding i = index and returns false if nums[i] >= nums[index]
 */
public class PeakElementLinear {
    public int findPeakElement(int[] nums) {

        int len = nums.length;
        if(len < 1) return -1;
        for (int i = 0; i < len; i++) {
            if(isPeak(nums, i)) {
                return i;
            }
        }

        return -1;
    }

    private boolean isPeak(int[] nums, int index) {
        for(int i = index-1; i<=index+1; i++) {
            if(i >= 0 && i!=index && i < nums.length) {
                if(nums[i] >= nums[index]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PeakElementLinear().findPeakElement(new int[]{1,2,3,1}));
    }
}
