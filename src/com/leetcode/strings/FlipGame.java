package com.leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhaval on 2/24/2017.
 */
public class FlipGame {

    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 2) return res;
        for (int i = 0 ; i <= s.length() - 2; i++) {
            if (s.substring(i, i+2).equals("++")){
                String str = s.substring(0, i) + "--" + s.substring(i+2);
                res.add(str);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new FlipGame().generatePossibleNextMoves("++++"));
    }
}
