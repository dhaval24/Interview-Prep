package com.leetcode.trees;

/**
 * Created by Dhaval on 7/22/2016.
 */
public class InvertBinaryTree {

    public BinaryTree invertTree(BinaryTree root) {

        invertTree(root.root);
        return root;
    }

    private TreeNode<Integer> invertTree(TreeNode<Integer> root) {

        if (root == null) {
            return null;
        }

        if(root.getLeft() != null) {
            invertTree(root.getLeft());
        }
        if (root.getRight() != null) {
            invertTree(root.getRight());
        }
        TreeNode<Integer> temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);

        return root;
    }

}
