package com.leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhaval on 8/9/2016.
 */
public class GenerateParanthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n < 1) return result;
        generateParenthesis(n, 0, 0, result, "");
        return result;
    }

    private void generateParenthesis(int n, int open, int close, List<String> result, String temp) {

        if (temp.length() == n*2) {
            result.add(new String(temp));
            return;
        }

        if (open > n || close > n) {
            return;
        }

        if (open < n )
            generateParenthesis(n, open + 1, close, result, temp+"(");

        if (open - close > 0)
            generateParenthesis(n, open, close + 1, result, temp+")");
        return;
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParanthesis().generateParenthesis(3));
    }

}
