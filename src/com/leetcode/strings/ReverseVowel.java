package com.leetcode.strings;

/**
 * Reverse vowels in string "hello -> holle
 *
 * Created by Dhaval on 7/14/2016.
 *
 * Algorithm: 2 pointer approach
 * 1. if both the values at start and end are vowel then swap them and increase start, decrease end
 * 2. else if value of start is not vowel increase start if value of end is not vowel decrease end
 *  O(n) time complexity code
 */
public class ReverseVowel {

    public String reverseVowels(String s) {

        StringBuilder sb = new StringBuilder(s);
        int len = sb.length();
        int start = 0;
        int end = len - 1;
        while (start <= end) {
            boolean flag1 = isVowel(sb.charAt(start));
            boolean flag2 = isVowel(sb.charAt(end));
            if (flag1 && flag2) {
                swap(sb, start, end);
                start++;
                end--;
            }
            else{
                if(!flag1) start++;
                if(!flag2) end--;
            }


        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c =='U') {
            return true;
        }
        else {
            return false;
        }
    }

    private void swap(StringBuilder sb, int i, int j) {
        char s = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, s);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseVowel().reverseVowels("hello"));
    }
}
