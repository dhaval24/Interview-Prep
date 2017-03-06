package com.leetcode.dynamic.self;

/**
 * Created by Dhaval on 2/20/2017.
 */
public class LongestCommonSubstring {

    public int getLenLongestCommonSubstring(String s1, String s2) {
        if (s1 == null || s2 == null) throw new NullPointerException();
        int m = s1.length();
        int n = s2.length();
        int max = 0;
        int[][] buffer = new int[m][n];
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (i > 0 && j > 0) {
                        buffer[i][j] = buffer[i-1][j-1] + 1;
                    }
                    else {
                        buffer[i][j] = 1;
                    }
                    max = Math.max(max, buffer[i][j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abe";
        System.out.println(new LongestCommonSubstring().getLenLongestCommonSubstring(s1, s2));
    }
}
