package com.leetcode.Math;

/**
 * Created by Dhaval on 7/27/2016.
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB

 Algorithm : This is a new system with 26 as base. so mostly it is like
 seperating digits but to get the corresponding character you need to add 26. Further
 the exeception is with the case of 0 where you need to append Z.
 */
public class ExcelSheetColTitle {

    public String convertToTitle(int n) {

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int curr = (n%26);
            char app;
            if (curr == 0) { // 0 is an exception case where you need to append Z
                app = 'Z';
            }
            else {
                app = (char)(curr+64);
            }

            sb.append(app);
            n= (n-1) /26; // performing n-1 to get 0 instead of n

        }
        sb = sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColTitle().convertToTitle(52));
    }
}
