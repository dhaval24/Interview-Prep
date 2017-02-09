package com.leetcode.arrays;

import java.util.Stack;

/**
 * Created by Dhaval on 11/15/2016.
 */
public class DecodeString {

    public String decodeString(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return s;
        int len = s.length();
        Stack<String> strStack = new Stack<>();
        Stack<Integer> noStack = new Stack<>();
        noStack.push(1);
        for (int i = 0; i < len; i++) {
            char curr = s.charAt(i);
            if (curr == '[') {
                int j = i - 1;
                while (j >= 0 && s.charAt(j) >= 48 && s.charAt(j) < 58) {
                    j--;
                }
                noStack.push(Integer.valueOf(s.substring(j+1, i)));
                strStack.push("");
            }
            else if (curr == ']') {
                String top = strStack.pop();
                String top2 = "";
                if (!strStack.isEmpty())
                    top2 = strStack.pop();
                int num = noStack.pop();
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < num; k++) {
                    sb = sb.append(top);
                }
                strStack.push(top2 + sb.toString());

            } else if (curr < 48 || curr > 57) {
                String top = "";
                if (!strStack.isEmpty())
                    top = strStack.pop();
                strStack.push(top + curr);
            }

        }
        String res = "";
        while (!strStack.isEmpty()) {
            int num = noStack.pop();
            String temp = strStack.pop();
            for (int i = 0; i < num - 1; i++) {
                temp = temp + temp;
            }
            res = res + temp;

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("abc2[xy3[pqr]mn]op"));
    }

}
