package com.leetcode.dynamic;

/**
 * Created by Dhaval on 12/6/2016.
 */
public class BombEnemies {

    public int maxKilledEnemies(char[][] grid) {

        if (grid == null) {
            throw new NullPointerException();
        }

        int m = grid.length;
        int n = grid[0].length;
        int[] col = new int[n];
        int max = 0;
        int row = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 || grid[i-1][j] == 'W') {
                    col[j] = getEnemiesCols(grid, i, j);
                }

                if (j == 0 || grid[i][j-1] == 'w') {
                    row = getEnemiesRows(grid, i , j);
                }

                if (grid[i][j] == '0') {
                    max = Math.max(max, row + col[j]);
                }
            }
        }
        return max;
    }

    private int getEnemiesRows(char[][] grid, int i, int j) {

        int enemies = 0;
        for (int v = j; v < grid[0].length; v++) {
            if (grid[i][v] == 'W') break;
            if (grid[i][v] == 'E') enemies++;
        }
        return enemies;
    }

    private int getEnemiesCols(char[][] grid, int i, int j) {
        int enemies = 0;
        for (int v = i; v < grid.length; v++) {
            if (grid[v][j] == 'W') break;
            if (grid[v][j] == 'E') enemies++;
        }
        return enemies;
    }

    public static void main(String[] args) {

        char[][] grid = {{'0','E','0','0'}, {'E','0','W','E'}, {'0','E','0','0'}};
        System.out.println(new BombEnemies().maxKilledEnemies(grid));
    }

}
