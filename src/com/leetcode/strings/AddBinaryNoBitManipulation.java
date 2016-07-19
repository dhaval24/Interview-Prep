package com.leetcode.strings;

/**
 * Created by Dhaval on 7/18/2016.
 * Algorithm : Iterate over both the strings until any one of them is still left to be read
 * Initialize carry whose value os equal to 0 initially
 * Add the actual value of the character at index from both the strings
 * append sum%2 to output string and calculate the carry by dividing sum/2
 * At the end if carry is not = 0 append carry and return the string builder by reversing it
 *
 * Overall complexity : O(n)
 */
public class AddBinaryNoBitManipulation {

    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddBinaryNoBitManipulation().addBinary("1010", "1011"));
    }
}
