package com.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dhaval on 2/15/2017.
 */
public class LRUCacheII {

    private class Node {
        int val;
        int key;
        Node next, prev;
        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    public Node phead;
    public Node ptail;
    Map<Integer, Node> map;
    int capacity;
    int size;
    public LRUCacheII(int capacity) {
        phead = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
        ptail = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
        phead.next = ptail;
        ptail.prev = phead;
        map = new HashMap<>();
        this.capacity = capacity;
        size = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int val = (map.get(key)).val;
            moveToLast(map.get(key));
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Node x = new Node(key, value);
            if (map.size() < capacity) {
                map.put(key, x);
                insertAtLast(x);
            }
            else {
                map.put(key, x);
                map.remove(phead.next.key);
                remove(phead.next);
                insertAtLast(x);
            }
        }
        else {
            Node x = map.get(key);
            x.val = value;
            moveToLast(x);
            map.put(key, x);
        }
    }

    private void moveToLast(Node x) {
        remove(x);
        insertAtLast(x);
    }

    private void insertAtLast(Node x) {
        ptail.prev.next = x;
        x.prev = ptail.prev;
        x.next = ptail;
        ptail.prev = x;
    }

    private void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        x.prev = null;
        x.next = null;
    }


    public static void main(String[] args) {
        LRUCacheII lru = new LRUCacheII(1);
        lru.put(2,1);
        System.out.println(lru.get(2));
        lru.put(3,2);
        System.out.println(lru.get(2));
        System.out.println(lru.get(3));
    }

}
