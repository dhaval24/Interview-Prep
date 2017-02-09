package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Dhaval on 11/12/2016.
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {

        int len = nums.length;
        String[] inp = new String[len];
        for (int i = 0; i < len; i++) {
            inp[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(inp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return ((o1+o2).compareTo(o2+o1));
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            sb.append(inp[i]);
        }
        System.out.println(Arrays.toString(inp));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
