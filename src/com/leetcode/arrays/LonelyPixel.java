package com.leetcode.arrays;

/**
 * Created by Dhaval on 3/5/2017.
 */
public class LonelyPixel {
    public int findLonelyPixel(char[][] picture) {
        if (picture == null || picture[0].length == 0) {
            throw new IllegalArgumentException();
        }
        int m = picture.length;
        int n = picture[0].length;
        int[] rowBuffer = new int[m];
        int[] colBuffer = new int[n];
        populateRowColBuffers(picture, rowBuffer, colBuffer);
        int lonPixel = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B' && rowBuffer[i] == 1 && colBuffer[j] == 1) {
                    lonPixel++;
                }
            }
        }
        return lonPixel;
    }

    private void populateRowColBuffers(char[][] picture, int[] rowBuffer, int[] colBuffer) {
        int m = rowBuffer.length;
        int n = colBuffer.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    rowBuffer[i]++;
                    colBuffer[j]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] inp = {{'W','W','B'}, {'W', 'B', 'B'}, {'W', 'W', 'B'}};
        System.out.println(new LonelyPixel().findLonelyPixel(inp));
    }
}
