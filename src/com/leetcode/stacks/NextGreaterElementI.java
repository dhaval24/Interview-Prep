package com.leetcode.stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Dhaval on 2/13/2017.
 */
public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        if (findNums == null || nums == null) throw new IllegalArgumentException();
        int[] result = new int[findNums.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && st.peek() < nums[i]) {
                map.put(st.pop(), nums[i]);
            }
            st.push(nums[i]);
        }

        for (int i = 0; i < findNums.length; i++) {
            if (map.containsKey(findNums[i])) {
                result[i] = map.get(findNums[i]);
            }
            else {
                result[i] = -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {5,2,1,4,3};
        System.out.println(Arrays.toString(new NextGreaterElementI().nextGreaterElement(nums1, nums2)));
    }
}
