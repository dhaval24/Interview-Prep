package com.leetcode.arrays;

/**
 * Created by Dhaval on 6/30/2016.
 * Min Max approch
 * Find: min and max in an array
 * Create a boolean array of size max-min+1
 * Check if the value of array at number - min is true and if so return
 */
public class ContainsDuplicateBest {

    public boolean containsDuplicate(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int b: nums){
            if(b<min){
                min=b;
            }
            if(b>max){
                max=b;
            }
        }
        boolean[] a = new boolean[max-min+1];
        for(int b: nums){
            if(a[b-min]){
                return true;
            }else{
                a[b-min]=true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int a[] = {10, 5 , 6, 2, 5};
        System.out.println(new ContainsDuplicateBest().containsDuplicate(a));
    }
}
