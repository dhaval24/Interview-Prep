package com.leetcode.trees;

/**
 * Created by Dhaval on 7/22/2016.
 */
public class BinaryTreePathSum {

    public boolean hasPathSum(BinaryTree root, int sum) {

        return hasPathSum(root.root,sum,0);
    }

    private boolean hasPathSum(TreeNode<Integer> root, int sum, int curr) {

        if (root == null) return false;

        if (root.getLeft() == null && root.getRight() == null) {
            curr += root.getValue();
            if(curr == sum) return true;
            return false;
        }

        return  hasPathSum(root.getLeft(), sum, curr+root.getValue())| hasPathSum(root.getRight(), sum, curr + root.getValue());


    }
}