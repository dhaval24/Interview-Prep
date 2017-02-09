package com.leetcode.arrays;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by Dhaval on 11/12/2016.
 */
public class KLargestMinHeap {

    public int findKthLargest(int[] nums, int k) {

        int len = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for (int i = k; i < len; i++) {
            if (pq.peek() < nums[i]) {
                pq.remove();
                pq.add(nums[i]);
            }
        }
        return pq.peek();

    }


    public int findKthLargest1(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) return nums[0];
        randomShuffle(nums);
        int maxNo = len - k ;
        int lo = 0;
        int hi = len - 1;
        while (hi > lo) {
            int j = partition(nums, lo, hi);
            if (j > maxNo) hi = j - 1;
            else if (j < maxNo) lo = j + 1;
            else return nums[maxNo];
        }
        return nums[maxNo];
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (nums[++i] < nums[lo])
                if (i == hi) break;
            while (nums[lo] < nums[--j])
                if (j == lo) break;
            if (i >= j) break;
            swap(nums, i , j);
        }
        swap(nums, lo, j);
        return j;
    }

    private void randomShuffle(int[] nums) {
        Random r = new Random();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            swap(nums, i, r.nextInt(i+1));
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
//        int[] inp = new int[1000000];
//        Random random = new Random();
//        for (int i = 0; i < 1000000; i++) {
//            inp[i] = random.nextInt() % 10000000;
//        }
        int[] inp = {3,2,1,5,6,4};
        //int k = Math.abs(random.nextInt() % 1000000);
        int k = 2;
        System.out.println(k);
        long start = System.currentTimeMillis();
        System.out.println(new KLargestMinHeap().findKthLargest(inp, k));
        System.out.println("time " + (System.currentTimeMillis()-start));

//        start = System.currentTimeMillis();
//        System.out.println(new KLargestMinHeap().findKthLargest1(inp, k));
//        System.out.println("time " + (System.currentTimeMillis()-start));
    }
}
