package com.leetcode.arrays;

/**
 * Created by Dhaval on 12/30/2016.
 */
public class BitonicArraySearch {

    public boolean searchBitonic(int[] arr, int key) {


        if (arr == null || arr.length == 0) {
            throw new NullPointerException();
        }

        if (arr.length == 1) {
            return arr[0] == key;
        }

        int midPoint = findMidPointBinary(arr);

        return increasingBinary(arr, 0, midPoint - 1, key) || decreasingBinary(arr, midPoint + 1, arr.length - 1, key);


    }

    private int findMidPointBinary(int[] arr) {

        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            else if (arr[mid] > arr[mid - 1] && arr[mid + 1] > arr[mid]) {
                lo = mid + 1;
            }

            else {
                hi = mid - 1;
            }
        }
        return - 1;

    }

    private boolean increasingBinary(int[] arr, int lo, int hi, int key) {

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == key) {
                return true;
            }

            if (arr[mid] > key) {
                hi = mid - 1;
            }

            else {
                lo = mid + 1;
            }
        }
        return false;
    }

    private boolean decreasingBinary(int[] arr, int lo, int hi, int key) {

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == key) {
                return true;
            }

            if (arr[mid] < key) {
                hi = mid - 1;
            }

            else {
                lo = mid + 1;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2};
        System.out.println(new BitonicArraySearch().searchBitonic(arr, 2));

    }
}
