package com.leetcode.strings;

/**
 * Created by Dhaval on 11/10/2016.
 */
public class FirstUniqueChar {
    public int firstUniqChar(String s) {
        if (s == null || s.equals("")) return -1;
        int[] buffer = new int[26];
        int[] lastIndex = new int[26];
        int len = s.length();
        if (len < 2) return 0;
        for (int i = 0; i < len; i++) {
            buffer[s.charAt(i)-97]++;
            lastIndex[s.charAt(i)-97] = i;
        }
        for (int i = 0; i < len; i++) {
            if (buffer[s.charAt(i)-97] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstUniqueChar().firstUniqChar("leetcode"));
    }
}
