package com.leetcode.strings;

/**
 * Created by Dhaval on 8/13/2016.
 * Given a string find the longest palindrome substring from it.
 * eg : abcba -> abcba
 * abbd :- > bb
 *
 * Algorithm 1: Dynamic programming with O(n^2) space and time
 * -we initalize a m*n boolean matrix and fill the diagonal elements as True as they represent single letter string and is always palindrome
 * -we create 2 pointers start and end of the string by using the length ranging from 2 to length of string and the column iterator in matrix
 * -in case of string of length 2 it is palindrome only if the both the characters are of same length. (s[j] == s[i+j-1]). j is start index
 * -when string is of length 3 below is the formula:
 *      If s[j] = s[i+j-1] && s[j+][i+j-1-1] ( previous string not including this letters is palindrome )
 *      then dp[i][j] = true
 */
public class LongestPalindromeSubString {

    public String longestPalindromeDP(String s) {

        int len = s.length();
        if (len < 1) return "";
        if (len < 2) return s;
        int longestStart = 0;
        int maxLen = 1;

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int i = 2; i <= len; i++) {
            for (int j = 0; j < len - i + 1; j++) {

                if (i == 2) {
                    if (s.charAt(j) == s.charAt(j + i - 1)) {
                        dp[j][j+i-1] = true;
                        maxLen = i;
                        longestStart = j;
                    }
                }
                else {
                    int pointer2 = j + i - 1;
                    if (s.charAt(j) == s.charAt(pointer2) && dp[j+1][pointer2-1]) {
                        dp[j][pointer2] = true;
                        longestStart = j;
                        maxLen = i;
                    }
                }

            }
        }
        return s.substring(longestStart, longestStart + maxLen);
    }

    public String longestPalindrome(String s) {

        int len = s.length();
        if (len < 1) return "";
        if (len < 2) return s;
        String longest = s.substring(0, 1);
        for (int i = 0; i < len-1; i++) {
            String odd = expandAroundCenter(s, len, i, i);
            if (odd.length()  > longest.length()) {
                longest = odd;
            }

            String even = expandAroundCenter(s, len, i, i+1);
            if (even.length() > longest.length()) {
                longest = even;
            }
        }

        return longest;
    }

    private String expandAroundCenter(String s, int len, int c1, int c2) {

        int left = c1;
        int right = c2;
        while ((left >= 0 && right < len) && (s.charAt(left) == s.charAt(right))) {
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromeSubString().longestPalindrome("abcba"));
    }
}
