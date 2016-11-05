package com.leetcode.arrays;

/**
 * Created by Dhaval on 8/4/2016.
 */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (target >= matrix[i][0] && target < matrix[i][n-1]) {
                return binSearch(matrix[i], target);
            }
        }
        return false;
    }

    private boolean binSearch(int[] column, int target) {

        int start = 0;
        int end = column.length - 1;

        while (start <= end) {

            int mid = start + (end - start)/2;
            if (column[mid] == target) return true;
            if (column[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }


}
