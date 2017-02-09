package com.leetcode.strings;

/**
 * Created by Dhaval on 11/9/2016.
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) return null;
        int len1 = num1.length();
        int len2 = num2.length();
        String shorter, longer;
        if (len1 > len2) {
            shorter = num2;
            longer = num1;
        }
        else {
            shorter = num1;
            longer = num2;
        }
        int p1 = longer.length()-1;
        int p2 = shorter.length()-1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (p2 >= 0) {
            int sum = (longer.charAt(p1) - 48) + (shorter.charAt(p2) - 48) + carry;
            carry  = sum / 10;
            sb.append((sum % 10));
            p1--;
            p2--;
        }
        if (carry != 0 || p1 >= 0) {

            while (p1 >= 0) {
                int sum = (longer.charAt(p1)-48) + carry;
                carry = sum / 10;
                sb.append(sum%10);
                p1--;
            }
            if (carry != 0) {
                sb.append(carry);
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("123", "1111"));
    }
}
