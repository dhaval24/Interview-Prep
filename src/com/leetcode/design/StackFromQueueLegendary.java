package com.leetcode.design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Dhaval on 10/22/2016.
 * Push - O(n), Pop - O(1)
 * after we perform push operation we invert the order of the queue so that the last pushed
 * element stays at the front
 * eg if queue has 1, 2 inside it already if we push 3 it becomes 1, 2, 3
 * after we invert order queue becomes 3, 2, 1 letting 3 be on the front to be removed.
 */
public class StackFromQueueLegendary {

    Queue<Integer> q1 = new LinkedList<>();

    public void push(int x) {
        q1.add(x);
        int size = q1.size();
        while (size > 1) {
            q1.add(q1.remove()); //inverting order
            size--;
        }
    }

    public void pop() {
        q1.remove();

    }

    public int top() {
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
