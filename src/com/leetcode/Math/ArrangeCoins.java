package com.leetcode.Math;

/**
 * Created by Dhaval on 1/1/2017.
 */
public class ArrangeCoins {
    public int arrangeCoins(int n) {

        int start = 0;
        int end = n;
        int mid = 0;
        while (start <= end){
            mid = start + (end - start)/2;
            if ((0.5 * mid * mid + 0.5 * mid ) <= n){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start - 1;

    }

    public static void main(String[] args) {
        System.out.println(new ArrangeCoins().arrangeCoins(6));
    }
}
