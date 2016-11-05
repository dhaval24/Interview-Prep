package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhaval on 8/18/2016.
 */
public class PalindromePartition {

    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        int len = s.length();
        if (len < 1) return result;
        partition(s, result, 0, new ArrayList<>());
        return result;

    }

    private void partition(String s, List<List<String>> result, int index, List<String> temp) {

        int len = s.length();
        if(index == len) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < len; i++) {

            String sub = s.substring(index, i+1);
            if (isPalindrome(sub)) {
                temp.add(sub);
                partition(s, result, i+1, temp);
                temp.remove(temp.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartition().partition("abba"));
    }

}
