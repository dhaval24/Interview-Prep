package com.leetcode.arrays;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Dhaval on 11/17/2016.
 */
public class WordLadder {

    private class WordNode {
        int steps;
        String word;

        public WordNode(int steps, String word) {
            this.steps = steps;
            this.word = word;
        }
    }

    public int oneDirectionBFS(String beginWord, String endWord, Set<String> wordDict) {
        Queue<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(1, beginWord));
        wordDict.add(endWord);
        while (!queue.isEmpty()) {
            WordNode top = queue.remove();
            String topWord = top.word;
            if (topWord.equals(endWord)) {
                return top.steps;
            }

            char[] topArr = topWord.toCharArray();
            for (int i = 0; i < topArr.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char temp = topArr[i];
                    if(topArr[i] != c) {
                        topArr[i] = c;
                    }
                    String newWord = new String(topArr);
                    if (wordDict.contains(newWord)) {
                        queue.add(new WordNode(top.steps+1, newWord));
                        wordDict.remove(newWord);
                    }
                    topArr[i] = temp;
                }
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");
        System.out.println(new WordLadder().oneDirectionBFS("hit", "cog", set));
    }
}
