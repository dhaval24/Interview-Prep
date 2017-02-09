package com.leetcode.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dhaval on 8/11/2016.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            String curr = sortString(strs[i]);
            if (!map.containsKey(curr)) {
                map.put(curr, new ArrayList<>());
            }
            map.get(curr).add(strs[i]);
        }

        return new ArrayList<>(map.values());

    }

    private String sortString(String s) {
        char[] letters = s.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }

    public static void main(String[] args) {
        String[] inp = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(inp));
    }

}
