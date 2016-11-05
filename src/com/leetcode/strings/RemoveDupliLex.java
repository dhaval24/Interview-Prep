package com.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dhaval on 9/1/2016.
 *
 *  Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

 Example:

 Given "bcabc"
 Return "abc"

 Given "cbacdcbc"
 Return "acdb"

 Algorithm : 1. Greedily create a Map and store each character and its last occurance
 2. Now the first character to be inserted in the result would be the minimum character from index 0 to the minIndex value in the map
    3. Lets take the example of cbacdcbc;
        our HashMap looks like this initially : a - 2, b - 6, c - 7, d - 4. Minimum index from this is 2;
        So we take 2 pointers start and end and find the minimum character from index start = 0 and end = 2 which is 'a'
        we update our start to be loop index + 1 where minchar is found
    4. We insert the this minChar at the ith index of the result array and remove minChar from the map.
    5. Now if we found the minChar on the position of our end pointer we need to update end pointer and that is done via fiding again the
        minIndex from the updated map. Else we keep on finding minimum character which is present in the updated map until we encouter our
        minimum as the character on end pointer.
 */
public class RemoveDupliLex {

    public String removeDuplicateLetters(String s) {

        int len = s.length();
        if (len < 1) return "";
        if (len == 1) return s;
        Map<Character, Integer> posMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            posMap.put(s.charAt(i), i);
        }
        int start = 0;
        int end = findMinPos(posMap);
        char[] result = new char[posMap.size()];
        int resLen = result.length;
        for (int i = 0; i < resLen; i++) {
            char minChar = 256;
            for (int j = start; j <= end; j++) {
                char curr = s.charAt(j);
                if (posMap.containsKey(curr) && curr < minChar) {
                    minChar = curr;
                    start = j + 1;
                }
            }
            result[i] = minChar;
            posMap.remove(minChar);
            if (s.charAt(end) == minChar) end = findMinPos(posMap);
        }
        return new String(result);
    }

    private int findMinPos(Map<Character, Integer> map) {

        if (map == null || map.isEmpty()) return  -1;
        int min = Integer.MAX_VALUE;
        for (int num : map.values()) {
            min = Math.min(min, num);
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDupliLex().removeDuplicateLetters("cbacdcbc"));
    }
}
