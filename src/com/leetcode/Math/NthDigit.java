package com.leetcode.Math;

/**
 * Created by Dhaval on 9/22/2016.
 */
public class NthDigit {
    public int findNthDigit(int num) {

        if (num < 10) return num;
        long count = 9;
        int len = 1;
        int fiz = 1;
        while ((count * len) < num) {
            num -= (count * len);
            len++;
            fiz *= 10;
            count *= 10;
        }

        fiz += (num - 1)/len;
        String s = Integer.toString(fiz);
        return s.charAt((num-1)%len) - 48;


    }

    public static void main(String[] args) {
        System.out.println(new NthDigit().findNthDigit(1000000000));
    }
}
