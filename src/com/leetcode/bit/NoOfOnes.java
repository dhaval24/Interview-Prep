package com.leetcode.bit;

/**
 * Created by Dhaval on 11/14/2016.
 */
public class NoOfOnes {
    public int hammingWeight(int n) {

        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NoOfOnes().hammingWeight(5));
    }
}

