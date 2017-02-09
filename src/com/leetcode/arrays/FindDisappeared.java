package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhaval on 1/25/2017.
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements of [1, n] inclusive that do not appear in this array.

 Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

 Example:

 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [5,6]
 */
public class FindDisappeared {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null) throw new IllegalArgumentException();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) nums[val] = -nums[val];
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] >= 0) res.add(i+1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FindDisappeared().findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1}));
    }
}
