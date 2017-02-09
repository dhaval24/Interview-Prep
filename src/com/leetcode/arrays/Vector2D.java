package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Dhaval on 12/1/2016.
 */

public class Vector2D implements Iterator<Integer> {

    private List<List<Integer>> vector;
    private int innerListPointer;
    private int listPointer;

    public Vector2D(List<List<Integer>> vec2d) {
        vector = vec2d;
        innerListPointer = 0;
        listPointer = 0;
    }

    @Override
    public Integer next() {

        List<Integer> currentList = vector.get(listPointer);
        Integer toReturn = currentList.get(innerListPointer);
        innerListPointer++;
        return toReturn;


    }

    @Override
    public boolean hasNext() {

        if (vector.size() == 0) {
            return false;
        }
        if (innerListPointer == vector.get(listPointer).size()) {
            listPointer++;
            skipEmptyList();
            innerListPointer = 0;
        }
        if (listPointer == vector.size() - 1) {
            return innerListPointer < vector.get(vector.size()-1).size();
        }
        else {
            return listPointer < vector.size();
        }
    }

    private void skipEmptyList() {
        while(listPointer < vector.size() && vector.get(listPointer).size() == 0 ) {
            listPointer++;
        }
    }

    public static void main(String[] args) {

        List<List<Integer>> vec2D = new ArrayList<>();
        List<Integer> vec1 = new ArrayList<>();
        vec1.add(1);
        vec1.add(2);
        vec2D.add(vec1);
        List<Integer> vec2 = new ArrayList<>();
        vec2D.add(vec2);
        List<Integer> vec3 = new ArrayList<>();
        vec3.add(4);
        vec3.add(5);
        vec2D.add(vec3);
        Vector2D i = new Vector2D(vec2D);
        while (i.hasNext()) {
            System.out.println(i.next());
        }

    }
}

