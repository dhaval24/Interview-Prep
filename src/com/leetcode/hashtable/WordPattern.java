package com.leetcode.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Dhaval on 7/28/2016.
 * Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Examples:

 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.

 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

 Algorithm : 1. Split the given string with spaces to form string array
 2. If the length of the parrent and the size of string array doesn't match it is not a valid pattern
 3. Make a hashmap of characters of pattern and its corresponding value from the string array
 4. Make hashset to check for redundancy like if pattern is "ab" and string is "dog dog"this ism't valid because for each pattern
 index there should be unique vale.
 5. iterate over the entire pattern, if the pattern key is not available in the map then check if the its matching
 word in the string is not repeated and if so add it to the map.
 6. Whenever the key in the pattern repeats than see if the new word and its stored value matches or else return false
 */
public class WordPattern {

    public boolean wordPatternMatch(String pattern, String str) {

        int len = pattern.length();
        String[] words = str.split(" ");
        Set<String> set = new HashSet<>();
        if (len != words.length) return false;
        Map<Character, String> map;
        map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if(!map.containsKey(pattern.charAt(i))) {
                if (!set.add(words[i])) return false;
                map.put(pattern.charAt(i), words[i]);
            }
            else {
                String value = map.get(pattern.charAt(i));
                if (!value.equals(words[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPatternMatch("abba", "dog cat cat dog"));
    }
}
