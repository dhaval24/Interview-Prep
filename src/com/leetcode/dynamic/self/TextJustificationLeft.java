package com.leetcode.dynamic.self;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhaval on 3/3/2017.
 */
public class TextJustificationLeft {

    public List<String> fullJustify(String[] words, int maxWidth) {

        if (words == null || maxWidth < 0) throw new IllegalArgumentException();
        int[][] buffer = new int[words.length][words.length];
        populateCostMatrix(words, buffer, maxWidth);
        int[] minCost = new int[words.length];
        int[] result = new int[words.length];
        for (int i = words.length - 1; i >= 0; i--) {
            minCost[i] = buffer[i][words.length-1];
            result[i] = words.length;
            for (int j = words.length - 1; j > i; j--) {
                if (buffer[i][j-1] == Integer.MAX_VALUE) continue;
                if (minCost[i] > minCost[j] + buffer[i][j-1]) {
                    minCost[i] = minCost[j] + buffer[i][j-1];
                    result[i] = j;
                }
            }
        }
        List<String> res = new ArrayList<>();
        int i = 0;
        int j = result[i];
        while (j < words.length) {
            j = result[i];
            StringBuilder sb = new StringBuilder();
            for (int k = i; k < j; k++) {
                sb.append(words[k] + " ");
            }
            res.add(sb.toString());
            i = j;

        }
        return res;
    }

    private void populateCostMatrix(String[] words, int[][] buffer, int width) {
        for (int i = 0; i < words.length; i++) {
            buffer[i][i] = width - words[i].length();
            for (int j = i+1; j < words.length; j++) {
                buffer[i][j] = buffer[i][j-1] - words[j].length() - 1;
            }
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length; j++) {
                if (buffer[i][j] < 0) {
                    buffer[i][j] = Integer.MAX_VALUE;
                }
                else {
                    buffer[i][j] = (int)Math.pow(buffer[i][j], 2);
                }
            }
        }
    }

    public static void main(String[] args) {
        TextJustificationLeft tj = new TextJustificationLeft();
        String[] inp = {"Tushar", "Roy", "likes", "to", "code"};
        System.out.println(tj.fullJustify(inp, 10));
    }

}
