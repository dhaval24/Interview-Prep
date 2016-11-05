package com.leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dhaval on 8/29/2016.
 */
public class UniqueWordAbbreviation {

    private Set<String> set;

    public UniqueWordAbbreviation(List<String> dictionary) {

        set = new HashSet<>();
        populateSet(set, dictionary);
    }

    public boolean isUnique(String word) {

        if(set.contains(getAbbreviation(word))) {
            return false;
        }
        return true;
    }

    private void populateSet(Set<String> set, List<String> dictionary) {
        for (String word : dictionary) {
            String abb = getAbbreviation(word);
            set.add(abb);
        }
    }

    private String getAbbreviation(String word) {

        int len = word.length();
        if (len < 3) {
            return word;
        }
        return "" + word.charAt(0) + (len-2) + word.charAt(len-1);

    }

    public static void main(String[] args) {

        List<String> dict = new ArrayList<>();
        dict.add("it");
        dict.add("it");
        dict.add("dear");
        dict.add("card");
        UniqueWordAbbreviation un = new UniqueWordAbbreviation(dict);
        System.out.println(un.isUnique("imot"));
        System.out.println(un.isUnique("dear"));
        System.out.println(un.isUnique("cane"));
        System.out.println(un.isUnique("make"));
    }

}
