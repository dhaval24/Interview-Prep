package com.leetcode.FenwickTree;

/**
 * Created by Dhaval on 2/19/2017.
 */
public class BinaryIndexedTree {

    private int[] binaryIndexedArray;

    public void updateBinaryIndexTree(int val, int index) {
        while (index < binaryIndexedArray.length) {
            binaryIndexedArray[index] += val;
            index = getNextIndex(index);
        }
    }
    public void createTree(int[] input) {
        binaryIndexedArray = new int[input.length + 1];
        for (int i = 1; i <= input.length; i++) {
            updateBinaryIndexTree(input[i-1], i);
        }
    }

    public int getSum(int index) {
        index = index + 1;
        int sum = 0;
        while (index > 0) {
            sum += binaryIndexedArray[index];
            index = getParent(index);
        }
        return sum;
    }

    private int getNextIndex(int index) {
        return index + (index & -index);
    }

    private int getParent(int index) {
        return index - (index &-index);
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,7,8,9,10};
        BinaryIndexedTree bit = new BinaryIndexedTree();
        bit.createTree(input);
        System.out.println(bit.getSum(9));
    }
}
