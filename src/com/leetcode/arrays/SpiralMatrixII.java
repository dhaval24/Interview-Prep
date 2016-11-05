package com.leetcode.arrays;

/**
 * Created by Dhaval on 8/8/2016.
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];
        int count = 1;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom || left <= right) {

            for (int i = left; i <= right && top <= bottom; i++) {
                matrix[top][i] = count;
                count++;
            }
            top++;
            for (int i = top; i <= bottom && left <= right; i++) {
                matrix[i][right] = count;
                count++;
            }
            right--;
            for (int i  = right; i >= left && top <= bottom; i--) {
                matrix[bottom][i] = count;
                count++;
            }
            bottom--;
            for (int i = bottom; i >= top && left <= right; i--) {
                matrix[i][left] = count;
                count++;
            }

            left++;

        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }

    public static void main(String[] args) {

        printMatrix(new SpiralMatrixII().generateMatrix(3));
    }
}
