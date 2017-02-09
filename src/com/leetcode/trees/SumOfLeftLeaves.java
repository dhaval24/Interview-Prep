package com.leetcode.trees;

/**
 * Created by Dhaval on 11/10/2016.
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode<Integer> root) {
        if (root == null) return 0;
        int ans = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) ans += root.left.value;
            ans += sumOfLeftLeaves(root.left);
        }
        if (root.right != null) {
            ans += sumOfLeftLeaves(root.right);
        }
        return ans;
    }
}
