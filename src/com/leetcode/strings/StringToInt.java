package com.leetcode.strings;

/**
 * Created by Dhaval on 7/20/2016.
 */
public class StringToInt {
    static int count = 0;
    public int myAtoi(String str) {

        str = str.trim();
        int len = str.length();
        int num = 0;
        boolean flag = true;
        boolean negFlag = false;
        for (int i = 0; i < len; i++) {

            char c = str.charAt(i);
            if (c == '0' && flag) {
                continue;
            }
            if (c == ' ') continue;
            if (!isSign(c)) {
                if (isNumber(c)) {
                    num = (num * 10) + (c - '0');
                    flag = false;
                }
                else {
                    return num;
                }

            }
            else {
                count++;
                negFlag = isSignNegative(c);
            }


        }
        if (count > 1) return 0;
        return (negFlag == false ? num : -num);
    }

    private boolean isSignNegative(char c) {

        return c == '-';

    }

    private boolean isSign(char c) {
        return c == '-' || c == '+';
    }
    private boolean isNumber(char c) {
        if (c >= 48 && c <= 57) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new StringToInt().myAtoi("+1"));
    }
}
