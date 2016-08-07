package com.leetcode.trees;

/**
 * Created by Dhaval on 7/23/2016.
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(BinaryTree root) {
        return minDepth(root.root);
    }

    private int minDepth(TreeNode<Integer> root) {

        if (root == null) return 0;

        if (root.getLeft() != null && root.getRight() != null)
            return Math.min(minDepth(root.getLeft())+1, minDepth(root.getRight())+1);
        else
            return Math.max(minDepth(root.getLeft())+1, minDepth(root.getRight())+1);
    }
}
