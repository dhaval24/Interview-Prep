package com.leetcode.strings;

/**
 * Created by Dhaval on 11/18/2016.
 */
public class ValidWordBox {

    public boolean isValidWordBox(String[] inp) {

        if (inp == null) return false;
        int len = inp.length;
        if (len != inp[0].length()) return false;
        for (int i = 0; i < len; i++){
            for (int j = i; j < len; j++) {
                if (inp[i].charAt(j) != inp[j].charAt(i)) return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String[] inp = {"abcd", "bxyz", "cykl", "dzlm"};
        System.out.println(new ValidWordBox().isValidWordBox(inp));
    }
}
