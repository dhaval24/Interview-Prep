package com.leetcode.segmenttrees;

/**
 * Created by Dhaval on 2/18/2017.
 */
public class NextPower2 {


    public int getNext(int num) {
        if (num == 0) {
            return 1;
        }

        if (num > 0 && (num & (num - 1)) == 0) { // if number is already power of 2
            return num;
        }

        while ((num & (num - 1)) > 0) { // Continue until you find a number which is nearest power of 2 less than num
            num = (num & (num - 1));
        }
        return num << 1; // left shift the number obtained by 1
    }
    public static void main(String[] args) {

    }

}
