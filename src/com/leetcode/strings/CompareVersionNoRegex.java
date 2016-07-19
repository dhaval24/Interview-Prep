package com.leetcode.strings;

/**
 * Created by Dhaval on 7/15/2016.
 * Algorithm : Iterate over both the strings - Loop runs till end of larger string
 * p1 and p2 are running pointers over both strings and stop when a decimal occurs or end of stirng
 * nums1 and nums2 are used to store the value before a decimal
 * if nums1 != nums2 at anypoint in the run we return 1 or -1
 * if above step doesn't occur both the strings are same and we return 0
 *
 */
public class CompareVersionNoRegex {
    public int compareVersion(String version1, String version2) {
        int p1=0,p2=0;
        while(p1<version1.length() || p2<version2.length()){
            int num1=0,num2=0;
            while(p1<version1.length() && version1.charAt(p1)!='.') num1 = num1*10 + (version1.charAt(p1++) - '0'); // get number in version1..
            while(p2<version2.length() && version2.charAt(p2)!='.') num2 = num2*10 + (version2.charAt(p2++) - '0'); // get number in version2.
            if(num1 != num2) return num1>num2 ? 1:-1;
            p1++;
            p2++;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new CompareVersionNoRegex().compareVersion("1.0","1.0.0.1"));
    }
}
