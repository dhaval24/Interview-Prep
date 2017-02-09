package com.leetcode.strings;

/**
 * Created by Dhaval on 11/9/2016.
 * canConstruct("a", "b") -> false
   canConstruct("aa", "ab") -> false
   canConstruct("aa", "aab") -> true
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) return false;
        int[] buffer = new int[26];
        int magLen = magazine.length();
        for (int i = 0; i < magLen; i++) {
            buffer[magazine.charAt(i)-97]++;
        }
        int noteLen = ransomNote.length();
        for (int i = 0; i < noteLen; i++) {
            if (buffer[ransomNote.charAt(i)-97] < 1) return false;
            buffer[ransomNote.charAt(i)-97]--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new RansomNote().canConstruct("aa", "aab"));
    }
}
