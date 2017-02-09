package com.leetcode.graphs;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dhaval on 11/19/2016.
 */
public class CourseSchedule {
    private class Graph {

        final int v;
        List<Integer>[] adj;

        public Graph(int v) {
            this.v = v;
            adj = (List<Integer>[]) new List[v];
            for (int i = 0; i < this.v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void populateAdjList(int[][] edges) {
            int len = edges.length;
            for (int j = 0; j < len; j++) {
                adj[edges[j][0]].add(edges[j][1]);
            }

        }

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites == null || prerequisites.length == 0) return true;
        Graph g = new Graph(numCourses);
        g.populateAdjList(prerequisites);

        boolean[] marked = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if(marked[i]) return false;
            if (!dfs(g, i, marked)) return false;
        }
        return true;
    }

    private boolean dfs(Graph g, int v, boolean[] marked) {

        if(marked[v]) return false;
        marked[v] = true;
        boolean returnVal = true;
        for (int w : g.adj[v]) {
            if (!marked[w]) {
                returnVal = dfs(g, w, marked);
            }
            else {
                return false;
            }
        }
        marked[v] = false;
        return returnVal;

    }

    public static void main(String[] args) {
        int numCourses = 3;
        int[][] prereq = {{1,0},{1,2},{2,1}};
        System.out.println(new CourseSchedule().canFinish(numCourses, prereq));
    }
}
