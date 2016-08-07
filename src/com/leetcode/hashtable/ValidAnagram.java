package com.leetcode.hashtable;

/**
 * Created by Dhaval on 7/29/2016.
 * Given 2 strings find whether they are anagrams or not. Cat and Tac are anagrams
 * Algorithm: Initialize a character array of length 256
 * Iterate over string 1 and increase the value in array of the index corresponding to the ascii
 * of character by 1
 * Iterate through the second string, If the value at index ascii of character in array is 0 then
 * not an anagram or else reduce the count in array by 1.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {

        int len1 = s.length();
        int len2 = t.length();
        if (len1 != len2) return false;
        int[] index = new int[256];
        for (int i = 0; i < len1; i++) {
            int current = s.charAt(i);
            index[current] += 1;
        }
        for (int i  = 0; i < len2; i++) {
            int current = t.charAt(i);
            if (index[current] == 0) return false;
            index[current] -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagram("anagram", "nagaram"));
    }
}
