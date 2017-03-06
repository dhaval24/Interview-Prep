package com.leetcode.dynamic;

/**
 * Created by Dhaval on 3/2/2017.
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) throw new IllegalArgumentException("Inputs cannot be null");
        StringBuilder patternBuilder = new StringBuilder();
        boolean isFirst = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                if (isFirst) {
                    isFirst = false;
                    patternBuilder.append(p.charAt(i));
                }
            }
            else {
                patternBuilder.append(p.charAt(i));
                isFirst = true;
            }
        }
        p = patternBuilder.toString();
        boolean[][] buffer = new boolean[s.length() + 1][p.length() + 1];
        buffer[0][0] = true;
        if (p.length() > 0 && p.charAt(0) == '*') {
            buffer[0][1] = true;
        }
        for (int i = 1; i < buffer.length; i++) {
            for (int j = 1; j < buffer[0].length; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    buffer[i][j] = buffer[i-1][j-1];
                }
                else if (p.charAt(j-1) == '*') {
                    buffer[i][j] = buffer[i-1][j] || buffer[i][j-1];
                }
            }
        }

        return buffer[buffer.length-1][buffer[0].length - 1];
    }

    public static void main(String[] args) {
        WildcardMatching matching = new WildcardMatching();
        String s = "aab";
        String p = "**b";
        System.out.println(matching.isMatch(s, p));
    }
}
