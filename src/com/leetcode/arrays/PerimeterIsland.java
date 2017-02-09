package com.leetcode.arrays;

/**
 * Created by Dhaval on 11/20/2016.
 */
public class PerimeterIsland {

    public int islandPerimeter(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int totalPerimeter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    totalPerimeter += findPerimeterOfBlock(grid, i , j);
                }
            }
        }
        return totalPerimeter;
    }

    private int findPerimeterOfBlock(int[][] grid, int index1, int index2) {

        int total = 4;
        for (int i = index1 - 1; i <= index1+1; i++)  {
            for (int j = index2 - 1; j <= index2+1; j++) {
                if ((i >= 0 && i < grid.length && j >= 0 && j < grid[0].length)) {
                    if (!(((i == index1-1) && (j == index2-1)) || ((i == index1-1) && (j == index2+1)) || ((i == index1+1) && (j == index2-1)) ||
                            ((i == index1+1) && (j == index2+1)) || ((i == index1) && (j == index2)))) {
                        if (grid[i][j] == 1) {
                            total--;
                        }
                    }
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(new PerimeterIsland().islandPerimeter(grid));
    }
}
