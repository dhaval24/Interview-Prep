package com.leetcode.arrays;

/**
 * Created by Dhaval on 6/17/2016.
 * Remove the targeted element from the array and return the length of
 * new array. Order of the elements can be changed
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
            int i = 0;
            int n = nums.length;
            while (i < n) {
                if (nums[i] == val) {
                    //replace by last element
                    nums[i] = nums[n - 1];
                    // reduce array size by one
                    n--;
                } else {
                    //move forward
                    i++;
                }
            }
            return n;
    }

    public static void main(String[] args) {

        int[] A = {3, 2, 2, 3};
        RemoveElement rm = new RemoveElement();
        System.out.println(rm.removeElement(A, 3));
    }
}
