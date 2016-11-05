package com.leetcode.unionfind;

import java.util.Arrays;

/**
 * Created by Dhaval on 9/7/2016.
 */
public class NoIslands {

    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[] buffer = new int[m*n];
        int[] size = new int[m*n];
        Arrays.fill(size, 1);
        int count = 0;
        initializeBuffer(buffer);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                //This commented part is more optimized in terms of number of operations
//                if (i != 0 && j != 0 && grid[i][j] == '1') {
//                    if (grid[i-1][j] == '1') {
//                        union(buffer, size, findIndex(i, j, n), findIndex(i-1, j, n));
//                    }
//                    if (grid[i][j-1] == '1'){
//                        union(buffer, size, findIndex(i, j,n), findIndex(i, j-1, n));
//                    }
//                }
//                if(i == 0 && j > 0 && grid[i][j] == '1') {
//                    if (grid[i][j-1] == '1') {
//                        union(buffer, size, findIndex(i, j,n), findIndex(i, j-1, n));
//                    }
//                }
//                if (i > 0 && j == 0 && grid[i][j] == '1') {
//                    if (grid[i-1][j] == '1') {
//                        union(buffer, size, findIndex(i, j,n), findIndex(i-1, j, n));
//                    }
//                }
                if (grid[i][j] == '1') {
                    int temp = findIndex(i, j, m);
                    if (inside(i-1, j, m, n) && grid[i-1][j] == '1') union(buffer, size, temp, temp-n);
                    if (inside(i, j-1, m, n) && grid[i][j-1] == '1') union(buffer, size, temp, temp-1);
                    if (inside(i+1, j, m, n) && grid[i+1][j] == '1') union(buffer, size, temp, temp+n);
                    if (inside(i, j+1, m, n) && grid[i][j+1] == '1') union(buffer, size, temp, temp+1);
                }

            }
        }

        for (int i = 0; i < m*n; i++) {
            //System.out.println("row "+ i/n);
            //System.out.println("col " + i%n);
            if (i == buffer[i] && grid[i/n][i%n] != '0') count++;
        }


        System.out.println(Arrays.toString(buffer));
        System.out.println(Arrays.toString(size));
        System.out.println(count);
        return count;
    }

    private void initializeBuffer(int[] buffer) {
        int len = buffer.length;
        for (int i = 0; i < len; i++) {
            buffer[i] = i;
        }
    }

    private boolean inside(int i, int j, int m, int n) {
        return (i >= 0 && j >= 0 && i < m && j < n);
    }

    private void union(int[] buffer, int[] size, int p, int q) {
        int rootP = findRoot(buffer, p);
        int rootQ = findRoot(buffer, q);
        if (size[rootP] >= size[rootQ]) {
            buffer[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        else {
            buffer[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }

    }

    private int findRoot(int[] buffer, int p) {

        while (p != buffer[p]) {
            buffer[p] = buffer[buffer[p]];
            p = buffer[p];
        }
        return p;
    }

    private int findIndex(int rowIndex, int colIndex, int rows) {
        return ((rowIndex * rows) + colIndex);
    }

    public static void main(String[] args) {

        char[][] array = {{'1','1','1','1','1','1','1','1','1','1'}, {'1','1','1','1','0','0','0','0','0','0'},
                {'1','1','1','0','0','0','0','1','1','1'},{'1','1','0','0','1','0','0','1','1','1'},
                {'1','0','1','0','0','1','1','0','0','0'},{'0','0','0','0','0','0','0','0','0','0'},
                {'0','0','0','0','0','0','0','0','0','0'},{'1','1','1','1','1','1','1','1','1','1'},
                {'0','0','0','0','0','0','0','0','0','0'},{'1','1','1','1','1','1','1','1','1','1'}};
        new NoIslands().numIslands(array);

    }

}
