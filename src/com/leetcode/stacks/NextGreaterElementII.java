package com.leetcode.stacks;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Dhaval on 2/11/2017.
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null) throw new NullPointerException();
        int[] result = new int[nums.length];
        Arrays.fill(result, Integer.MIN_VALUE);
        Stack<Integer> st = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            if (st.isEmpty()) {
                st.push(i);
                q.add(nums[i]);
            }
            else {

                if (nums[i] > nums[st.peek()]) {
                    q.add(nums[i]);
                }

                while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                    result[st.pop()] = nums[i];
                }

                st.push(i);
            }
        }
        int i = nums.length - 1;
        while (i >= 0 && !q.isEmpty()) {
            if (result[i] == Integer.MIN_VALUE && q.peek() > nums[i]) {
                result[i] = q.peek();
                i--;
            }
            else if (q.peek() <= nums[i]){
                q.remove();
            }
            else {
                i--;
            }
        }

        for (int k = 0; k < result.length; k++) {
            if (result[k] == Integer.MIN_VALUE) result[k] = -1;
        }
        return result;
    }

    public int[] nextGreaterElementsMethod2(int[] nums) { //Solved as typical array rotation problem
        int n = nums.length, next[] = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>(); // index stack
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                next[stack.pop()] = num;
            if (i < n) stack.push(i);
        }
        return next;
    }


    public static void main(String[] args) {
        int[] A = {3,-2,-1};
        System.out.println(Arrays.toString(new NextGreaterElementII().nextGreaterElements(A)));
    }
}
