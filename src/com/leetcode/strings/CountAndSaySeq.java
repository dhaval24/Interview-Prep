package com.leetcode.strings;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.

 Given an integer n, generate the nth sequence.

 * Created by Dhaval on 7/17/2016.
 *
 * Algorithm : (n == 1,2,3) are pecuilar cases and thus return 1, 11, 21 respecitively
 * For cases when n > 3 then initialize the stringbuilder to value of 3 that is "21"
 * Take a counter and initialize it to 3. Loop until counter < number
 * Now basic approach is to iterate until same character is occured in the stringbuilder
 * and increase the count
 * When a different character occures insert into new stringbuilder the count and then the previous character
 * Reset the counter and update the value of previous
 * At then end of iteration assign the newly obtained string builder to older one and increase the value of outer counter
 *
 * Overall complexity :O(n^2)
 */
public class CountAndSaySeq {

    public String countAndSay(int n) {

        if (n == 1) return "1";
        if (n == 2) return "11";
        if(n == 3) return "21";
        StringBuilder s = new StringBuilder("21");
        char prev;
        int total = 3;
        while (total < n) {

            int len = s.length();
            prev = s.charAt(0);
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < len; i++) {

                char c = s.charAt(i);
                if (c == prev) count++;
                else {
                    sb.append(count);
                    sb.append(prev);
                    prev = c;
                    count = 1;
                }

            }

            sb.append(count);
            sb.append(prev);
            s = sb;
            total++;


        }
        return s.toString();


    }

    public static void main(String[] args) {
        System.out.println(new CountAndSaySeq().countAndSay(4));
    }
}
