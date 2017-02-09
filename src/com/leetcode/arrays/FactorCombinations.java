package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhaval on 2/7/2017.
 */
public class FactorCombinations {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        return getFactors(n, result, new ArrayList<>(), 2);
    }

    private List<List<Integer>> getFactors(int n,  List<List<Integer>> result, List<Integer> temp, int start) {
        if (n <= 1) {
            if (temp.size() > 1)
                result.add(new ArrayList<>(temp));
            return result;
        }

        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                temp.add(i);
                getFactors(n/i, result, temp, i);
                temp.remove(temp.size() - 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FactorCombinations().getFactors(12));
    }
}
