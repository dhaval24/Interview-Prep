package com.leetcode.bit;

/**
 * Created by Dhaval on 3/1/2017.
 * Algorithm: We use the bits in a 32 bit integer to check for duplicate. Every time we see a new character we set its corresponding bit
 * when we see a bit already setted ( tested by doing and) we return true.
 */
public class DuplicateInLowercaseString {

    public boolean findDuplicate(String s) {
        if (s == null) return false;
        if (s.length() == 0 || s.length() == 1) return false;
        int checker = 0;
        for (char c : s.toCharArray()) {
            if ((checker & (1 << (c - 97))) != 0) {
                return true;
            }
            checker |= (1 << (c - 97));
        }
        return false;
    }

    public static void main(String[] args) {
        DuplicateInLowercaseString d = new DuplicateInLowercaseString();
        System.out.println(d.findDuplicate("dhaval"));
        System.out.println(d.findDuplicate("aba"));
    }
}
