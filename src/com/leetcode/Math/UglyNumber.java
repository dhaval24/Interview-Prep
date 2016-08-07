package com.leetcode.Math;

/**
 * Created by Dhaval on 7/26/2016.
 * Given a number it is ugly if its prime factors are only 2,3,5. Eg 39
 * is not a ugly number.
 */
public class UglyNumber {

    public boolean isUgly(int num) {

        if (num <= 0) return false;
        if (num == 1) return true;

        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumber().isUgly(39));
    }
}
