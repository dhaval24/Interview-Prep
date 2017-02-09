package com.leetcode.arrays;

import java.util.Arrays;

/**
 * Created by Dhaval on 11/16/2016.
 */
public class SortCharByFreq {
    class CharWrapper implements Comparable<CharWrapper>{
        int count;
        char c;
        public CharWrapper(char c, int count) {
            this.c = c;
            this.count = count;
        }
        public int compareTo(CharWrapper o) {
            if (this.count < o.count) return 1;
            else if(this.count > o.count) return -1;
            else return 0;
        }
    }

    public String frequencySort(String s) {

        CharWrapper[] arr = new CharWrapper[256];
        for (int i = 0; i < 256; i++) {
            arr[i] = new CharWrapper(((char)(i+1)), 0);
        }

        int len = s.length();
        for (int i = 0; i < len; i++) {
            char curr = s.charAt(i);
            int count = (arr[curr-1]).count;
            (arr[curr-1]).count = count + 1;
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 256; i++) {
            if (arr[i].count > 0) {
                for (int j = 0; j < arr[i].count; j++) {
                    sb.append(arr[i].c);
                }
            }
            else {
                break;
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(new SortCharByFreq().frequencySort("Aabb"));
    }
}
