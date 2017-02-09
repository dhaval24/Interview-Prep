package com.leetcode.tries;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhaval on 12/19/2016.
 */
public class TrieIterative {

    private class TrieNode {
        TrieNode[] arr;
        boolean isEnd;
        public TrieNode() {
            arr = new TrieNode[26];
        }
    }

    private TrieNode root;

    public TrieIterative() {
        root = new TrieNode();
    }

    public void insert(String word) {
        int len = word.length();
        TrieNode p = root;
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (p.arr[index] == null) {
                p.arr[index] = new TrieNode();
            }
            p = p.arr[index];
        }
        p.isEnd = true;
    }

    public boolean search(String word) {

        TrieNode p = searchNode(word);
        if (p == null) {
            return false;
        }
        if (p.isEnd) {
            return true;
        }
        else {
            return false;
        }
    }

    private TrieNode searchNode(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (p.arr[index] == null) {
                return null;
            }
            p = p.arr[index];
        }
        if (p == root) {
            return null;
        }
        return p;

    }

    private boolean startsWith1(String word) {
        TrieNode p = searchNode(word);
        if (p == null) {
            return false;
        }
        else {
            return true;
        }
    }

    private List<String> startsWith(String word) {
        TrieNode x = searchNode(word);
        List<String> words = new ArrayList<>();
        if (x == null) return words;
        else return startsWith(x, words, word, 0);
    }

    private List<String>  startsWith(TrieNode x, List<String> words, String word, int index) {
        if (x == null ) return words;
        if (x.isEnd) {
            words.add(word);
        }
        for (int i = 0; i < 26; i++) {
            startsWith(x.arr[i], words, word + (char)(i+97), i);
        }
        return words;
    }




    public static void main(String[] args) {

        TrieIterative t = new TrieIterative();
        t.insert("dhaval");
        t.insert("door");
        t.insert("dooring");
        t.insert("dooping");
        t.insert("apple");
        System.out.println(t.search("dha"));
        System.out.println(t.startsWith("do"));
    }
}
