package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhaval on 7/7/2016.
 *  Given a sorted integer array without duplicates, return the summary of its ranges.
 *  For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 *
 *  Algorithm : Expected runnning time O(n) space O(n)
 *  2 pointer approach
 *  1. If len < 1 return empty list
 *  2. Iterate through the array from index 1
 *  3. If difference between a[i] and a[i-1] is more than 1, insert into result, update start to new value = current index
 *  4. Else continue
 */
public class ArraySummaryRanges {

    public List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();
        int len = nums.length;
        if (len < 1) return result;
        int start = 0;
        for (int i = 1; i < len; i++) {
            if(nums[i] - nums[i-1] != 1) {
                insertValueInResult(result, nums, start, i-1);
                start = i;
            }
        }
        insertValueInResult(result, nums, start, len-1);
        return result;
    }

    private void insertValueInResult(List<String> result, int[] nums, int start, int end) {

        if(start != end) {
            result.add(nums[start] + "->" + nums[end]);
        }
        else{
            result.add(String.valueOf(nums[start]));
        }
    }

    public static void main(String[] args) {

        int[] nums = {1,2,4,5,7};
        System.out.println(new ArraySummaryRanges().summaryRanges(nums));
    }


}
