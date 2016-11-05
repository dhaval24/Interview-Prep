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
        return true;

    }

    private boolean oneReplace(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        int len1 = s1.length();
        int len2 = s2.length();
        while (index1 < len1 && index2 < len2) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) return false;
                index2++;
            }
            else {
                index1++;
                index2++;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new OneEdit().alwaysEdit("pale", "paledd"));
    }
}
