package com.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dhaval on 1/24/2017.
 */
public class MaxSizeSubarraySumK {

    public int[] maxSubArrayLen(int[] nums, int k) {

        if (nums == null) throw new NullPointerException();
        if (nums.length == 1 && nums[0] != k) return new int[] {-1,-1};
        int max = 0;
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                max = i + 1;
                result[1] = i;
            }
            else if (map.containsKey(sum - k)) {
                if (i - map.get(sum - k) >= max) {
                    max = i - map.get(sum - k);
                    result[0] = map.get(sum - k) + 1;
                    result[1] = i;
                }
            }
            if (!map.containsKey(sum)) { //no overriding as we want only the left most index
                map.put(sum, i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MaxSizeSubarraySumK().maxSubArrayLen(new int[] {1,-1,5,-2,3}, 3)));
    }
}
