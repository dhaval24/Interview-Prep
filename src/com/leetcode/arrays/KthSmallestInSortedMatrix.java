package com.leetcode.arrays;

/**
 * Created by Dhaval on 2/25/2017.
 */
public class KthSmallestInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[m-1][m-1];

        while (lo < hi) {
            int mid = lo + (hi - lo)/2;
            int count = count(matrix, mid);
            if (count < k) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        return hi;
    }

    private int count(int[][] matrix, int target) {
        int m = matrix.length;
        int i = m - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < m) {
            if (matrix[i][j] <= target) {
                count += i+1;
                j++;
            }
            else {
                i--;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        KthSmallestInSortedMatrix k = new KthSmallestInSortedMatrix();
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(k.kthSmallest(matrix, 8));
    }
}
