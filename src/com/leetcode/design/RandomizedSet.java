package com.leetcode.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by Dhaval on 2/5/2017.
 *
 * Design a data structure that supports all following operations in average O(1) time.

 insert(val): Inserts an item val to the set if not already present.
 remove(val): Removes an item val from the set if present.
 getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.

 Algorithm : We keep a list which stores all current integers
 We keep a hashmap which stores values and its corresponding position in list
 we insert the element if it is not present in hashmap
 to remove the element we set the element at current index as the element at last index and remove the last element in the list
 we update the hashmap accordingly
 */
public class RandomizedSet {

    /** Initialize your data structure here. */
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random random;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {

        if (!map.containsKey(val)) {
            return false;
        }
        int indx = map.get(val);
        map.remove(val);
        if (indx < list.size() - 1) {
            int lastElement = list.get(list.size()-1);
            list.set(indx, lastElement);
            map.put(lastElement, indx);
        }
        list.remove(list.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int rIndex = random.nextInt(list.size());
        return list.get(rIndex);
    }

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        System.out.println(rs.insert(1));
        System.out.println(rs.remove(2));
        System.out.println(rs.getRandom());
    }
}
