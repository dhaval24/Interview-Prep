package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Dhaval on 3/1/2017.
 */
public class SkyLine {

    private class BuildingPoint implements Comparable<BuildingPoint> {

        int x;
        int y;
        boolean isStart;

        BuildingPoint(int x, int y, boolean isStart) {
            this.x = x;
            this.y = y;
            this.isStart = isStart;
        }

        /*
            If X is different sort on X
            If X is same then if comparing both start point sort based on higher(Building with higher height comes first)
            If X is same and both are end points the building with lower height should come first.
            If X is same and one is start point and other is end then start point should come first
         */
        @Override
        public int compareTo(BuildingPoint o) {
            if (this.x != o.x) {
                return this.x - o.x;
            }
            else {
                return (this.isStart ? -this.y : this.y) - (o.isStart  ? -o.y : o.y);
            }
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {


        if (buildings == null) throw new IllegalArgumentException();
        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length * 2];
        List<int[]> result = new ArrayList<>();
        int index = 0;
        for (int[] building : buildings) { //Split array into start and end points
            buildingPoints[index++] = new BuildingPoint(building[0], building[2], true);
            buildingPoints[index++] = new BuildingPoint(building[1], building[2], false);
        }
        Arrays.sort(buildingPoints);

        TreeMap<Integer, Integer> map = new TreeMap<>(); // Use tree map instead of max - PQ as it supports O(log n) time deletion
        map.put(0, 1); //To simplify calculations

        int prevMaxHeight = 0;
        for (BuildingPoint bp : buildingPoints) {
            if (bp.isStart) { //If start point then add height to Map and see if it changes max height and if so add that point to result and if so add that point's X coordinate
                                //and current max height in answer
                if (!map.containsKey(bp.y)) {
                    map.put(bp.y ,0);
                }
                map.put(bp.y, map.get(bp.y) + 1);
            }
            else {
                map.put(bp.y, map.get(bp.y) - 1);
                if (map.get(bp.y) == 0) {
                    map.remove(bp.y);
                }
            }

            if (map.lastKey() != prevMaxHeight) { //If end point remove the height and check if it changes the max height and if so add that point's X coordinate
                                                    //and current max height in answer
                prevMaxHeight = map.lastKey();
                result.add(new int[] {bp.x, prevMaxHeight});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] buildings = {{2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}};
        System.out.println(new SkyLine().getSkyline(buildings));
    }
}
