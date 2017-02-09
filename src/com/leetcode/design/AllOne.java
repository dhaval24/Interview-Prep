package com.leetcode.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Dhaval on 2/6/2017.
 *
 * Implement a data structure supporting the following operations:

 Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
 Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
 GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
 GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
 Challenge: Perform all these in O(1) time complexity.


 Algorithm : This algorithm basically uses 2 hashmap one for storing key and its count and another hashmap which stores freq of key and its corresponding bucket
 We will keep Doubly linkedlist of buckets where the elements in the next bucket to head gives the min key and elements in the bucket prev to tail gives max elements
 1. we insert the key into the doubly linkedlist in sorted order of count from head to tail
 2. If by changing the count of key we either promote that key to the bucket storing keys of that frequency if already present
     or else we create a new bucket of that will store elements of that frequency and store the key in that. We will insert the bucket in the appropriate position
     in the doubly linkedlist which will be prev of the current bucket if freq is reduced or after current bucket if freq is increased
 3. If the frequency of key becomes 0 we remove it from the keyCountMap as well as from the bucket.
 4. If size of bucket is 1 and the keys frequency goes down to 0 then we delete that bucket also from our doubly linkedlist

 */
public class AllOne {

    private Bucket head;
    private Bucket tail;
    private Map<String, Integer> keyCountMap;
    private Map<Integer, Bucket> countBucketMap;

    private class Bucket {
        int count;
        Set<String> keySet;
        Bucket next;
        Bucket prev;
        public Bucket(int count) {
            this.count = count;
            keySet = new HashSet<>();
        }
    }

    public AllOne() {
        head = new Bucket(Integer.MIN_VALUE);
        tail = new Bucket(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
        keyCountMap = new HashMap<>();
        countBucketMap = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (keyCountMap.containsKey(key)) {
            changeKey(key, 1);
        }
        else {
            keyCountMap.put(key, 1);
            if (head.next.count != 1) {
                addBucketAfter(new Bucket(1), head);
            }
            head.next.keySet.add(key);
            countBucketMap.put(1, head.next);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (keyCountMap.containsKey(key)) {
            int count = keyCountMap.get(key);
            if (count == 1) {
                keyCountMap.remove(key);
                removeKeyFromBucket(countBucketMap.get(count), key);
            }
            else {
                changeKey(key, -1);
            }

        }

    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keySet.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next == tail ? "" : head.next.keySet.iterator().next();
    }

    private void changeKey(String key, int offset) {
        int count = keyCountMap.get(key);
        keyCountMap.put(key, count + offset);
        Bucket currBucket = countBucketMap.get(count);
        Bucket newBucket;
        if (countBucketMap.containsKey(count + offset)) {
            newBucket = countBucketMap.get(count + offset);
        }
        else {
            newBucket = new Bucket(count + offset);
            countBucketMap.put(count + offset, newBucket);
            addBucketAfter(newBucket, offset == 1 ? currBucket : currBucket.prev);
        }
        newBucket.keySet.add(key);
        removeKeyFromBucket(currBucket, key);
    }

    private void addBucketAfter(Bucket newBucket, Bucket preBucket) {
        newBucket.prev = preBucket;
        newBucket.next = preBucket.next;
        preBucket.next.prev = newBucket;
        preBucket.next = newBucket;
    }

    private void removeKeyFromBucket(Bucket currBucket, String key) {
        currBucket.keySet.remove(key);
        if (currBucket.keySet.size() == 0) {
            removeBucketFromList(currBucket);
            countBucketMap.remove(currBucket.count);
        }
    }

    private void removeBucketFromList(Bucket currBucket) {
        currBucket.prev.next = currBucket.next;
        currBucket.next.prev = currBucket.prev;
        currBucket.prev = null;
        currBucket.next = null;
    }

    public static void main(String[] args) {
        AllOne one = new AllOne();
        one.inc("dhaval");
        one.inc("kj");
        one.inc("ab");
        one.inc("dhaval");
        one.dec("kj");
        one.inc("ak");
        System.out.println(one.getMaxKey());
        System.out.println(one.getMinKey());

    }
}
