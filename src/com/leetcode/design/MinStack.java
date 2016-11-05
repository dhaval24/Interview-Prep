package com.leetcode.design;

import java.util.Stack;

/**
 * Created by Dhaval on 8/8/2016.
 */
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> stackMin;

    public MinStack() {
        stack = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int x) {

        stack.push(x);
        if (stackMin.isEmpty() || stackMin.peek() >= x) {
            stackMin.push(x);
        }
    }

    public int pop() {

        if (stack.isEmpty()) {
            throw new NullPointerException();
        }
        int result = stack.pop();
        if (stackMin.peek() == result) {
            stackMin.pop();
        }
        return result;

    }

    public int top() {

        if (stack.isEmpty()) {
            throw new NullPointerException();
        }
        return stack.peek();
    }

    public int getMin() {

        if (stackMin.isEmpty()) {
            throw new NullPointerException();
        }
        return stackMin.peek();
    }

    public static void main(String[] args) {

        MinStack s = new MinStack();
        s.push(10);
        s.push(15);
        System.out.println(s.pop());
        System.out.println(s.getMin());
        System.out.println(s.top());
        System.out.println(s.pop());
    }
}
