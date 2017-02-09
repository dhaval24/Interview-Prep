package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements that appear twice in this array.

 Could you do it without extra space and in O(n) runtime?
 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [2,3]
 * Created by Dhaval on 11/14/2016.
 *
 * Algorithm: Given the constarin that values of array lies in 1 <= a[i] <= n, this means that array has all the values between (0-n]
 * Now we iterate the array over from 0-n and see if the value at nums[index] = nums[i]-1 (since it is a 0 index array) is less than 1
 * then that index(whose actual value is index+1) has been previously found in the array and we add it to the result else we negate the value at nums[index]. If we reach
 * the end of the array and find no values that are already negated then there are no duplicates
 */
public class FindAllDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int index = Math.abs(nums[i])-1; //getting 0-n index
            if (nums[index] < 1) {
                result.add(index+1);
            }
            nums[index] = -nums[index]; //negating the value at that index to mark that value as visited
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FindAllDuplicates().findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }
}
