package com.leetcode.arrays;

/**
 * Created by Dhaval on 9/2/2016.
 *
 * Algorithm: This is exactly similar to applying Floyd Warshall's algorithm to find the duplicates in the LinkedList.
 * Assume that the array indexes are the
 */
public class FindDuplicateNum {

    public int findDuplicate(int[] nums) {

        int n = nums.length;
        int slow = n;
        int fast = n;
        do{
            slow = nums[slow-1];
            fast = nums[nums[fast-1]-1];
        }while(slow != fast);
        slow = n;
        while(slow != fast){
            slow = nums[slow-1];
            fast = nums[fast-1];
        }
        return slow;
    }

    public int findDuplicate1(int[] nums) {

        int n = nums.length;
        int slow = nums[n-1];
        int fast = nums[nums[n-1]-1];
        while(slow != fast) {
            slow = nums[slow-1];
            fast = nums[nums[fast-1]-1];
        }

        slow = n;
        while(slow != fast){
            slow = nums[slow-1];
            fast = nums[fast-1];
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(new FindDuplicateNum().findDuplicate1(new int[] {1,2,3,2}));
    }
}
