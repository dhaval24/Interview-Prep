package com.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dhaval on 2/25/2017.
 */
public class FlipGameII {

    public boolean canWin(String s) {

        if (s == null || s.length() < 2) return false;
        Map<String, Boolean> map = new HashMap<>();
        return canWinHelper(s, map);
    }

    private boolean canWinHelper(String s, Map<String, Boolean> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.substring(i, i+2).equals("++")) {
                String t = s.substring(0, i) + "--" + s.substring(i+2);
                if (!canWinHelper(t, map)) {
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new FlipGameII().canWin("+++++"));
    }
}
