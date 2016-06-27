package com.leetcode.arrays;

import java.util.Arrays;

/**
 * Created by Dhaval on 6/26/2016.
 * Given a sorted array remove duplicates and return the length
 * of new array with non-duplicate elements in order.
 * Eg. 1, 1, 2, 3, 4, 4, 5 - > 1, 2, 3, 4, 5 and return 5
 */
public class RemoveDuplicatesSortedArray {

    public int removeDuplicates(int[] a) {

        int count = 1;
        int len = a.length;
        if(len < 2) {
            return 1;
        }
        for (int i = 1; i < len; i++) {

            if(a[i] != a[i-1]) {
                a[count++] = a[i];
            }
        }
        System.out.println(Arrays.toString(a));
        return count;
    }

    public static void main(String[] args) {

        int[] a = {1, 1, 2, 2, 3 ,4 ,4, 5};
        System.out.println(new RemoveDuplicatesSortedArray().removeDuplicates(a));
    }
}
