package com.leetcode.strings;

/**
 * Created by Dhaval on 9/24/2016.
 */
public class URLify {

    public String formatString(String s, int size) {

        s = s.trim();
        int len = s.length();
        if (len < 1) return "";
        if (len < 3) return s;
        char[] outputArr = new char[size];
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < len; i++) {

            if (s.charAt(i) == ' ') {
                while (s.charAt(i) == ' ') {
                    i++;
                    flag = true;
                }
                if (flag == true) {
                    i--;
                    flag = false;
                }
                outputArr[index++] = '%';
                outputArr[index++] = '2';
                outputArr[index++] = '0';
            }
            else {
                outputArr[index++] = s.charAt(i);
            }

        }

        return new String(outputArr);
    }

    public static void main(String[] args) {
        System.out.println(new URLify().formatString("My John Smith    ", 19));
    }

}
