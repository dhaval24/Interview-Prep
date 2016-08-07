package com.leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dhaval on 7/29/2016.
 *  Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 Algorithm: Sorting and 2 pointer approach
 1. Sort both the arrays
 2. move pointers of whichever number is smaller
 3. If number at both pointers are equal move both the pointers

 Algo2: HashMap approach:
 1. Create a hashmap of 1st array and store count of each key(key is the numbers in the array)
 2. Iterate through the second list see if the key is present in the map and if so get its count
 if count > 0 then add it to intersection and reduce the count by 1
 */
public class ArrayIntersection2 {
    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> result = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        while (p1 < len1 && p2 < len2) {

            if (nums1[p1] > nums2[p2]) {
                p2++;
            }
            else if (nums1[p1] < nums2[p2]) {
                p1++;
            }
            else {
                result.add(nums1[p1]);
                p1++;
                p2++;
            }

        }
        int[] output = new int[result.size()];
        int count = 0;
        for (int num : result) {
            output[count++] = num;
        }
        return output;
    }

    //HashMap approach

    public int[] intersect1(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        for (int i = 0; i < len1; i++) {
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], 1);
            }
            else{
                map.put(nums1[i], map.get(nums1[i])+1);
            }
        }
        for (int i = 0; i < len2; i++) {
            if (map.containsKey(nums2[i])){
                if (map.get(nums2[i]) > 0) {
                    result.add(nums2[i]);
                    map.put(nums2[i], map.get(nums2[i])-1);
                }
            }
        }
        int[] output = new int[result.size()];
        int count = 0;
        for (int num : result) {
            output[count++] = num;
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,3};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(new ArrayIntersection2().intersect(nums1, nums2)));
    }
}
