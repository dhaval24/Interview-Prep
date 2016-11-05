package com.leetcode.arrays;

import java.util.Arrays;

/**
 * Created by Dhaval on 10/21/2016.
 */
public class BuySellStock1 {

    public int maxProfit(int[] prices) {

        int len = prices.length;
        if (len == 0) return 0;
        int maxProfit = Integer.MIN_VALUE;
        int minSoFar = Integer.MAX_VALUE;
        int[] indices = new int[2];
        for (int i = 0; i < len; i++) {
            if (minSoFar > prices[i]) {
                minSoFar = prices[i];
                indices[0] = i;
            }
            if (maxProfit < (prices[i] - minSoFar)) {
                maxProfit = prices[i] - minSoFar;
                indices[1] = i;
            }
        }
        System.out.println(Arrays.toString(indices));
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new BuySellStock1().maxProfit(new int[]{100, 97, 95,94, 93, 90}));
    }
}
