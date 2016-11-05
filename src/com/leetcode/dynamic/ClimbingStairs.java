package com.leetcode.dynamic;

/**
 * Created by Dhaval on 8/14/2016.
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {

    public int climbStairs(int n) {

        if (n == 1) return 1;
        if (n == 2) return 2;
        int curr = 1;
        int curr1 = 2;
        int counter = 2;
        while (counter < n) {
            int temp = curr + curr1;
            curr = curr1;
            curr1 = temp;
            counter++;
        }
        return curr1;
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(5));
    }
}
