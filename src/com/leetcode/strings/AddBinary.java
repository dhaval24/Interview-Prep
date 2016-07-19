package com.leetcode.strings;

/**
 *  Given two binary strings, return their sum (also a binary string).
     For example,
     a = "11"
     b = "1"
     Return "100".
 * Created by Dhaval on 7/17/2016.
 *
 * Algorithm : Bit manipulation way
 * : 1. XOR of digits and carry gives the bit to be set at the same index in output string
 * 2. Pair wise AND of digits and carry , and OR of each pair(digits1 & digits2) | (digits2 & carry) | (digits1 & carr)
 *     gives the carry bit. If there is only 1digit and carry just return AND of both.
 *
 * Overall Complexity O(n) in time and space
 *
 */
public class AddBinary {

    public String addBinaryValues(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int p1 = a.length()-1;
        int p2 = b.length()-1;
        char carry = '0';
        while (p1 >= 0 && p2 >= 0) {

            sb.append(((a.charAt(p1) ^ b.charAt(p2)) ^ (carry)) - '0');
            carry = getCarry(a.charAt(p1), b.charAt(p2) , carry);

            p1--;
            p2--;

        }
        while (p1 >= 0) {

            sb.append((a.charAt(p1) ^ carry));
            carry = getCarry(a.charAt(p1) ,carry);

            p1--;

        }
        while (p2 >= 0) {

            sb.append((b.charAt(p2) ^ carry) );
            carry = getCarry(b.charAt(p2), carry);

            p2--;

        }
        if (carry != '0') {
            sb.append(carry);
        }
        return sb.reverse().toString();

    }

    private char getCarry(char a, char b, char carry) {

        return (char)((a & b) | (a & carry) | (b & carry));
    }
    private char getCarry(char a, char b) {
        return (char) (a & b);
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinaryValues("1010", "1011"));
    }
}
