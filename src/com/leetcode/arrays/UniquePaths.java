package com.leetcode.arrays;

/**
 * Created by Dhaval on 8/2/2016.
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?

 Algorithm : Approach 1 Combinatorial solution: (n+m-2)C(n-1) as for each row there can be m+n-2 paths moving right
 and n-1 path moving down. For avoiding overflow do only the required calculations while calculating combinations
 O(n) solution with O(1) space

 Approach 2: DP O(n^2) solution with O(n^2) space
 1. Initialize a m*n buffer grid with left most column and top most rows set as 1.
 Iterate over the buffer grid starting from row 1 and column 1.
 The UniquePaths[i][j] = Uniquepaths[i-1][j]+UniquePaths[i][j-1]
 Return the value of buffer[m-1][n-1]
 */
public class UniquePaths {

    public int uniquePathsCombinatorial(int m, int n) {

        int num = m+n-2; // excluding top row and left column
        int r = n-1; //
        int len = num - r; // total length to loop until
        int div = num - r;
        double product = 1;
        for (int i = 0; i < len; i++){
            product *= (num--/(double)div--); // only calculating the required portion.
        }
        return (int)Math.round(product); //rounding of the result to return integer value

    }

    public int uniquePathsDP(int m, int n) {

        int[][] buffer = new int[m][n];
        initializeGrid(buffer, m, n);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                buffer[i][j] = buffer[i][j-1] + buffer[i-1][j];
            }
        }
        return buffer[m-1][n-1];

    }

    private void initializeGrid(int[][] buffer, int rows, int columns) {

        int len = rows > columns ? rows : columns;
        for (int i = 0; i < len; i++) {
            buffer[i % rows][0] = 1;
            buffer[0][i % columns] = 1;
        }
    }

    public static void main(String[] args) {

        System.out.println(new UniquePaths().uniquePathsCombinatorial(4,6));
        System.out.println(new UniquePaths().uniquePathsDP(3,3));
    }
}
