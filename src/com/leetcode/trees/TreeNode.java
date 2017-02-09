package com.leetcode.trees;

/**
 * Created by Dhaval on 7/21/2016.
 */
public class TreeNode<T> {

    T value;

    public T getValue() {
        return value;
    }

    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}
