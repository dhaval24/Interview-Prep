package com.leetcode.strings;

/**Compare two version numbers version1 and version2.
 If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

 * Created by Dhaval on 7/15/2016.
 *
 * Algorithm : 1. Split both the string with "."
 * Iterate over both the arrays which are a result of spilt until the length of the smaller array
 * If the array entries in both the array are not same then return value accordingly
 * If they are same and one array is larger than another array then iterate over larger and if you find
 * any value greater than 0 then return the either 1 or -1 depending on larger array was second parameter
 * in input or first
 */
public class CompareVersions {
    public int compareVer(String version1, String version2) {

        String[] v1 = version1.split("[.]");
        String[] v2 = version2.split("[.]");
        String[] larger;
        int res;
        int len = v1.length;
        int len2= v2.length;
        int minLen, maxLen;
        if (len < len2) {
            minLen = len;
            maxLen = len2;
            res = -1;
            larger = v2;
        }
        else {
            minLen = len2;
            maxLen = len;
            res = 1;
            larger = v1;
        }
        for (int i = 0; i < minLen; i++) {
            int val1 = Integer.valueOf(v1[i]);
            int val2 = Integer.valueOf(v2[i]);
            if(val1 > val2) return 1;
            else if(val1 < val2) return -1;
        }
        for (int i = minLen; i < maxLen; i++) {
            if(Integer.valueOf(larger[i]) != 0) return res;

        }
        return 0;
    }

    public static void main(String[] args) {

        System.out.println(new CompareVersions().compareVer("1", "0"));
    }
}
