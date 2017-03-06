package com.leetcode.design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Dhaval on 2/24/2017.
 */
public class MovingAverage {

    /** Initialize your data structure here. */
    Queue<Integer> q;
    int sum;
    int size;
    public MovingAverage(int size) {
        q = new LinkedList<>();
        sum = 0;
        this.size = size;
    }

    public double next(int val) {
        if (q.size() < size) {
            q.add(val);
        }
        else {
            sum -= q.remove();
            q.add(val);
        }
        sum += val;
        return ((double)sum)/q.size();
    }
}
