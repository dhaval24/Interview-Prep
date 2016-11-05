package com.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dhaval on 6/2/2016.
 * Given an array of numbers return true if it has
 * a duplicate
 * Sol : Hashset Approach
 */
public class ContainsDuplicate {

    public static boolean hasDuplicates(int[] nums){

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            if(!set.add(nums[i])){
                return true;
            }
        }

        return false;
    }
    public boolean containsDuplicateWithoutHashSet(int[] nums) {

        int len = nums.length;
        int[][] buffer = new int[2][len];
        for (int i = 0; i < len; i++) {
            int curr = nums[i];
            int hash = curr % len;
            hash = hash >= 0 ? hash : hash + len;
            if (buffer[0][hash] == 0) {
                buffer[1][hash] = curr;
                buffer[0][hash] = 1;
            }
            else {
                if (buffer[1][hash] == curr) return true;
                int j = hash + 1;
                while (j != hash) {
                    if (j == len) {
                        j = 0;
                    }
                    if (buffer[0][j] == 0) {
                        buffer[1][j] = curr;
                        buffer[0][j] = 1;
                        break;
                    }
                    else {
                        if (buffer[1][j] == curr) {
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
        System.out.println(hasDuplicates(a));
    }
}
