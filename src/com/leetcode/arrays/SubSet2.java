package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Dhaval on 7/20/2016.
 *
 */
public class SubSet2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), ret);
        return ret;
    }

    private void dfs(int[] nums, int idx, List<Integer> path, List<List<Integer>> ret) {
        ret.add(path);
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }
            List<Integer> p = new ArrayList<>(path);
            p.add(nums[i]);
            dfs(nums, i + 1, p, ret);
        }
    }
    public List<List<Integer>> subsetsWithDup1(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;

        if (len < 1) return result;

        result.add(new ArrayList<>());

        for(int i = 0; i < len; i++) {

            List<List<Integer>> tempResult = new ArrayList<>();
            for (List<Integer> iter : result) {
                List<Integer> temp = new ArrayList<>(iter);
                temp.add(nums[i]);
                if(!result.contains(temp))
                tempResult.add(temp);
            }
            result.addAll(tempResult);
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(new SubSet2().subsetsWithDup1(new int[] {1,2,3}));
    }
}
