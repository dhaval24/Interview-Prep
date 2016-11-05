package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhaval on 8/4/2016.
 *
 *  Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:

 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.

 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is: [[7],[2, 2, 3]]

 Solution: This is a simple backtracking algorithm:
 1. Try adding the number int the temp list as many times until the cummulative sum is greater than or equal to the target.
 2. If the sum equals target then add the temp list to the final result
 3. If the sum is greater then the target then return result to the function.
 4. Remove the last element from the temp list and increment the index to take the next number in the set provided.
 5. This is O(2 ^ n)) algorithm where the n is the total numbers in the set.
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null) return result;
        int len = candidates.length;
        if (len < 1) return result;
        return combinationSum(candidates, result, new ArrayList<>(), target, 0, 0);
    }

    private List<List<Integer>> combinationSum(int[] nums, List<List<Integer>> result,
                                              List<Integer> temp, int target, int sum, int indx) {


        if (sum == target) {
            List<Integer> temp1 = new ArrayList<>(temp);
            if (!result.contains(temp1))
            result.add(temp1);
            return result;
        }
        if (sum > target) return result;

        for (int i = indx; i < nums.length; i++) {

            temp.add(nums[i]);
            combinationSum(nums, result, temp, target, sum+nums[i], indx);
            temp.remove(temp.size()-1);
            indx++;
        }
        return result;
    }


    public static void main(String[] args) {

        System.out.println(new CombinationSum().combinationSum(new int[] {10,1,2,7,6,1,5}, 8));
    }
}
