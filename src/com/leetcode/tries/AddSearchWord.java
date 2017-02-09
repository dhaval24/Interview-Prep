package com.leetcode.tries;

/**
 * Created by Dhaval on 11/26/2016.
 */
public class AddSearchWord {
    private Node root = new Node();

    private class Node {
        Node[] next;
        boolean isWord;
        public Node() {
            next = new Node[26];
            isWord = false;
        }
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        root = addWord(root, word, 0);
    }

    private Node addWord(Node x, String word, int d) {
        if (x == null) {
            x = new Node();
        }
        if (d == word.length()) {
            x.isWord = true;
            return x;
        }
        char c = word.charAt(d);
        x.next[c-97] = addWord(x.next[c-97], word, d+1);
        return x;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(root, word, new StringBuilder());
    }

    private boolean search(Node x, String word, StringBuilder sb) {
        boolean retValue = false;
        if (x == null) {
            retValue = false;
            return retValue;
        }
        int d = sb.length();
        if (d == word.length() && x.isWord) {
            retValue = true;
            return retValue;
        }
        if (d == word.length()) {
            retValue = false;
            return retValue;
        }
        char c = word.charAt(d);
        if (c == '.') {
            for (char r = 97; r <= 122; r++) {
                sb.append(r);
                retValue = search(x.next[r-97], word, sb);
                sb.deleteCharAt(sb.length()-1);
                if(retValue) {
                    break;
                }
            }
        }
        else {
            sb.append(c);
            retValue = search(x.next[c-97], word, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        return retValue;
    }

    public static void main(String[] args) {
        AddSearchWord dict = new AddSearchWord();
        dict.addWord("word");
        System.out.println(dict.search(".o.d"));
    }

}
