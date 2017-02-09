package com.leetcode.stacks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhaval on 12/27/2016.
 */
public class StackOfPlates {

    List<Stack> stackList = new ArrayList<>();
    int capacity;

    public StackOfPlates(int capacity) {
        this.capacity = capacity;
    }

    public Stack getLastStack(){

        if (stackList.size() == 0) return null;
        return stackList.get(stackList.size() - 1);
    }

    public void push(int v) {
        Stack stack = getLastStack();
        if (stack != null && !stack.isFull()) {
            stack.push(v);
        }
        else {
            Stack newStack = new Stack(capacity);
            newStack.push(v);
            stackList.add(newStack);
        }
    }

    public int pop() {
         Stack stack = getLastStack();
         if (stack == null || stack.size == 0) throw new NullPointerException();
         int returnInt = stack.pop();
         if (stack.size == 0) {
             stackList.remove(stackList.size() - 1);
         }
         return returnInt;
    }

    public int popAt(int index) {
        return leftShift(index, true);
    }


    private int leftShift(int index, boolean removeLast) {

        Stack stack = stackList.get(index);
        if (stack == null || stack.size == 0) {
            throw new NullPointerException();
        }
        int returnValue;
        if (removeLast) {
            returnValue = stack.pop();
        }
        else {
            returnValue = stack.removeBottom();
        }
        if (stack.isEmpty()) {
            stackList.remove(index);
            return returnValue;
        }
        else if(stackList.size() > index + 1) {
            int v = leftShift(index + 1, false);
            stack.push(v);
        }
        return returnValue;
    }

    private class Stack {
        int capacity;
        int size;
        Node top, bottom;

        public Stack(int capacity) {
            this.capacity = capacity;
            size = 0;
        }

        private class Node {
            int val;
            Node above, below;
            public Node(int val) {
                this.val = val;
            }
        }

        boolean push(int v) {

            if (size >= capacity) {
                return false;
            }
            Node t = new Node(v);
            if (bottom == null) {
                bottom = t;
            }
            join(t, top);
            top = t;
            size++;
            return true;
        }

        int pop() {
            Node t = top;
            top = top.below;
            size--;
            return t.val;
        }

        void join(Node above, Node below) {
            if (above != null) {
                above.below = below;
            }
            if (below != null) {
                below.above = above;
            }
        }

        boolean isFull() {
            return size == capacity;
        }

        boolean isEmpty() {
            return size == 0;
        }

        int removeBottom() {
            Node t = bottom;
            bottom = bottom.above;
            if (bottom != null) {
                bottom.below = null;
            }
            size--;
            return t.val;
        }
    }

    public static void main(String[] args) {
        StackOfPlates sp = new StackOfPlates(3);
        sp.push(1);
        sp.push(2);
        sp.push(3);
        sp.push(4);
        sp.push(5);
        sp.push(6);
        sp.push(7);
        sp.push(8);
        sp.push(9);
        sp.push(10);
        sp.push(11);
        System.out.println(sp.popAt(2));
    }

}
