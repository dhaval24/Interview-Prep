package com.leetcode.strings;

/**
 * Created by Dhaval on 11/9/2016.
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int len = s.length();
        int len1 = t.length();
        int[] buffer = new int[26];
        for (int i = 0; i < len1; i++) {
            buffer[(t.charAt(i)-97)]++;
            if (i < len) {
                buffer[(s.charAt(i)-97)]--;
            }
        }
        for (int i = 0; i < 26; i++) {
            if(buffer[i] == 1) {
                return (char)(i+97);
            }
        }
        return ' ';
    }

    public char findTheDifference1(String s, String t) {
        int n = t.length();
        char c = t.charAt(n - 1);
        for (int i = 0; i < n - 1; ++i) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheDifference().findTheDifference("abcd", "abcde"));
    }
}
