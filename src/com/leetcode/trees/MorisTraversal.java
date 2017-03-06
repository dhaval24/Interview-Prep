package com.leetcode.trees;

/**
 * Created by Dhaval on 2/19/2017.
 */
public class MorisTraversal {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void inorder(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.println(current.val + " ");
                current = current.right;
            }
            else {
                TreeNode predecessor = current.left;
                while (predecessor.right != current && predecessor.right != null)  {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                }
                else {
                    predecessor.right = null;
                    System.out.println(current.val + " ");
                    current = current.right;
                }
            }
        }
    }
}
