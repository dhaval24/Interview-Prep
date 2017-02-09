package com.leetcode.strings;

/**
 * Created by Dhaval on 9/24/2016.
 */
public class OneEdit {

    public boolean alwaysEdit(String s1, String s2) {

        if (s1.length() == s2.length()) {
            return oneEdit(s1, s2);
        }
        else if (s1.length() + 1 == s2.length()) {
            return oneReplace(s1, s2);
        }
        else if (s1.length() - 1 == s2.length()) {
            return oneReplace(s1, s2);
        }
        return false;
    }

    private boolean oneEdit(String s1, String s2) {

        int len = s1.length();
        int index = 0;
        boolean isFound = false;
        while (index < len) {
            if (s1.charAt(index) != s2.charAt(index)) {
                if (isFound) return false;
                isFound = true;
            }
            index++;
        }
        return isFound;

    }

    private boolean oneReplace(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        int len1 = s1.length();
        int len2 = s2.length();
        while (index1 < len1 && index2 < len2) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) return false;
                if (s1.length() > s2.length()) index1++;
                else index2++;
            }
            else {
                index1++;
                index2++;
            }

        }
        return true;
    }

    public boolean isOneEditDistance(String s, String t) {
        int len = Math.min(s.length(), t.length());
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) // s has the same length as t, so the only possibility is replacing one char in s and t
                    return s.substring(i + 1).equals(t.substring(i + 1));
                else if (s.length() < t.length()) // t is longer than s, so the only possibility is deleting one char from t
                    return s.substring(i).equals(t.substring(i + 1));
                else // s is longer than t, so the only possibility is deleting one char from s
                    return t.substring(i).equals(s.substring(i + 1));
            }
        }
        //All previous chars are the same, the only possibility is deleting the end char in the longer one of s and t
        return Math.abs(s.length() - t.length()) == 1;
    }

    public static void main(String[] args) {
        System.out.println(new OneEdit().alwaysEdit("cab", "ab"));
    }
}
