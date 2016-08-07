package com.leetcode.trees;

/**
 * Created by Dhaval on 7/23/2016.
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode<Integer> root) {

        if (root == null) return true;
        if (Math.abs(getHeight(root.getLeft()) - getHeight(root.getRight())) > 1)
            return false;
        return isBalanced(root.getLeft()) & isBalanced(root.getRight());

    }

    private int getHeight(TreeNode<Integer> root) {

        if (root == null) return 0;
        return Math.max(getHeight(root.getLeft()), getHeight(root.getRight()))+1;
    }
}
