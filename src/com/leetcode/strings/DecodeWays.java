package com.leetcode.strings;

/**
 * Created by Dhaval on 8/10/2016.
 */
public class DecodeWays {
    public int numDecodings(String s) {

        int len = s.length();
        if (len < 1) return 0;
        int[] buffer = new int[len+1];
        if (s.charAt(0) == '0') return 0;
        buffer[len] = 1;
        for (int i = len - 1; i >= 0; i--) {
            int curr = s.charAt(i) - 48;
            if (i == len - 1) {

                buffer[i] = curr > 0 ? 1: 0;
            }
            else {
                if (curr > 0) {
                    int doubleVal = Integer.valueOf(s.substring(i, i+2));
                    buffer[i] = doubleVal <= 26 && doubleVal > 0 ? buffer[i+1] + buffer[i+2] : buffer[i+1];
                }
                else {
                    buffer[i] = 0;
                }
            }
        }

        return buffer[0];
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("1001"));
    }

}
