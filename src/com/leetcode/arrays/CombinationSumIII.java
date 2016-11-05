package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhaval on 8/2/2016.
 */
public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();
        return combinationSum3(result, new ArrayList<>(), k, n, 1, 0);
    }

    private List<List<Integer>> combinationSum3(List<List<Integer>> result,
                                                List<Integer> temp, int k, int n, int indx, int currSum) {


        for (int i = indx; i <10; i++) {

            if (temp.size() == k) {
                if (currSum == n)
                    result.add(temp);
                return result;
            }

            List<Integer> curList = new ArrayList<>(temp);
            curList.add(i);
            if (currSum > n) break;
            combinationSum3(result, curList, k, n, i+1, currSum+i);
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(new CombinationSumIII().combinationSum3(3, 7));
    }
}
