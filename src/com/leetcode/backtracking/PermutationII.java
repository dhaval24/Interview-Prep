package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Dhaval on 8/22/2016.
 */
public class PermutationII {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 1) return result;
        permuteUnique(nums, result, new ArrayList<>(), 0, new HashSet<>());
        return result;
    }

    private void permuteUnique(int[] nums, List<List<Integer>> result, List<Integer> temp, int indx, Set<List<Integer>> set) {

        int len = nums.length;
        if (temp.size() == len) {
            if(set.add(temp))
                result.add(temp);
            return;
        }

        for (int i = 0; i <= temp.size(); i++) {
            List<Integer> newTemp = new ArrayList<>(temp);
            newTemp.add(i, nums[indx]);
            permuteUnique(nums, result, newTemp, indx+1, set);
        }

    }

    private List<List<Integer>> permuteIIIter(int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        res.add(new ArrayList<>());
        for (int n : nums) {
            int size = res.size();
            while(size > 0) {
                List<Integer> r = res.pollFirst();
                for (int i = 0; i <= r.size(); i++) {
                    if(i > 0 && r.get(i-1) == n) break;
                    List<Integer> t = new ArrayList<>(r);
                    t.add(i, n);
                    res.add(t);
                }
                size--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(new PermutationII().permuteIIIter(nums));
    }
}
