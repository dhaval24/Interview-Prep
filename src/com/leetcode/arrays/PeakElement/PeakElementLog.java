package com.leetcode.arrays.PeakElement;

/**
 * Created by Dhaval on 7/11/2016.
 * A peak element is an element that is greater than its neighbors.
   Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
   The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
   You may imagine that num[-1] = num[n] = -∞.
   For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

    Alogrithm: Use Binary search
    1. if nums[mid-1] < nums[mid] < nums[mid+1] -> This means peak element would be in mid+1 to end
    2. if nums[mid-1] > nums[mid] > nums[mid+1] -> This means peak element would be in start - mid-1
    3. if nums[mid-1] < nums[mid] > nums[mid+1] -> peak is mid
    4. if nums[mid-1] > nums[mid] < nums[mid+1] -> both the side has peak. We use mid+1 - end
    5. Corner cases - start+1 = end then if nums[start] > nums[end] start is the peak else end is the peak
    6. Termination condition - start == end i.e found peak which is start

 */
public class PeakElementLog {
    public int findPeakElement(int[] nums) {

        int len = nums.length;
        return findPeakHelper(nums, 0 , len-1);
    }

    private int findPeakHelper(int[] nums, int start, int end) {
        if(start == end) return start;
        else if (start + 1 == end ){
            if(nums[start] > nums[end]){
                return start;
            }
            return end;
        }

        else {
            int mid = start + (end - start)/2;
            if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]) {
                return mid;
            }
            else if(nums[mid-1] > nums[mid] && nums[mid] > nums[mid+1]) {
                return findPeakHelper(nums, start, mid - 1);
            }
            else {
                return findPeakHelper(nums, mid+1, end);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(new PeakElementLog().findPeakElement(new int[]{1,2,3,1}));
    }
}
