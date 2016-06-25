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

    public static void main(String[] args) {

        int a[] = {10, 5 , 6, 2, 5};
        System.out.println(hasDuplicates(a));
    }
}
