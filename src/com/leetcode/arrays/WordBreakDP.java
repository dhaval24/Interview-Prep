package com.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dhaval on 10/25/2016.
 * ALgorithm is a DP based algorithm where we store a buffer in which if buffer[i] is true the string[0....i-1]
 * is breakable. The algorithm tries string of every length and eventually till the length of the entire string
 * to find if it is breakable.
 */
public class WordBreakDP {

    public boolean wordBreak(String s, Set<String> dict) {
        boolean [] breakable = new boolean[s.length()+1];
        breakable[0] = true;

        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(breakable[j]&&dict.contains(s.substring(j,i))){
                    breakable[i] = true;
                    break;
                }
            }
        }
        return breakable[s.length()];
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("leet");
        set.add("code");
        System.out.println(new WordBreakDP().wordBreak("leetcode", set));
    }
}
