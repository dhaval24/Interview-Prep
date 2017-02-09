package com.leetcode.bit;

/**
 * Created by Dhaval on 1/25/2017.
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        System.out.println(new HammingDistance().hammingDistance(2, 4));
    }
}
