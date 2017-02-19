package com.leetcode.segmenttrees;

import java.util.Arrays;

/**
 * Created by Dhaval on 2/18/2017.
 */
public class SegmentTreeMinQuery {

        private int[] segmentArray;
        private int[] lazy;

        public void createSegmentTree(int[] A) {
            int nextPowerOfTwo = new NextPower2().getNext(A.length);
            segmentArray = new int[nextPowerOfTwo * 2 - 1];
            lazy = new int[nextPowerOfTwo * 2 - 1];
            Arrays.fill(segmentArray, Integer.MAX_VALUE);
            constructSegmentTree(A, 0, A.length - 1, 0);

        }

        private void constructSegmentTree(int[] A, int lo, int hi, int pos) {
            if (lo == hi) {
                segmentArray[pos] = A[lo];
                return;
            }
            int mid = (lo + hi)/ 2;
            constructSegmentTree(A, lo, mid, 2 * pos + 1);
            constructSegmentTree(A, mid + 1, hi, 2 * pos + 2);
            segmentArray[pos] = Math.min(segmentArray[2*pos+1], segmentArray[2*pos+2]);
        }

        public int getMinBetween(int qlow, int qhigh, int len) {
            return getMinBetween(qlow, qhigh, 0, len - 1, 0);
        }

        public void updateSegmentTree(int[] A, int index, int delta) {
             A[index] += delta;
             updateSegmentTree(index, delta, 0, A.length - 1, 0);
        }

        public void updateSegmentTreeRange(int[] A, int startIndex, int endIndex, int delta) {
            for (int i = startIndex; i <= endIndex; i++) {
                A[i] += delta;
            }

            updateSegmentTreeRange(startIndex, endIndex, delta, 0, A.length - 1, 0);
        }

        public void updateSegmentTreeRangeLazy(int[] A, int startIndex, int endIndex, int delta) {
            updateSegmentTreeRangeLazy(startIndex, endIndex, delta, 0, A.length - 1, 0);
        }

        public int rangeMinQueryLazy(int startIndex, int endIndex, int len) {
            return rangeMinQueryLazy(startIndex, endIndex, 0, len - 1, 0);
        }

        private int rangeMinQueryLazy(int qlow, int qhigh, int lo, int hi, int pos) {
            if (lo > hi) {
                return Integer.MAX_VALUE;
            }
             // Make sure all propogation is done at pos. If not update the segment tree at pos
            // and mark children in lazy tree for propogation with appropriate values
            if (lazy[pos] != 0) {
                segmentArray[pos] += lazy[pos];
                if (hi != lo) {
                    lazy[2*pos+1] += lazy[pos];
                    lazy[2*pos+2] += lazy[pos];
                }
                lazy[pos] = 0;                   // propogated
            }

            if (qlow > hi || qhigh < lo) return Integer.MAX_VALUE;          // no overlap

            if (qlow <= lo &&  qhigh >= hi) return segmentArray[pos];       //total overlap, return and don't proceed down
            int mid = lo + (hi - lo)/2;
            return Math.min(rangeMinQueryLazy(qlow, qhigh, lo, mid, 2*pos+1),
                    rangeMinQueryLazy(qlow, qhigh, mid + 1, hi, 2*pos+2));
        }

        private void updateSegmentTreeRangeLazy(int startIndex, int endIndex, int delta, int lo, int hi, int pos) {
            if (lo > hi) return;
            if (lazy[pos] != 0) {
                segmentArray[pos] += lazy[pos];
                if (hi != lo) {
                    lazy[2*pos+1] += lazy[pos];
                    lazy[2*pos+2] += lazy[pos];
                }
                lazy[pos] = 0;
            }
            if (startIndex > hi || endIndex < lo) return;

            if (startIndex <= lo && endIndex >= hi) {
                segmentArray[pos] += delta;
                if (hi != lo) {
                    lazy[2*pos+1] += delta;
                    lazy[2*pos+2] += delta;
                }
                return;
            }

            int mid = lo + (hi - lo)/2;
            updateSegmentTreeRangeLazy(startIndex, endIndex, delta, lo, mid, 2 * pos + 1);
            updateSegmentTreeRangeLazy(startIndex, endIndex, delta, mid + 1, hi, 2 * pos + 2);
            segmentArray[pos] = Math.min(segmentArray[2*pos+1], segmentArray[2*pos+2]);
        }

        private void updateSegmentTreeRange(int startIndex, int endIndex, int delta, int lo, int hi, int pos) {
            if (lo > hi || startIndex > hi || endIndex < lo) {
                return;
            }

            if (lo == hi) {
                segmentArray[pos] += delta;
                return;
            }

            int mid = lo + (hi - lo) / 2;
            updateSegmentTreeRange(startIndex, endIndex, delta, lo, mid, 2 * pos + 1);
            updateSegmentTreeRange(startIndex, endIndex, delta, mid + 1, hi, 2 * pos + 2);
            segmentArray[pos] = Math.min(segmentArray[2*pos +1], segmentArray[2*pos+2]);
        }
        private void updateSegmentTree(int index, int delta, int lo, int hi, int pos) {
            if (index < lo || index > hi) {
                return;
            }
            //If lo becomes hi then index will also become equal and hence update
            if (lo == hi) {
              segmentArray[pos] += delta;
              return;
            }

            //otherwise keep going left and right to find index to be updated
            //and then update current tree position if min of left or right has changed.
            int mid = lo + (hi - lo)/2;
            updateSegmentTree(index, delta, lo, mid, 2 * pos + 1);
            updateSegmentTree(index, delta, mid + 1, hi, 2 * pos + 2);
            segmentArray[pos] = Math.min(segmentArray[2*pos+1], segmentArray[2*pos+2]);
        }

        private int getMinBetween(int qlow, int qhigh, int lo, int hi, int pos) {

            if (qlow <= lo && qhigh >= hi) return segmentArray[pos]; // Query totally covers the intervals at root

            if (qlow > hi || qhigh < lo) return Integer.MAX_VALUE;

            int mid = (lo + hi)/2;
            return Math.min(getMinBetween(qlow, qhigh, lo, mid, 2 * pos + 1), getMinBetween(qlow, qhigh, mid + 1,
                    hi, 2 * pos + 2
            ));
        }

        public static void main(String[] args) {
            int[] A = {-1, 3, 4, 0, 2 ,1};
            SegmentTreeMinQuery s = new SegmentTreeMinQuery();
            s.createSegmentTree(A);
            System.out.println(s.getMinBetween(2, 4, A.length));
            s.updateSegmentTreeRangeLazy(A, 2, 4, 2);
            System.out.println(s.rangeMinQueryLazy(2, 4, A.length));

        }
}
