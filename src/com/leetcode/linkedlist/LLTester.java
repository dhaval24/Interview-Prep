package com.leetcode.linkedlist;

/**
 * Created by Dhaval on 9/25/2016.
 */
public class LLTester {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.insertAtLast(i);
        }
        list.insert(10, 0);
        list.delete(0);
        list.delete(1);
        list.delete(3);
        list.delete(1);

        for (int A : list) {
            System.out.println(A);
        }
    }
}
