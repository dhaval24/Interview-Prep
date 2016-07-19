package com.leetcode.strings;

/**
 * Created by Dhaval on 7/15/2016.
 * Algorithm : 2 pointer swappping approach using character array
 */
public class ReverseString {
    public String revString(String s) {

        int len = s.length();
        char[] buffer = s.toCharArray();
        int start = 0;
        int end = len - 1;
        while(start <= end) {
            swap(buffer, start, end);
            start++;
            end--;
        }

        return new String(buffer);
    }

    private void swap(char[] buffer, int i, int j) {
        char temp = buffer[i];
        buffer[i] = buffer[j];
        buffer[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseString().revString("hello how are you"));
    }
}
