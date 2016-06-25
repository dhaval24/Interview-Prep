package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhaval on 6/21/2016.
 * Determine the nth row of pascal triangle
 *
 * Approach : Using single list expanding strategy by applying pascal triangle
 * property, element in current list is equal to the sum of element of at the same
 * index and index - 1 in the parent row
 */
public class PascalTriangle2 {

    //More elegant solution using LinkedList9
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>();
        for (int row = 0; row <= rowIndex; row++) {
            ret.add(0, 1);
            for (int i = 1; i < row; i++)
                ret.set(i, ret.get(i) + ret.get(i + 1));
        }
        return ret;
    }

    /* Using more space
    public List<Integer> getRow(int rowIndex) {

        List<Integer> parent = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if(rowIndex < 0) {
            return parent;
        }
        parent.add(1);
        for(int i = 0; i <= rowIndex; i++){

            temp.add(0,1);
            for(int j = 1; j < i; j++){
                temp.set(j, parent.get(j) + parent.get(j - 1));
            }
            parent = new ArrayList<>(temp);
        }
        return parent;
    }
*/
    public static void main(String[] args) {

        PascalTriangle2 p = new PascalTriangle2();
        System.out.println(p.getRow(3));
    }
}
