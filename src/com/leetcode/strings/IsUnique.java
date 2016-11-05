package com.leetcode.strings;

/**
 * Created by Dhaval on 9/24/2016.
 */
public class IsUnique {

    public boolean hasUniqueCharacters(String s) {

        int checker = 0;
        char[] stringArr = s.toCharArray();
        for (char w : stringArr) {

            System.out.println(1 << w);
            if ((checker & (1 << w)) > 1) {
                return false;
            }
            checker |= (1 << w);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsUnique().hasUniqueCharacters("abcda"));
    }
}
