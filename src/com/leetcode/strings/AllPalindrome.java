package com.leetcode.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dhaval on 9/16/2016.
 */
public class AllPalindrome {

    public int palindromes(final String input) {

        final List<String> result = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            // expanding even length palindromes:
            expandPalindromes(result,input,i,i+1);
            // expanding odd length palindromes:
            expandPalindromes(result,input,i,i);
        }

        return result.size();
    }

    public void expandPalindromes(final List<String> result, final String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            result.add(s.substring(i,j+1));
            i--; j++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new AllPalindrome().palindromes("hellolle"));
    }
}
