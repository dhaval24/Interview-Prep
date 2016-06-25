package com.leetcode.arrays;

import java.util.Arrays;

/**
 * Created by Dhaval on 6/23/2016.
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array
 *
 * Sol : O(n) solution with n+m space. Using the merge routine, to enter elements from
 * the largest to smallest in the first array
 */
public class MergeSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int index1 = m - 1;
        int index2 = n - 1;
        int index = nums1.length - 1;
        while(index1 >= 0 && index2 >= 0) {
            if(nums1[index1] > nums2[index2]) {
                nums1[index] = nums1[index1];
                index1--;
            }
            else {
                nums1[index] = nums2[index2];
                index2--;
            }
            index--;
        }

        if(index2 >= 0) {
            while(index >= 0) {
                nums1[index--] = nums2[index2--];
            }
        }

        System.out.println(Arrays.toString(nums1));
    }

    private void swap(int[] nums1, int[] nums2, int index1, int index2) {

        int temp = nums1[index1];
        nums1[index1] = nums2[index2];
        nums2[index2] = temp;

    }

    public static void main(String[] args) {

        MergeSortedArrays m = new MergeSortedArrays();
        int[] nums1 = new int[1];
        int[] nums2 = {};
        nums1[0] = 1;
//        nums1[1] = 3;
//        nums1[2] = 5;
//        nums1[3] = 7;
        m.merge(nums1, 1, nums2, 0);

    }
}
