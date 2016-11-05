package com.leetcode.arrays;

import java.util.Stack;

/**
 * Created by Dhaval on 10/21/2016.
 * This is the minstack implementation using single stack
 * The idea is we store the difference between the min value and current value in the stack
 * and when we pop or have a peep operation we add the min value to the value poped from the stack to
 * return the actual value.
 * The value stored in the stack might also be negative as min needs to be updated
 * Whenever we pop a value from the stack which is negative that means we have popped a min value and therefore
 * we need to update our min variable by subtracting min with value popped which gives second smallest in the stack.
 * */
public class MinStackImpl2 {

    long min;
    Stack<Long> stack;

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        }
        else {
            stack.push(x-min); //can be negative as min can be updated
            if (x < min) {
                min = x;
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new NullPointerException();
        }

        long val = stack.pop();
        if (val < 0) min = min - val; // Increase the min as min is removed from the stack
    }

    public int min() {
        return (int)min;
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new NullPointerException();
        }
        long val = stack.pop();
        if (val < 0) return (int)min;
        else return (int)(val+min); //as we store the difference
    }
}
