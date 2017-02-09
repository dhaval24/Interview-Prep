package com.leetcode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Dhaval on 12/6/2016.
 */
public class LongSubstringAtMostKDistinct {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        if (s == null) {
            throw new NullPointerException();
        }

        int len = s.length();
        Map<Character, List<Integer>> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int max = 0;
        int start = 0;

        for (int i = 0; i < len; i++) {
            char curr = s.charAt(i);
            if (map.containsKey(curr)) {
                List<Integer> temp = map.get(curr);
                temp.add(i+1);
                map.put(curr, temp);
            }
            else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i+1);
                map.put(curr, temp);
            }
            set.add(curr);

            while (set.size() > k) {
                start = getMinIndex(map, set);
            }

            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    private int getMinIndex(Map<Character, List<Integer>> map, Set<Character> set) {
        int minIndex = Integer.MAX_VALUE;
        char characterToRemove = ' ';
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            List<Integer> temp = entry.getValue();
            if (temp.size() == 0) continue;
            if(minIndex > temp.get(temp.size()-1)) {
                minIndex = temp.get(temp.size()-1);
                characterToRemove = entry.getKey();
            }
        }
        set.remove(characterToRemove);
        List<Integer> temp = map.get(characterToRemove);
        temp.remove(temp.size()-1);
        map.put(characterToRemove, temp);
        return minIndex;
    }

    public int lengthOfLongestSubstringKDistinctII(String s, int k) {
        int[] count = new int[256];
        int num = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) num++;
            if (num > k) {
                while (--count[s.charAt(i++)] > 0);
                num--;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        LongSubstringAtMostKDistinct l = new LongSubstringAtMostKDistinct();
        String inp = "addcaecfef";
        int k = 4;
        System.out.println(l.lengthOfLongestSubstringKDistinctII(inp, k));
    }

}
