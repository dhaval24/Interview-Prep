package com.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dhaval on 7/29/2016.
 *  Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

 Algo: 2 Set approach.
 1. Add elements of array 1 in a set.
 2. Iterate over second array, see if the element is present in set1 and if so add it to set 2.
 3. Convert set2 to array and return
 */
public class ArrayIntersection1 {

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int count = 0;
        for (int num : intersect){
            result[count++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,3};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(new ArrayIntersection2().intersect(nums1, nums2)));
    }
}
