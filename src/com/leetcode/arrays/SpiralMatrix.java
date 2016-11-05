package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhaval on 8/8/2016.
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        if (m < 1) return result;
        int n = matrix[0].length;
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom || left <= right) {

            for (int i = left; i <= right && top <= bottom; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom && left <= right; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            for (int i  = right; i >= left && top <= bottom; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top && left <= right; i--) {
                result.add(matrix[i][left]);
            }

            left++;

        }

        return result;
    }

    public static void main(String[] args) {

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(new SpiralMatrix().spiralOrder(matrix));
    }
}
