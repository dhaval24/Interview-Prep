package com.leetcode.strings;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Given s = "Hello World", return 5.
 *
 * Created by Dhaval on 7/17/2016.
 * Algorithm: 1. trim leading and trailing white spaces
 * 2. Iterate until the counter >= length of the string begining from the end
 * and character at that index is not ' '.
 *  return the difference of total length - counter position
 *
 */
public class LenOfLastWord {
    public int lengthOfLastWord(String s) {

        s = s.trim();
        int end = s.length() - 1;
        if (end < 0) return 0;
        while (end >=0 && s.charAt(end) != ' ') {
            end--;
        }
        return s.length() - end - 1;
    }

    public static void main(String[] args) {
        System.out.println(new LenOfLastWord().lengthOfLastWord(" a "));
    }
}
