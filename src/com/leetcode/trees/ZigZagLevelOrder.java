package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Dhaval on 2/19/2017.
 */
public class ZigZagLevelOrder {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> zigZagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            while (!s1.isEmpty()) {
                TreeNode t = s1.pop();
                if (t.left != null) {
                    s2.push(t.left);
                }
                if (t.right != null) {
                    s2.push(t.right);
                }
                temp.add(t.val);
            }
            if (temp.size() > 0)
                result.add(temp);
            temp = new ArrayList<>();
            while (!s2.isEmpty()) {
                TreeNode t = s2.pop();
                if (t.right != null) {
                    s1.push(t.right);
                }

                if (t.left != null) {
                    s1.push(t.left);
                }
                temp.add(t.val);
            }
            if (temp.size() > 0)
                result.add(temp);
        }
        return result;
    }
}
