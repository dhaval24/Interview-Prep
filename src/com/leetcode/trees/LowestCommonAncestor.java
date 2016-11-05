package com.leetcode.trees;

import sun.reflect.generics.tree.Tree;

/**
 * Created by Dhaval on 8/31/2016.
 */
public class LowestCommonAncestor {


    public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {

        if (root == p || root == q || root == null) return root;
        TreeNode<Integer> left = lowestCommonAncestor(root.getLeft(), p, q);
        TreeNode<Integer> right = lowestCommonAncestor(root.getRight(), p, q);
        return (left != null && right != null) ? root : (left != null ? left : right);
    }


}
