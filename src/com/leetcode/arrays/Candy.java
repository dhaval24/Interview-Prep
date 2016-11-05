package com.leetcode.arrays;

/**
 * Created by Dhaval on 9/30/2016.
 */
public class Candy {

    public int candy(int[] ratings) {

        int len = ratings.length;
        if (len < 1) { return 0;}
        int[] candies = new int[len];
        candies[0] = 1;
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1]+1;
            }
            else {
                candies[i] = 1;
            }
        }

        int minCandies = candies[len-1];
        for (int i = len - 2; i >= 0; i--) {

            if (ratings[i] > ratings[i+1] && candies[i] <= candies[i+1]) {
                candies[i] = candies[i+1]+1;
            }
            minCandies += candies[i];
        }
        return minCandies;

    }
    public static void main(String[] args) {
        System.out.println(new Candy().candy(new int[]{58,21,72,77,48,9,38,71,68,77,82,47,25,94,89,54,26,54,54,99,64,71,76,63,81,82,60,64,29,51,87,87,72,12,16,20,21,54,43,41,83,77,41,61,72,82,15,50,36,69,49,53,92,77,16,73,12,28,37,41,79,25,80,3,37,48,23,10,55,19,51,38,96,92,99,68,75,14,18,63,35,19,68,28,49,36,53,61,64,91,2,43,68,34,46,57,82,22,67,89}));
    }
}
