package com.leetcode.Math;

/**
 * Created by Dhaval on 7/26/2016.
 * Given a number find number of trailing 0's in its factorial
 * 5! = 120 has 1 trailing zeros
 *
 * Algorithm : 0 can be acheived only by paris of 5*2. Bottle neck is
 * that there would always be less number of 5's than 2's in the prime
 * factorization of any number's factorial. Therefore recursively
 * divide the number by 5 and add the quotient in the count until
 * the number == 0
 */
public class TrailingZeros {
    public int getTrailingZeroes(int n) {

        return getTrailingZeroes(0,n);
    }

    private int getTrailingZeroes(int sum, int n) {

        if (n == 0) return sum;
        n = n/5;
        return getTrailingZeroes(sum+=n, n);
    }

    public static void main(String[] args) {
        System.out.println(new TrailingZeros().getTrailingZeroes(20));
    }
}
