package com.leetcode.dynamic;

/**
 * Created by Dhaval on 3/2/2017.
 */
public class RegexMatching {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) throw new IllegalArgumentException("Nulls not allowed");
        boolean[][] buffer = new boolean[s.length()+1][p.length()+1];
        buffer[0][0] = true;
        for (int i = 1; i < buffer[0].length; i++) {
            if (p.charAt(i-1) == '*') {
                buffer[0][i] = buffer[0][i-2];
            }
        }

        for (int i = 1; i < buffer.length; i++) {
            for (int j = 1; j < buffer[0].length; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    buffer[i][j] = buffer[i-1][j-1];
                }
                else {
                    if (p.charAt(j-1) == '*') {
                        buffer[i][j] = buffer[i][j-2];
                        if (p.charAt(j-2) == '.' || p.charAt(j-2) == s.charAt(i-1)) {
                            buffer[i][j] = buffer[i][j] | buffer[i-1][j];
                        }
                    }
                }
            }
        }
        return buffer[s.length()][p.length()];
    }

    public static void main(String[] args) {
        RegexMatching rm = new RegexMatching();
        System.out.println(rm.isMatch("aab", "c*a*b"));
    }
}
