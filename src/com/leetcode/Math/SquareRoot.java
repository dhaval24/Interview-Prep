package com.leetcode.Math;

/**
 * Created by Dhaval on 9/22/2016.
 */
public class SquareRoot {
    public int mySqrt(int num) {

        if (num <= 0) return 0;
        int start = 1;
        int end = num/2;
        int mid = 1;

        while (start <= end) {

            mid = start + (end - start)/2;
            if (mid * mid == num) return mid;
            int div = num/mid;
            if (div >= mid) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }

        }
        System.out.println(mid * mid);
        return (mid * mid <= num && mid * mid > 0) ? mid : mid - 1;

    }

    public static void main(String[] args) {
        System.out.println(new SquareRoot().mySqrt(1));
    }
}
