package com.leetcode.strings;

/**
 * Created by Dhaval on 8/12/2016.
 */
public class LongestNonRepSubString {

    public int longestSubString(String s) {

        int[] buffer = new int[256];
        int len = s.length();
        int start = 0;
        int maxLength = 0;
        for (int i = 0; i < len; i++) {
            char curr = s.charAt(i);
            start = Math.max(start,buffer[curr]);
            maxLength = Math.max(maxLength, i-start+1);
            buffer[curr] = i+1;

        }
        return maxLength;

    }

    public int longestSubStringWithKRepeatation(String s, int k) {

        return 0;
    }


    public static void main(String[] args) {
        //System.out.println(new LongestNonRepSubString().longestSubString("abcdefgc"));
        System.out.println(new LongestNonRepSubString().longestSubStringWithKRepeatation("abcdefgc", 2));
    }

}
