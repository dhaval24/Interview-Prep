package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dhaval on 8/21/2016.
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 1) return res;
        permute(nums, res, new ArrayList<>(), 0);
        return res;
    }

    private void permute(int[] nums, List<List<Integer>> res, List<Integer> temp, int indx) {

        int len = nums.length;
        if (temp.size() == len) {
            res.add(temp);
            return;
        }

        for (int i = 0; i <= temp.size() ; i++) {
            List<Integer> newTemp = new ArrayList<>(temp);
            newTemp.add(i, nums[indx]);
            permute(nums, res, newTemp, indx+1);
        }
    }

    private List<List<Integer>> permuteIter(int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        res.add(new ArrayList<>());
        for (int n : nums) {
            int size = res.size();
            while(size > 0) {
                List<Integer> r = res.pollFirst();
                for (int i = 0; i <= r.size(); i++) {
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

        int[] nums = {2,2,1,1};
        System.out.println(new Permutations().permuteIter(nums));

    }
}
