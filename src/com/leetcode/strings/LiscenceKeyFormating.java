package com.leetcode.strings;

/**
 * Created by Dhaval on 2/10/2017.
 */
public class LiscenceKeyFormating {

    public String licenseKeyFormatting(String s, int k) {
        if (s == null) throw new NullPointerException();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') continue;
            sb.append(Character.toUpperCase(s.charAt(i)));
        }
        int count = 0;
        for (int i = sb.length(); i > 0; i--) {
            if (count == k) {
                sb = sb.insert(i, '-');
                count = 0;
                i++;
            }
            else {
                count++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LiscenceKeyFormating().licenseKeyFormatting("2-4A0r7-4k", 4));
        System.out.println(new LiscenceKeyFormating().licenseKeyFormatting("2-4A0r7-4k", 3));
    }
}
