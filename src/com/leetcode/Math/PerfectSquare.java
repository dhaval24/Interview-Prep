package com.leetcode.Math;

/**
 * Created by Dhaval on 9/22/2016.
 */
public class PerfectSquare {

    public boolean isPerfectSquare(int num) {

        // Perfect square follow a property 1 + 3 + 5 + 7.....
        int i = 1;
        while (num > 0) {

            num -= i;
            i += 2;
        }

        return num == 0;

    }


    //Bin search approach
    public boolean isPerfectSquareBinSearch(int num) {

        if (num <= 0) return false;
        if (num == 1) return true;
        int start = 1;
        int end = num/2;

        while (start <= end) {

            int mid = start + (end - start)/2;
            if (mid * mid == num) return true;
            int div = num/mid;
            if (div >= mid) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }

        }
        return false;
    }

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        System.out.println(new PerfectSquare().isPerfectSquareBinSearch(2147483647));
        //System.out.println(new PerfectSquare().isPerfectSquare(2147483647));
        long endTime = System.nanoTime();
        System.out.println("Time " + (endTime - startTime));


    }
}
