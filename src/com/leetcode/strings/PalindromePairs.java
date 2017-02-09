package com.leetcode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dhaval on 1/22/2017.
 *
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

 Example 1:
 Given words = ["bat", "tab", "cat"]
 Return [[0, 1], [1, 0]]
 The palindromes are ["battab", "tabbat"]
 Example 2:
 Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 */
public class PalindromePairs {

    public List<List<Integer>> palindromePairs(String[] words) {

        if (words == null) throw new IllegalArgumentException("Input array is null");
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>(); // Hashmap for word and its position in input array
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {

            String s = words[i];
            if (isPalindrome(s)) { //If word is palindrome as a whole find if there is an empty string in the input array and it has a different index than i
                if (map.containsKey("") && map.get("") != i) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(map.get(""));
                }
            }

            String reversed = new StringBuilder(s).reverse().toString();
            if (map.containsKey(reversed) && map.get(reversed) != i) { //Check if there is a reversed string present in the input array at different index
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(map.get(reversed));
                result.add(temp);
            }

            for (int k = 1; k < s.length(); k++) { // find left and right substring of different lengths
                String left = s.substring(0, k);
                String right = s.substring(k);
                if (isPalindrome(left)) { //if left string is palindrome find if there exist a reversed right string palindrome at different index as it can be
                    //appended before the current string and whole string becomes palindrome
                    String reverse = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(reverse) && map.get(reverse) != i) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(map.get(reverse));
                        temp.add(i);
                        result.add(temp);
                    }
                }

                if (isPalindrome(right)) { //if right string is palindrome find if there exist a reversed right string palindrome at different index as it can be
                    //appended after the current string and whole string becomes palindrome
                    String reverse = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(reverse) && map.get(reverse) != i) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(map.get(reverse));
                        result.add(temp);
                    }
                }
            }
        }

        return result;

    }

    private boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        int lo = 0;
        int hi = sb.length() - 1;
        while (lo <= hi) {
            if (sb.charAt(lo++) != sb.charAt(hi--)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String[] inp = {"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(new PalindromePairs().palindromePairs(inp));
    }
}
