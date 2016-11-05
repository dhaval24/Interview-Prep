package com.leetcode.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Dhaval on 11/1/2016.
 */

class Interval {

    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
    public String toString() {
        return "["+start+"-"+end+"]";
    }
}

public class EraseInterval {

    public int eraseIntervalOverlap(Interval[] intervals) {
        int len = intervals.length;
        if (len == 0 || len == 1) return 0;
        Arrays.sort(intervals, new IntervalComparator());
        System.out.println(Arrays.toString(intervals));
        Interval previous = intervals[0];
        int count = 0;
        for (int i = 1; i < intervals.length;  i++) {
            Interval current = intervals[i];
            if (previous.end > intervals[i].start) {
                count++;
                if (previous.end > intervals[i].end) {
                    previous = current;
                }
            }
            else {
                previous = current;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Interval[] intervals = { new Interval(1,100), new Interval(1,11), new Interval(2,12), new Interval(11,22)};
        System.out.println(new EraseInterval().eraseIntervalOverlap(intervals));

    }
}

class IntervalComparator implements Comparator<Interval> {

    @Override
    public int compare(Interval o1, Interval o2) {
        if (o1.start < o2.start) return -1;
        else if(o1.start > o2.start) return 1;
         //if (o1.start <= o2.start) return -1;
         else return o1.end-o2.end;
    }
}
