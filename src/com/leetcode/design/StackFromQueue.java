package com.leetcode.design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Dhaval on 8/28/2016.
 * push() - O(1) and pop O(n)
 */
public class StackFromQueue {

    Queue<Integer> queue = new LinkedList<>();
    Queue<Integer> temp = new LinkedList<>();
    int top;
    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
        top = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        while (queue.size() > 1) {
            top = queue.remove();
            temp.add(top);
        }
        queue.remove();
        Queue<Integer> q = queue;
        queue = temp;
        temp = q;

    }

    // Get the top element.
    public int top() {
        //return queue.peek();
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty() && temp.isEmpty();
    }

}
