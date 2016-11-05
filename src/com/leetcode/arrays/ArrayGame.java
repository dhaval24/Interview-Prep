package com.leetcode.arrays;

/**
 * Created by Dhaval on 9/27/2016.
 * The goal of this program is to make all numbers in an array the same. You have to increment all values in the array except for one each time.
 * Then the program will print out the minimum number of steps it would take to make all the numbers the same.
 */
public class ArrayGame {

    public int numberOfSteps(int[] a) {
        if( a.length==0 ) return 0;

        int min= a[0];
        int total = a[0];
        for(int i=1;i<a.length;i++) {
            if( a[i] < min ) min = a[i];
            total += a[i];
        }

        return total - a.length * min;
    }

    public static void main(String[] args) {
        System.out.println(new ArrayGame().numberOfSteps(new int[] {2,3,4,5}));

    }
}
