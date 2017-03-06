package com.leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dhaval on 3/4/2017.
 * Given two sparse matrices A and B, return the result of AB.

 You may assume that A's column number is equal to B's row number.

 Example:

 A = [
 [ 1, 0, 0],
 [-1, 0, 3]
 ]

 B = [
 [ 7, 0, 0 ],
 [ 0, 0, 0 ],
 [ 0, 0, 1 ]
 ]


      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                   | 0 0 1 |
 */
public class SparseMatrixMultiplication {

    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A[0].length == 0 || B == null || B.length == 0) {
            throw new IllegalArgumentException();
        }
        int row = A.length;
        int col = A[0].length;
        int row1 = col;
        int col1 = B[0].length;
        int[][] result = new int[row][col1];
        Map<Integer, Map<Integer, Integer>> tableB = new HashMap<>();
        for (int i = 0; i < row1; i++) {
            tableB.put(i, new HashMap<>());
            for (int j = 0; j < col1; j++) {
                if (B[i][j] != 0) {
                    tableB.get(i).put(j , B[i][j]);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] != 0) {
                    for (Integer k : tableB.get(j).keySet()) {
                        result[i][k] += A[i][j] * tableB.get(j).get(k);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] A = {{1,0,0}, {-1,0,3}};
        int[][] B = {{7,0,0},{0,0,0},{0,0,1}};
        SparseMatrixMultiplication sp = new SparseMatrixMultiplication();
        int[][] result = sp.multiply(A, B);
        for (int[] X : result) {
            System.out.println(Arrays.toString(X));
        }
    }
}
