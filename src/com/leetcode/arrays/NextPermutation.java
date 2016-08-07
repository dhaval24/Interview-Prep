package com.leetcode.arrays;

import java.util.Arrays;

/**
 * Created by Dhaval on 7/25/2016.
 */
public class NextPermutation {

    public void getNextPermutation(int[] nums) {

        int len = nums.length;

        if (len < 2) return; // If array is of length 1 no processing needed
        int index = 0;
        // Start in reverse order and find first element which is smaller than the ith element.
        //This is the element to be maximized
        for (int i = len-1; i >0; i--) {
            if (nums[i] > nums[i-1]) {
                index = i;
                break;
            }
        }
        //If the value of index remains to be 0 then probably the arrray is reverse sorted and in this
        //case return the sorted array acc to problem definition
        if (index == 0) {
            int start = 0;
            int end = len - 1;
            while (start <= end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }
        // Else find the least element greater than the element at Index-1. Since the array from index to len-1
        //is reverse sorted we can start from end and compare. Swap the least greatest element with the element
        //at index-1 and reverse the array from index - len
        else {
            for (int i = len-1; i >= index; i--) {
                if (nums[i] > nums[index-1]) {
                    swap(nums, i, index-1);
                    break;
                }
            }
            int start = index;
            int end = len - 1;
            while (start <= end) {
                swap(nums, start, end);
                start++;
                end--;
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
        new NextPermutation().getNextPermutation(new int[] {1,3,4,2});
    }

}
