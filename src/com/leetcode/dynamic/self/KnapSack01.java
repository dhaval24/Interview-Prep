package com.leetcode.dynamic.self;

/**
 * Created by Dhaval on 8/14/2016.
 */
public class KnapSack01 {

    public int maxValue(int[] values, int[] weights, int maxWeight) {

        int[][] dp = new int[weights.length][maxWeight+1];
        int m = dp.length;
        int n = dp[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (i == 0) {
                    if (j - weights[i] >= 0) {
                        dp[i][j] = values[i];
                    }
                }
                else {
                    if (j - weights[i] >= 0) {
                        dp[i][j] = Math.max(values[i]+dp[i-1][j-weights[i]], dp[i-1][j]);
                    }
                    else {
                        dp[i][j] = dp[i-1][j];
                    }
                }

            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {

        int[] weights = {3,1,5,4};
        int[] val = {4,1,7,5};
        System.out.println(new KnapSack01().maxValue(val, weights, 7));
    }
}
