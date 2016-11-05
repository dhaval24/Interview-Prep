package com.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dhaval on 8/13/2016.
 * Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {

        int len = s.length();
        Map<Character, Character> map = new HashMap<>();
        boolean[] set = new boolean[256];
        for (int i = 0; i < len; i++) {
            char curr = s.charAt(i);
            char currT = t.charAt(i);
            if (!map.containsKey(curr)) {
                if (set[currT] == false) {
                    set[currT] = true;
                    map.put(curr, currT);
                }
                else{
                    return false;
                }
            }
            else {
                if (map.get(curr) != currT) return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(new IsomorphicStrings().isIsomorphic("foo", "bar"));
    }
}
