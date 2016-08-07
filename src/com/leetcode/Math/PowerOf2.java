package com.leetcode.Math;

/**
 * Created by Dhaval on 7/26/2016.
 * Given a number n determine if it is power of 2
 *
 * algo: A number which is power of 2 is positive and has only 1 set bit in
 * its binary representation.
 * Or n is positive and its & operation with n-1 == 0
 */
public class PowerOf2 {

    public boolean isPowerOfTwo(int n) {

        if( (n < 0) || (Integer.bitCount(n) != 1 ) ) return false;
        return true;
    }

    public boolean isPowerOfTwoBitMan(int n) {

        return (n > 0 && (n & n-1) == 0);
    }

    public static void main(String[] args) {
        System.out.println(new PowerOf2().isPowerOfTwo(4));
    }
}
