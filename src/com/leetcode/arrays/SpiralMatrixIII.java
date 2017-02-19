package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhaval on 2/18/2017.
 */
public class SpiralMatrixIII {

    public List<Integer> spiralOrder(int[][] A) {

        if (A == null) throw new NullPointerException();
        int m = A.length;
        int n = A[0].length;
        int row = m % 2 == 0 ? (m/2 - 1) : m/2;
        int col = n % 2 == 0 ? (n/2 - 1) : n/2;
        boolean up = false;
        boolean left = false;
        List<Integer> result = new ArrayList<>();
        int count = 1;
        while ((row >= 0 && row < m) && (col >= 0 && col < n) && (result.size() < (m * n))) {
            if (!up) {
                int indx = row + count;
                while (row < m && row <= indx && (result.size() < (m * n))) {
                    result.add(A[row][col]);
                    row++;
                }
                row--;
                col++;
            }
            else {
                int indx = row - count;
                while (row >= 0 && row >= indx && (result.size() < (m * n))) {
                    result.add(A[row][col]);
                    row--;
                }
                row++;
                col--;
            }
            up = !up;
            if (!left) {
                int indx = col + count - 1;
                while (col < n && col <= indx && (result.size() < (m * n))) {
                    result.add(A[row][col]);
                    col++;
                }
                col--;
                row--;
            }
            else {
                int indx = col - count;
                while (col >= 0 && col >= indx && (result.size() < (m * n))) {
                    result.add(A[row][col]);
                    col--;
                }
                col++;
                row++;
            }
            left = !left;
            count++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(new SpiralMatrixIII().spiralOrder(A));
    }
}
