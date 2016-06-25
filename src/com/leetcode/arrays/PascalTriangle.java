package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhaval on 6/21/2016.
 * Generate pascal triangle of N rows
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        for(int i = 0; i < numRows; i++){

            temp.add(0,1);
            for(int j = 1; j < i; j++){
                temp.set(j, result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
            }
            result.add(new ArrayList<>(temp));
        }
        return result;


    }

    public static void main(String[] args) {

        PascalTriangle p = new PascalTriangle();
        System.out.println(p.generate(5));
    }
}