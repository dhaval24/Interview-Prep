package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhaval on 7/21/2016.
 */
public class BinaryTreeAllPaths {

    public List<String> binTreePaths(BinaryTree b) {

        ArrayList<String> ans = new ArrayList<>();
        if (b.root != null) {
            return binTreepaths(b.root, "", ans);
        }
        return ans;
    }

    private List<String> binTreepaths(TreeNode<Integer> root, String s, ArrayList<String> result) {


        if (root.getLeft() == null && root.getRight() == null) {
            result.add(s + root.getValue());
            return result;
        }

        if(root.getLeft() != null)
        binTreepaths(root.getLeft(), s + root.getValue() + "->", result);

        if(root.getRight() != null)
        binTreepaths(root.getRight(), s + root.getValue() + "->", result);

        return result;
    }
}
