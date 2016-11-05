package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhaval on 8/26/2016.
 */
public class GreyCode {

    public List<Integer> grayCode(int n) {

        List<Integer> result = new ArrayList<>();
        result.add(0);
        StringBuilder binEq = new StringBuilder();
        for (int i = 0; i < n; i++) {
            binEq.append(0);
        }
        grayCode(result, binEq, n);
        return result;

    }

    private void grayCode(List<Integer> res, StringBuilder sb, int n) {

        if (res.size() == (int)Math.pow(2, n)) {
            return;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (res.contains(Integer.parseInt(flipBit(sb, i), 2))) {
                flipBit(sb, i);
            }
            else {
                res.add(Integer.parseInt(sb.toString(), 2));
                grayCode(res, sb, n);
            }
        }
    }

    private String flipBit(StringBuilder sb , int index) {

        if (sb.charAt(index) == '0') {
            sb.setCharAt(index, '1');
        }
        else {
            sb.setCharAt(index, '0');
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(new GreyCode().grayCode(3));
    }

}
