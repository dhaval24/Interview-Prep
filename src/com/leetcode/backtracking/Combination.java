package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhaval on 8/21/2016.
 */
public class Combination {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        combine(n,k, 0, res, new ArrayList<>());
        return res;
    }

    private void combine(int n, int k, int index, List<List<Integer>> res, List<Integer> temp) {

        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }

        else {
            for (int i = index+1; i <= n ; i++) {

                temp.add(i);
                index++;
                combine(n, k, index, res, temp);
                temp.remove(temp.size()-1);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new Combination().combine(4,2));
    }
}
