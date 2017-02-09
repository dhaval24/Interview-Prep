package com.leetcode.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dhaval on 12/2/2016.
 */
public class GroupShiftedString {

    public List<List<String>> groupStrings(String[] strings) {

        List<List<String>> result = new ArrayList<>();
        if (strings == null || strings.length == 0) {
            return result;
        }

        int len = strings.length;
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String key = getKey(strings[i]);
            if (map.containsKey(key)) {
                List<String> templist = map.get(key);
                templist.add(strings[i]);
                map.put(key, templist);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(strings[i]);
                map.put(key, list);
            }
        }

        return new ArrayList<>(map.values());

    }

    private String getKey(String word) {
        int len = word.length();
        StringBuilder sb = new StringBuilder();
        if (len == 1) {
            return sb.append("0").toString();
        }
        sb.append("0");
        for (int i = 1; i < len; i++) {
            int diff =  word.charAt(i) - word.charAt(i-1);
            if (diff < 0) {
                diff += 26;
            }
            sb.append(diff);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        System.out.println(new GroupShiftedString().groupStrings(strings));
    }
}
