package com.leetcode.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dhaval on 10/25/2016.
 * ALgorithm
 */
public class WordBreakDP {

    public boolean wordBreak(String s, Set<String> dict) {

        int len = s.length();
        int[] buffer = new int[len+1];
        Arrays.fill(buffer, -1);
        buffer[0] = 0;
        for (int i = 0; i < len; i++) {
            if (buffer[i] != -1) {
                for (int j = i+1; j <= len; j++) {
                    String curr = s.substring(i, j);
                    if (dict.contains(curr)) {
                        buffer[j] = i;
                    }
                }
            }
        }
        return buffer[len] != -1;
    }

    public boolean wordBreakMethod2(String s, Set<String> dict) {

        int len = s.length();
        boolean[] buffer = new boolean[len+1];
        buffer[0] = true;
        for (int i = 0; i < len; i++) {
            if (!buffer[i]) continue;
            for (String word : dict) {
                int wordLen = word.length();
                int end = i + wordLen;
                if (end > len)  continue;
                if (s.substring(i, end).equals(word)) {
                    buffer[end] = true;
                }
            }
        }
        return buffer[len] == true;
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("leet");
        set.add("code");
        System.out.println(new WordBreakDP().wordBreakMethod2("leetcode", set));
    }
}
