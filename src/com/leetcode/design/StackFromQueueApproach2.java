package com.leetcode.design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Dhaval on 10/22/2016.
 * push - O(n), pop - O(1)
 */
public class StackFromQueueApproach2 {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    int top;

    public void push(int x) {
        q2.add(x);
        top = x;
        while(!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1; //exchange queue to avoid transfer
        q1 = q2;
        q2 = temp;
    }

    public void pop() {
        q1.remove();
        top = q1.peek();
    }

    public int top() {
        return top;
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

}
