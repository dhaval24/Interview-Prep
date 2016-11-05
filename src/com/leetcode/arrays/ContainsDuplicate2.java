package com.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dhaval on 6/22/2016.
 * Given an array of integers and an integer k, find out whether there
 * are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 *
 * Approach : Use Hashset with Sliding window strategy
 */
public class ContainsDuplicate2 {

    public static boolean hasDuplicates(int[]nums, int k) {

        Set<Integer> set = new HashSet<>();
        for(int i  = 0; i < nums.length; i++){

            if(i-k > 0){
                set.remove(nums[i-k-1]);
            }
            if(!set.add(nums[i])){
                return true;
            }

        }
        return false;
    }

    public boolean containsNearbyDuplicateWOHashSet(int[] nums, int k) {

        int len = nums.length;
        int[][] buffer = new int[3][len];
        for (int i = 0; i < len; i++) {
            int curr = nums[i];
            int hash = curr % len;
            hash = hash >= 0 ? hash : hash + len;
            if (buffer[0][hash] == 0) {
                buffer[1][hash] = curr;
                buffer[2][hash] = i;
                buffer[0][hash] = 1;
            }
            else {
                if (buffer[1][hash] == curr && (i - buffer[2][hash]) <= k) return true;
                int j = hash + 1;
                while (j != hash) {
                    if (j == len) {
                        j = 0;
                    }
                    if (buffer[0][j] == 0) {
                        buffer[1][j] = curr;
                        buffer[0][j] = 1;
                        buffer[2][j] = i;
                        break;
                    }
                    else {
                        if (buffer[1][j] == curr && (j - buffer[2][j]) <= k) {
                            return true;
                        }
                    }
                    j++;
                }
                if (j == hash) {
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {

        int a[] = {10, 5 , 6, 2, 5};
        System.out.println(hasDuplicates(a, 2));
    }
}
