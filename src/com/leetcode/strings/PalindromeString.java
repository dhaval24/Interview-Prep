package com.leetcode.strings;

/**
 * Given a string determine if is palindrome. A string like acbcba is palindrome as it
 * reads the same from both the sides
 *
 * Created by Dhaval on 7/17/2016.
 *
 * Algorithm : 2 Pointer approach
 * 1. Start iterating over from both the ends and see if they have same value if not return false
 * O(n) time and O(1) space complexity
 */
public class PalindromeString {
    public boolean isPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {

            char a = Character.toLowerCase(s.charAt(start));
            char b = Character.toLowerCase(s.charAt(end));
            if (!isValidRange(a)) {
                start++;
                continue;
            }
            if (!isValidRange(b)) {
                end--;
                continue;
            }
            if (a != b) return false;
            start++;
            end--;


        }
        return true;
    }

    private boolean isValidRange(char a) {
        if ((a >= 97 && a <= 122 ) || (a >= 48 && a <= 57)) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeString().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
