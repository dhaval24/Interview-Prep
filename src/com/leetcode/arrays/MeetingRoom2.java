package com.leetcode.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Dhaval on 11/12/2016.
 */
public class MeetingRoom2 {

    private static class Interval {
        int start;
        int end;

        public Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return "{"+start+","+end+"}";
        }
    }

    public int minMeetingRooms(Interval[] intervals) {

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        System.out.println(Arrays.toString(intervals));
        PriorityQueue<Interval> pq = new PriorityQueue<>(intervals.length, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end-o2.end;
            }
        });
        pq.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval I = pq.poll();
            if (intervals[i].start >= I.end) {
                I.end = intervals[i].end;
            }
            else {
                pq.offer(intervals[i]);
            }
            pq.offer(I);

        }

        return pq.size();


        //return 0;
    }

    public int meetingRomm2(Interval[] intervals) {
        int row = 2;
        int col = intervals.length;
        int[][] matrix = new int[row][col];
        for (int j = 0; j < col; j++) {
            matrix[0][j] = intervals[j].start;
            matrix[1][j] = intervals[j].end;
        }
        Arrays.sort(matrix[0]);
        Arrays.sort(matrix[1]);
        int p1 = 0;
        int p2 = 0;
        int meetingRoom = 0;
        while (p1 < col) {
            if (matrix[0][p1] < matrix[1][p2]) {
                meetingRoom++;
                p1++;
            }
            else {
                p1++;
                p2++;
            }
        }
        return meetingRoom;
    }

    public static void main(String[] args) {
        Interval[] inp = {new Interval(0,30), new Interval(5,10), new Interval(15,20), new Interval(17,34),
                new Interval(23,60), new Interval(33,57), new Interval(38,90)};
        //System.out.println(new MeetingRoom2().minMeetingRooms(inp));
        System.out.println(new MeetingRoom2().meetingRomm2(inp));

    }


}
