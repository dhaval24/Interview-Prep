package com.leetcode.linkedlist;

import java.util.Iterator;

/**
 * Created by Dhaval on 9/25/2016.
 */
public class LinkedList<T> implements Iterable<T> {

    private Node<T> head = null;
    private int size = 0;

    public Node insertAtLast(T value) {
        return insert(value, size);
    }

    public Node insertAtFirst(T value) {

        return insert(value, 0);
    }

    public Node delete(int index) {

        if (index >=size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            Node temp = head;
            head = head.next;
            size--;
            return temp;
        }
        else {
            int count = 0;
            Node temp = head;
            while (count < index-1) {
                temp = temp.next;
                count++;
            }
            Node removeNode = temp.next;
            temp.next = temp.next.next;
            size--;
            return removeNode;
        }
    }


    public Node insert(T value, int index) {

        if (index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node node = new Node(value);
        if (index == 0) {
            if (head == null) {
                head = node;
                node.next = null;
                size++;
                return head;

            }
            else {
                Node temp = node;
                temp.next = head;
                head = temp;
            }
        }
        else {
            int count = 0;
            Node temp = head;
            while (count < index - 1) {
                temp = temp.next;
                count++;
            }
            Node nextNode = temp.next;
            temp.next = node;
            node.next = nextNode;

        }
        size++;
        return node;

    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {

        Node<T> nextNode = head;

        @Override
        public boolean hasNext() {
            if (nextNode != null) return true;
            return false;
        }



        @Override
        public T next() {
            if (hasNext()) {
                Node<T> temp = nextNode;
                nextNode = nextNode.next;
                return temp.value;
            }
            else {
                return null;
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    class Node<T> {
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
            next = null;
        }
    }

}
