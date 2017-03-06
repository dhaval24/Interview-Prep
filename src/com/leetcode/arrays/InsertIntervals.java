package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Dhaval on 3/4/2017.
 */
public class InsertIntervals {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        if (intervals == null) throw new IllegalArgumentException();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) {
                    return -1;
                }
                else if (o1.start > o2.start) {
                    return 1;
                }
                else if (o1.end > o2.end) {
                    return -1;
                }
                else if (o1.end < o2.end) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        });

        boolean inserted = false;
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).start > newInterval.start) {
                intervals.add(i, newInterval);
                inserted = true;
                break;
            }
        }

        if (!inserted) {
            intervals.add(newInterval);
        }

        List<Interval> result = new ArrayList<>();

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (current.start > end) {
                result.add(new Interval(start, end));
                start = current.start;
                end = current.end;
            }
            if (current.end > end) {
                end = current.end;
            }

        }
        result.add(new Interval(start, end));
        return result;

    }

    public List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
        //Won't work with intervals like (0,0) and intervals with RangeMax
        if (intervals == null) throw new IllegalArgumentException();
        int maxLength = 0;
        int min = Integer.MAX_VALUE;
        for (Interval i : intervals) {
            maxLength = Math.max(maxLength, i.end);
            min = Math.min(min, i.start);
        }
        maxLength = Math.max(maxLength, newInterval.end);

        int[] buffer = new int[maxLength];
        for (Interval i : intervals) {
            buffer[i.start] += 1;
            buffer[i.end] += -1;
        }
        buffer[newInterval.start] += 1;
        buffer[newInterval.end] += -1;
        List<Interval> result = new ArrayList<>();
        int sum = buffer[min];
        int start = min;
        for (int i = min + 1; i < buffer.length; i++) {
            sum += buffer[i];
            if (sum == 0) {
                result.add(new Interval(start, i));
                continue;
            }
            if (sum == 1) {
                start = i;
            }
        }
        return result;
    }

}
