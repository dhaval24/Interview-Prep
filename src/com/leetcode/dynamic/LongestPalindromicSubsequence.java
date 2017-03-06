package com.leetcode.dynamic;

/**
 * Created by Dhaval on 2/21/2017.
 */
public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {

        if (s == null) throw new NullPointerException();
        if (s.length() == 0) return 0;
        int[][] buffer = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            buffer[i][i] = 1;
        }
        for (int len = 1; len < s.length(); len++) {
            for (int i = 0; i < s.length() - len; i++) {
                int j = i + len;
                if (s.charAt(i) == s.charAt(j)) {
                    buffer[i][j] = buffer[i+1][j-1] + 2;
                }
                else {
                    buffer[i][j] = Math.max(buffer[i][j-1], buffer[i+1][j]);
                }
            }

        }
        return buffer[0][s.length()-1];

    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq("abxcb"));
    }
}
