package com.leetcode.strings;

/**
 * Created by Dhaval on 8/11/2016.
 */
public class ReverseWords {
    public String reverseWords(String s) {

        if (s == "") return s;
        s = s.trim();
        s = s.replaceAll("\\s+", " ");
        StringBuilder sb = new StringBuilder(s);
        int len = sb.length();
        if (len < 1) return "";
        int start = 0;
        int end = len - 1;
        reverse(sb, start, end);
        end = 0;
        while (start < len && end < len) {
            if (sb.charAt(end) == ' ') {
                reverse(sb, start, end-1);
                end++;
                start = end;
            }
            else {
                end++;
            }
        }
        reverse(sb, start, end - 1);
        return sb.toString();

    }

    private void reverse(StringBuilder sb, int start, int end) {
        while (start <= end) {
            swap(sb, start, end);
            start++;
            end--;
        }
    }

    private void swap(StringBuilder sb, int start, int end) {
        char temp = sb.charAt(start);
        sb.setCharAt(start, sb.charAt(end));
        sb.setCharAt(end, temp);

    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords(" a  b  "));
    }
}
