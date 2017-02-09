package com.leetcode.arrays;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by Dhaval on 11/12/2016.
 */
public class ThirdMax {
    public int thirdMax(int[] nums) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.add(n)) {
                pq.add(n);
                if (pq.size() > 3) {
                    set.remove(pq.poll());
                }
            }
        }
        if (pq.size() < 3) {
            while (pq.size() > 1) {
                pq.remove();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        System.out.println(new ThirdMax().thirdMax(new int[]{1,2,2,5,3,5}));
    }
}
