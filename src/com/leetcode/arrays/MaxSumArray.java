package com.leetcode.arrays;

/**
 * Created by Dhaval on 8/16/2016.
 */
public class MaxSumArray {

    public int findMaxSum (int[] arr, int sum) {


        int currSum = arr[0];
        int start = 0;
        int n = arr.length;
        int maxLength = 0;

        // Pick a starting point
        for (int i = 1; i <= n; i++)  {

            // If currSum exceeds the sum, then remove the starting elements
            while (currSum > sum && start < i-1) {

                currSum -= arr[start];
                start++;
            }

            // If currSum becomes equal to sum, then return true
            if (currSum <= sum)
            {
                int p = i-1;
                maxLength = Math.max(maxLength, p - start + 1);
            }

            // Add this element to currSum
            if (i < n) currSum += arr[i];

        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSumArray().findMaxSum(new int[] {1,0,0,5}, 3));
    }
}
