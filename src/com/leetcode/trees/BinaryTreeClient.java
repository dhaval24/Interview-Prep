package com.leetcode.trees;

import java.util.Scanner;

/**
 * Created by Dhaval on 7/21/2016.
 */
public class BinaryTreeClient {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree b = new BinaryTree();
        String input = sc.next();
        String[] inpArray = input.split(",");
        for(String i : inpArray) {
            if (i.equals("null")) {
                //b.insert(new TreeNode<>(null));
                continue;
            }
            b.insert(new TreeNode<>(Integer.valueOf(i)));
        }
       b.traverseInOrder(b);

//        BinaryTreeAllPaths binaryTreeAllPaths = new BinaryTreeAllPaths();
//        System.out.println(binaryTreeAllPaths.binTreePaths(b));

//        InvertBinaryTree ib = new InvertBinaryTree();
//        ib.invertTree(b);
//        b.traverseInOrder(b);

        BinaryTreePathSum bpath = new BinaryTreePathSum();
        System.out.println(bpath.hasPathSum(b,3));
    }
}
