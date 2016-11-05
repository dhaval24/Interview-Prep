package com.leetcode.contest2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dhaval on 8/27/2016.
 */
public class FindDifference {

    public char findTheDifference(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();
        int len1 = s.length();
        int len2 = t.length();
        for (int i = 0; i < len1; i++) {
            char curr = s.charAt(i);
            if(!map.containsKey(curr)) {
                map.put(curr, 1);
            }
            else {
                map.put(curr, map.get(curr)+1);
            }
        }

       for (int i = 0; i < len2; i++) {
           char curr = t.charAt(i);
           if (map.containsKey(curr)) {

               if (map.get(curr) < 1) {
                   return curr;
               }
               else {
                   map.put(curr, map.get(curr)-1);
               }
           }
           else {
               return curr;
           }
       }

        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(new FindDifference().findTheDifference("abcd", "aabcd"));
    }

}
