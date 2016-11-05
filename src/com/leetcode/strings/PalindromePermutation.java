package com.leetcode.strings;

/**
 * Created by Dhaval on 8/30/2016.
 */
public class PalindromePermutation {

    public boolean hasPalindromePermutation(String s) {
        int[] buffer = new int[256];
        char[] input = s.toCharArray();
        int len = input.length;
        for (int i = 0; i < len; i++) {
            int curr = input[i];
            //if (curr == ' ') continue;
            if (buffer[curr] == 0) {
                buffer[curr]++;
            }
            else {
                buffer[curr]--;
            }
        }
        int noOnes = 0;
        for (int i = 0; i < 256; i++) {
            if (buffer[i] == 1) {
                noOnes++;
            }
        }
        if (noOnes == 0 || noOnes == 1) {
            return true;
        }
        return false;
    }

    public boolean hasPalindromPermutationSinglePass(String s) {

        int[] table = new int[256];
        char[] input = s.toCharArray();
        int len = input.length;
        int oddCount = 0;
        for (int i = 0; i < len; i++) {
            int curr = s.charAt(i);
            table[curr]++;
            if (table[curr] % 2 == 1) {
                oddCount++;
            }
            else {
                oddCount--;
            }

        }
        return (oddCount == 0 || oddCount == 1);
    }
    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(new PalindromePermutation().hasPalindromePermutation("tact coa"));
        System.out.println("Time method 1 " + (System.nanoTime() - start));
        start = System.nanoTime();
        System.out.println(new PalindromePermutation().hasPalindromPermutationSinglePass("tact coa"));
        System.out.println("Time method 2 " + (System.nanoTime() - start));
    }
}
