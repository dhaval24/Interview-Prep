package com.leetcode.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by Dhaval on 11/6/2016.
 * Algorithm : 1 We create an inner class called QueueNode which is used to store arrayIndex, index of the element in the particular array
 * and the value
 * 2. we make this comparable and override compareTo to perform comparison based on the value
 * 3. This data structure helps us in our implementation with PQ.
 * 4. We now add the first element of all k arrays in the PQ and also calculate the size of the result array at the same time
 * 5. We then repeatedly remove element from PQ and add it the node's result field to result array. We also check if there are any more elements
 * in the corresponding array of the node removed by examining its valueIndex field and if there are more elements in the array we add the next element
 * node in the PQ.
 * 6. We return the result array at the end.
 * 7. Complexity : - O(kn * log(k)) : kn - for exploring all elements and log(k) time to add element in PQ
 */
public class MergeKSorted {


    private class QueueNode implements Comparable<QueueNode> {

        int arrayIndex, valueIndex, value;

        public QueueNode(int arrayIndex, int valueIndex, int value) {
            this.arrayIndex = arrayIndex;
            this.valueIndex = valueIndex;
            this.value = value;
        }

        @Override
        public int compareTo(QueueNode o) {
            if (this.value  < o.value) return -1;
            else if (this.value > o.value) return +1;
            else return 0;
        }
    }


    public int[] merge(int[][] A) {
        if (A.length < 1) return null;
        int size = 0;
        PriorityQueue<QueueNode> pq = new PriorityQueue<>();
        for (int i = 0; i < A.length; i++) {
            size += A[i].length;
            if (A[i].length > 0) {
                pq.add(new QueueNode(i, 0, A[i][0]));
            }
        }
        int[] result = new int[size];
        for (int i = 0; !pq.isEmpty(); i++) {
            QueueNode n = pq.poll();
            result[i] = n.value;
            int newIndex = n.valueIndex + 1;
            if (newIndex < A[n.arrayIndex].length) {
                pq.add(new QueueNode(n.arrayIndex, newIndex, A[n.arrayIndex][newIndex]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] A = {{1,2,3}, {3,4,8}, {2,6}};
        System.out.println(Arrays.toString(new MergeKSorted().merge(A)));
    }
}
