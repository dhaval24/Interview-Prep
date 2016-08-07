package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhaval on 7/25/2016.
 *
 * Given a set of distinct integers, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]

 Algorithm : 1. Initialize result with empty list
 2. We always iterate over the entire result and create a new list of list adding the next element
 of the array in it and then dumping the entire collection into the main result
 1st iteration
 []
 [1]
 2nd Iteration
 [2]
 [1,2]
 added in entire collection
 3 iteration
 [3]
 [1,3]
 [2,3]
 [1,2,3] added in entire collection
 */
public class Subset {

    public List<List<Integer>> getAllSubset(int[] nums) {

        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (len < 1) return result;

        result.add(new ArrayList<>());

        for(int i = 0; i < len; i++) {

            List<List<Integer>> tempResult = new ArrayList<>();

            for(List<Integer> iter : result) {

                List<Integer> temp = new ArrayList<>(iter);
                temp.add(nums[i]);
                tempResult.add(temp);
            }

            result.addAll(tempResult);
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(new Subset().getAllSubset(new int[] {1,2,3}));
    }
}
