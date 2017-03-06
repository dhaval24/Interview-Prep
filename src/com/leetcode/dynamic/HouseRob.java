package com.leetcode.dynamic;

/**
 * Created by Dhaval on 8/13/2016.
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

 Algo : 1. We maintain a 2D matrix of size[2][length+1]
 2. The 1 row of matrix counts for house not robbed.
 3. The 2 row of matrix counts for house robbed
 4. We iterate from i = 1 to i <= len and we update the not robbed row value by taking the max
 of robbed and not robbed values
 5. We update the robbed row by adding the value of array and the value of not robbed
 6. We return the max of robbed and not robbed.
 */
public class HouseRob {

    public int robDPMatrix(int[] nums) {

        int[][] dp = new int[2][nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1]);
            dp[1][i] = nums[i-1] + dp[0][i-1];
        }

        return Math.max(dp[0][nums.length], dp[1][nums.length]);
    }

    public int robDP(int[] nums) {
        if (nums == null) throw new NullPointerException();
        int[] buffer = new int[nums.length];
        if (nums.length == 1) return nums[0];
        buffer[0] = nums[0];
        buffer[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            buffer[i] = Math.max(buffer[i-2]+nums[i], buffer[i-1]);
        }
        return buffer[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new HouseRob().robDPMatrix(new int[] {2,1,1,2}));
        System.out.println(new HouseRob().robDP(new int[] {2,1,1,2}));
    }
}
