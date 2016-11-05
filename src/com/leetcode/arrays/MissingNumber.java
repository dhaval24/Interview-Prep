package com.leetcode.arrays;

/**
 * Created by Dhaval on 10/24/2016.
 */
public class MissingNumber {

    public int missingNumber(int[] a) {

        int xor = 0;
        int len = a.length;
        for (int i = 0; i < len; i++) {
            xor ^= (i+1) ^ a[i];
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,3};
        System.out.println(new MissingNumber().missingNumber(arr));
    }
}
