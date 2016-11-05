package com.leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhaval on 8/12/2016.
 */
public class RestoreIP {

    public List<String> resotreIPAddress(String s) {

        List<String> result = new ArrayList<>();
        if (s == null) return result;
        restoreIPAddress(s, "", result, 0, 0);
        return result;
    }

    private void restoreIPAddress(String original, String temp, List<String> result,
                                  int decimal, int index) {

        if (decimal > 4) {
            return;
        }

        if (decimal == 4 && index == original.length()) result.add(temp);

        for (int i=1; i<4; i++) {
            if (index+i > original.length()) break;
            String s = original.substring(index,index+i);
            if ((s.startsWith("0") && s.length()>1) || (i==3 && Integer.parseInt(s) >= 256)) continue;
            restoreIPAddress(original, temp+s+(decimal==3?"" : "."), result, decimal+1, index+i);
        }
    }

    public static void main(String[] args) {
        System.out.println(new RestoreIP().resotreIPAddress("0000"));
    }
}
