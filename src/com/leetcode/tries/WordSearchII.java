package com.leetcode.tries;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dhaval on 11/26/2016.
 */
public class WordSearchII {
    class Trie {

        Node root = new Node();

        class Node {
            Node[] next;
            boolean isWord;
            public Node() {
                next = new Node[26];
                isWord = false;
            }
        }

        public void put(String word) {
            root = put(root, word, 0);
        }

        private Node put(Node x, String word, int d) {
            if (x == null) {
                x = new Node();
            }
            if (d == word.length()) {
                x.isWord = true;
                return x;
            }
            char c = word.charAt(d);
            x.next[c-97] = put(x.next[c-97], word, d+1);
            return x;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie t = createTrieFromWords(words);
        int m = board.length;
        int n = board[0].length;
        boolean[][] buffer = new boolean[m][n];
        Set<String> result = new HashSet<>();
        Trie.Node root ;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (t.root.next[board[i][j] - 97] != null) {
                    root = t.root.next[board[i][j] - 97];
                    exist(board, board[i][j]+"", root, i, j, result);
                }

            }
        }

        return new ArrayList<>(result);
    }

    private void exist(char[][] board, String curr, Trie.Node t, int rowIndex, int colIndex, Set<String> result) {

        char c = board[rowIndex][colIndex];

        if (t.isWord) {
            result.add(curr);
        }

        board[rowIndex][colIndex] = '#' ;

        if (rowIndex < board.length - 1  && board[rowIndex+1][colIndex] != '#' && t.next[board[rowIndex+1][colIndex]-97] != null) {
            exist(board, curr + board[rowIndex+1][colIndex], t.next[board[rowIndex+1][colIndex]-97], rowIndex+1, colIndex, result);
        }

        if (rowIndex > 0 && board[rowIndex-1][colIndex] != '#' && t.next[board[rowIndex-1][colIndex]-97] != null) {
            exist(board, curr + board[rowIndex-1][colIndex], t.next[board[rowIndex-1][colIndex]-97], rowIndex-1, colIndex, result);
        }

        if (colIndex < board[0].length - 1 &&  board[rowIndex][colIndex+1] != '#' && t.next[board[rowIndex][colIndex+1]-97] != null) {
            exist(board, curr + board[rowIndex][colIndex+1], t.next[board[rowIndex][colIndex+1]-97], rowIndex, colIndex+1, result);
        }

        if (colIndex > 0 &&  board[rowIndex][colIndex-1] != '#' && t.next[board[rowIndex][colIndex-1]-97] != null) {
            exist(board, curr + board[rowIndex][colIndex-1], t.next[board[rowIndex][colIndex-1]-97], rowIndex, colIndex-1, result);
        }

        board[rowIndex][colIndex] = c;
    }

    private Trie createTrieFromWords(String[] words) {
        Trie t = new Trie();
        for (String word : words) {
            t.put(word);
        }
        return t;
    }

    public static void main(String[] args) {
        String[] words = {"oath","pea","eat","rain"};
        char[][] board = {{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};
//        String[] words = {"a"};
//        char[][] board = {{'a'}};
        System.out.println(new WordSearchII().findWords(board,words));
    }
}
