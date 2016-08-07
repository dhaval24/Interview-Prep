package com.leetcode.strings;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * Created by Dhaval on 7/20/2016.
 *
 * Algorithm: Find the string of smallest length from the Array of strings
 * 2. Iterate till minlenght:
 * 3. Check if all the strings have the same element as of the element at index in the fucntion isALlEqual()
 * 4. If not then return strs[0].subString(0, currentIndex)
 * 5. If never returned in the loop then the entire minLength array is substring
 *
 */
public class LongestCommPrefixArray {
    public String longestCommonPrefix(String[] strs) {

        if(strs.length < 1) return "";
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }
        for (int i = 0; i < minLen; i++) {

            if (!isAllEqual(strs, strs[0].charAt(i), i)) {
                return strs[0].substring(0,i);
            }

        }
        return strs[0].substring(0, minLen);
    }

    private boolean isAllEqual(String[] strs, char c, int index) {
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].charAt(index) != c) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommPrefixArray().longestCommonPrefix(new String[]{"abc", "ab", "abcd" }));
    }
}
