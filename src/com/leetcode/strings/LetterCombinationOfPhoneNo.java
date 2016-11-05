package com.leetcode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dhaval on 8/16/2016.
 */
public class LetterCombinationOfPhoneNo {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits.length() < 1) return result;
        if (digits.indexOf('0') >= 0 || digits.indexOf('1') >= 0) return result;
        Map<Character, List<Character>> map = populateHashMap();
        generateLetterCombinations(digits, result, map, "", 0);
        return result;
    }

    private void generateLetterCombinations(String s, List<String> result, Map<Character, List<Character>> map, String temp, int curr) {


        if (curr == s.length()) {
            result.add(new String(temp));

            return;
        }


        List<Character> toIterate = map.get(s.charAt(curr));
        for (int j = 0; j < toIterate.size(); j++) {

            temp = temp + toIterate.get(j);
            generateLetterCombinations(s, result, map, temp, curr+1);
            temp = temp.substring(0, temp.length()-1);

        }

    }

    private Map<Character, List<Character>> populateHashMap() {

        Map<Character, List<Character>> map = new HashMap<>();
        List<Character> l2 = new ArrayList<>();
        List<Character> l3 = new ArrayList<>();
        List<Character> l4 = new ArrayList<>();
        List<Character> l5 = new ArrayList<>();
        List<Character> l6 = new ArrayList<>();
        List<Character> l7 = new ArrayList<>();
        List<Character> l8 = new ArrayList<>();
        List<Character> l9 = new ArrayList<>();
        l2.add('a'); l2.add('b'); l2.add('c');
        l3.add('d'); l3.add('e'); l3.add('f');
        l4.add('g'); l4.add('h'); l4.add('i');
        l5.add('j'); l5.add('k'); l5.add('l');
        l6.add('m'); l6.add('n'); l6.add('o');
        l7.add('p'); l7.add('q'); l7.add('r'); l7.add('s');
        l8.add('t'); l8.add('u'); l8.add('v');
        l9.add('w'); l9.add('x'); l9.add('y'); l9.add('z');
        map.put('2', l2);
        map.put('3', l3);
        map.put('4', l4);
        map.put('5', l5);
        map.put('6', l6);
        map.put('7', l7);
        map.put('8', l8);
        map.put('9', l9);
        return map;

    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinationOfPhoneNo().letterCombinations("23"));
    }


}
