package com.leetcode.arrays;

import java.util.PriorityQueue;

/**
 * Created by Dhaval on 1/13/2017.
 */
public class KthLargestMatrix {
    public int kthSmallest(int[][] matrix, int k) {

        class Tuple implements Comparable<Tuple> {
            int x;
            int y;
            int val;
            public Tuple(int x, int y, int val) {
                this.x = x;
                this.y = y;
                this.val = val;
            }

            public int compareTo(Tuple that) {
                return this.val - that.val;
            }
        }

        if (matrix == null) {
            throw new NullPointerException();
        }

        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(new Tuple(0, i, matrix[0][i]));
        }

        for (int i = 0; i < k - 1; i++) {
            Tuple t = pq.poll();
            if (t.x == n-1) continue;
            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return pq.peek().val;


    }

    public static void main(String[] args) {
        int[][] inp = {{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(new KthLargestMatrix().kthSmallest(inp, 8));
    }

}
