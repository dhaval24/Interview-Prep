package com.leetcode.design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dhaval on 10/3/2016.
 */
public class LRUCache {

    private Map<Integer, LinkedListNode> map;
    private LinkedListNode head;
    private LinkedListNode tail;
    int capacity;

    private class LinkedListNode {

        LinkedListNode next;
        LinkedListNode prev;
        int value;
        int key;

        public LinkedListNode(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }


    public LRUCache(int capacity) {

        this.capacity = capacity;
        map = new HashMap<>();
        head = null;
        tail = null;

    }

    public int get(int key) {

        if (map.containsKey(key)) {

            LinkedListNode returnNode = map.get(key);
            moveNodeToLast(returnNode);
            addNodeToTail(returnNode);
            return returnNode.value;
        }
        else {
            return -1;
        }
    }

    public void set(int key, int value) {

        LinkedListNode nodeToAdd = new LinkedListNode(key, value);

        if (!map.containsKey(key)) {

            if (map.size() < capacity) {
                map.put(key, nodeToAdd);
                addNodeToTail(nodeToAdd);
            }
            else {
                int keyRemoved = removeNodeFromHead();
                map.remove(keyRemoved);
                addNodeToTail(nodeToAdd);
                map.put(key, nodeToAdd);
            }
        }
        else {
            LinkedListNode nodeToUpdate = map.get(key);
            nodeToUpdate.value = value;
            moveNodeToLast(nodeToUpdate);
            addNodeToTail(nodeToUpdate);
        }

    }

    private int removeNodeFromHead() {


        if (head != null && head == tail) {
            int val = head.value;
            head = head.next;
            tail = tail.next;
            return val;
        }
        else if (head != null && head != tail){
            int val = head.value;
            head = head.next;
            return val;
        }
        else {
            return -1;
        }

    }

    private void addNodeToTail(LinkedListNode nodeToAdd) {

        if ((head == tail) && tail == null) {
            head = nodeToAdd;
            tail = nodeToAdd;
        }
        else {
            nodeToAdd.prev = tail;
            tail.next = nodeToAdd;
            tail = tail.next;
        }
    }

    private void moveNodeToLast(LinkedListNode nodeToNove) {

        if(nodeToNove.prev != null) nodeToNove.prev.next = nodeToNove.next;
        if (nodeToNove.next != null) nodeToNove.next.prev = nodeToNove.prev;
        if (nodeToNove == tail) tail = nodeToNove.prev;
        if (nodeToNove == head) head = nodeToNove.next;
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(1);
        cache.set(2,1);
        System.out.println(cache.get(2));
        cache.set(3,2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));

    }
}
