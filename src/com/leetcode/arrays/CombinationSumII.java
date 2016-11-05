package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dhaval on 8/7/2016.
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null) return result;
        int len = candidates.length;
        if (len < 1) return result;
        Arrays.sort(candidates);
        return combinationSum2(candidates, result, new ArrayList<>(), target, 0, 0);
    }

    private List<List<Integer>> combinationSum2(int[] nums, List<List<Integer>> result,
                                                List<Integer> temp, int target, int sum, int indx) {


        if (sum == target) {
            List<Integer> temp1 = new ArrayList<>(temp);
            //Collections.sort(temp1);
            if (!result.contains(temp1))
                result.add(temp1);
            return result;
        }
        if (sum > target) return result;

        for (int i = indx; i < nums.length; i++) {

//            if (temp.size() > 0 && temp.get(temp.size()-1) > nums[i]){
//                continue;
//            }

            if (i > indx && nums[i] == nums[i-1]) continue;
            else {
                temp.add(nums[i]);
                combinationSum2(nums, result, temp, target, sum+nums[i], i+1);
                temp.remove(temp.size()-1);
            }

        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(new CombinationSumII().combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));

    }
}
