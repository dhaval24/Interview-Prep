package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Dhaval on 2/5/2017.
 *
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

 Define a pair (u,v) which consists of one element from the first array and one element from the second array.

 Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

 Return: [1,1],[1,1]

 The first 2 pairs are returned from the sequence:
 [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]


 Algorithm : 1. Create a min priority queue whose comparator would be sum of first element - sum of second element
 2. Insert first k pairs in PQ. The first K pairs which would be inserted would be combinations of nums1[i] and nums[0], 0 (index of element picked from
 because second array). they are the best possible combination for each number in first array
 3. remove k elements from pq. after removing a element add the next best combination which would be popped[0] and nums2[popped[2]+1]
 */
public class KSmallestPairs {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || k < 0) throw new IllegalArgumentException();
        List<int[]> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] temp = pq.poll();
            res.add(new int[]{temp[0], temp[1]});
            if (temp[2] == nums2.length - 1) continue;
            pq.add(new int[]{temp[0], nums2[temp[2]+1], temp[2]+1});
        }
        for (int[] A : res) {
            System.out.println(Arrays.toString(A));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 7 ,11};
        int[] nums2 = {2, 4 ,6};
        System.out.println(new KSmallestPairs().kSmallestPairs(nums1, nums2, 3));
    }

}
