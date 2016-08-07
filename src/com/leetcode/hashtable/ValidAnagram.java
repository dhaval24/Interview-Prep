package com.leetcode.hashtable;

/**
 * Created by Dhaval on 7/29/2016.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {

        int len1 = s.length();
        int len2 = t.length();
        if (len1 != len2) return false;
        int[] index = new int[256];
        for (int i = 0; i < len1; i++) {
            int current = s.charAt(i);
            if (index[current] == 0) index[current] += 1;
        }
        for (int i  = 0; i < len2; i++) {
            int current = t.charAt(i);
            if (index[current] == 0) return false;
            index[current] -= 1;
        }
        return true;
    }
}
