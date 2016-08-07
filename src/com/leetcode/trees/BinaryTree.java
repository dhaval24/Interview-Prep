package com.leetcode.trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Dhaval on 7/21/2016.
 */
public class BinaryTree implements Iterable<TreeNode> {

    @Override
    public Iterator<TreeNode> iterator() {
        return new BinaryTreeInOrderIterator();
    }

    private class BinaryTreeInOrderIterator implements Iterator<TreeNode> {

        TreeNode<Integer> next = root;
        Stack<TreeNode> stack = new Stack<>();

        public BinaryTreeInOrderIterator() {
            pushLeft(next);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public TreeNode next() throws NoSuchElementException{

            if(!hasNext()) {
                throw new NoSuchElementException("All nodes have been viisited");
            }
            TreeNode ret = stack.pop();
            pushLeft(ret.getRight());
            return ret;
        }


        @Override
        public void remove() {

            throw new UnsupportedOperationException("This operation is currently unsupported");
        }

        private void pushLeft(TreeNode<Integer> node) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
        }
    }

    TreeNode<Integer> root = null;
    Queue<TreeNode> queue = new LinkedList<>();

    public TreeNode insert(TreeNode<Integer> node) {


        TreeNode<Integer> temp = null;
        if (root == null) {
            root = node;
        }

        if (queue.isEmpty()) {
            queue.add(node);
        }
        else {
            while (queue.peek().getLeft() != null && queue.peek().getRight() != null) {
                queue.remove();
            }
            temp = queue.peek();
            if (temp.getLeft() == null) {
                temp.setLeft(node);
                queue.add(node);
            }
            else {
                temp.setRight(node);
                queue.add(node);
            }
        }
        return temp;
    }

    public void traverseInOrder(BinaryTree root) {

        Iterator it = root.iterator();
        while (it.hasNext()) {
            System.out.println(((TreeNode)it.next()).getValue());
        }

    }

}
