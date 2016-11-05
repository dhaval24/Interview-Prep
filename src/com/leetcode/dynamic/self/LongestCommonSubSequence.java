package com.leetcode.dynamic.self;

/**
 * Created by Dhaval on 8/16/2016.
 */
public class LongestCommonSubSequence {

    public int findLongestCommonSubSeq(String s, String s1) {

        int[][] dp = new int[s1.length()+1][s.length()+1];
        int m = dp.length;
        int n = dp[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (s1.charAt(i-1) == s.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubSequence().findLongestCommonSubSeq("abcba", "xyzab"));
    }

}
