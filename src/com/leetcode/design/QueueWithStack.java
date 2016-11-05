package com.leetcode.design;

import java.util.Stack;

/**
 * Created by Dhaval on 8/28/2016.
 */
public class QueueWithStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> temp = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        peek();
        temp.pop();

    }

    // Get the front element.
    public int peek() {
        if (temp.isEmpty()) {
            while (!stack.isEmpty()) {
                temp.push(stack.pop());
            }
        }

        return temp.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty() && temp.isEmpty();
    }


    public static void main(String[] args) {

        QueueWithStack q = new QueueWithStack();
        q.push(1);
        q.push(2);
        System.out.println(q.peek());
        q.push(3);
        System.out.println(q.peek());

    }

}
