package com.leetcode.tries;

/**
 * Created by Dhaval on 11/26/2016.
 */
class TrieNode {
    // Initialize your data structure here.

    TrieNode[] next;
    boolean isEnd;
    public TrieNode() {
        next = new TrieNode[256];
        isEnd = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root = insert(root, word, 0);
    }

    private TrieNode insert(TrieNode x, String word, int d) {
        if (x == null) x = new TrieNode();
        if (d == word.length()) {
            x.isEnd = true;
            return x;
        }
        char c = word.charAt(d);
        x.next[c] = insert(x.next[c], word, d+1);
        return x;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode x = search(root, word, 0);
        if (x == null) return false;
        return x.isEnd;
    }

    private TrieNode search(TrieNode x, String word, int d) {
        if (x == null) return null;
        if (d == word.length()) return x;
        char c = word.charAt(d);
        return search(x.next[c], word, d+1);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (temp == null)
                return false;
            temp = temp.next[prefix.charAt(i)];
        }
        if (temp.isEnd) {
            return true;
        }

        for (int i = 0; i < 256; i++)  {
            if (temp.next[i] != null) {
                return true;
            }
        }
        return false;
    }

//    private boolean containsWord(TrieNode x) {
//        if (x == null) return false;
//        boolean retVal = false;
//        if (x.isEnd) {
//            return true;
//        }
//        for (int i = 0; i < 26; i++) {
//            retVal = containsWord(x.next[i]);
//            if (retVal == true) {
//                break;
//            }
//        }
//        return retVal;
//    }


    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
        t.insert("shore");
        t.insert("she");
        t.insert("bat");

        System.out.println(t.search("bat"));
        System.out.println(t.startsWith("bat"));
    }
}
