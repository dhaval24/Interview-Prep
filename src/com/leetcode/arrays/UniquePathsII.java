package com.leetcode.arrays;

/**
 * Created by Dhaval on 8/2/2016.
 * Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,

 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]

 The total number of unique paths is 2.
 Algorithm : Similar DP approach: UniquePaths[i][j] = UniquePaths[i-1][j] + UniquePaths[i][j-1]
 Initialize the buffer grid with leftmost column as 1 until there is an obstacle in the obstacleGrid
 Similarly set topmost row as 1 until there is an obstacle in topmost row of obstacleGrid
 Iterate over the buffer grid from row 1 and column 1 and update the buffer[i][j]'s value with
 the above fromula if the corresponding position in obstacleGrid is not an obstacle i.e 1.
 Return buffer[m-1][n-1]. O(n^2) time and O(n^2) space algorithm
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] buffer = new int[m][n];
        initializeGrid(obstacleGrid, buffer, m, n);
        for (int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++){
                if (obstacleGrid[i][j] == 1){
                    buffer[i][j] = 0;
                }
                else{
                    buffer[i][j] = buffer[i-1][j] + buffer[i][j-1];
                }

            }
        }
        return buffer[m-1][n-1];

    }

    private void initializeGrid(int[][] obstacleGrid, int[][] buffer, int m, int n) {

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) break;
            buffer[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) break;
            buffer[0][i] = 1;
        }
    }

    public static void main(String[] args) {

        int[][] obstacleGrid = new int[3][3];
        obstacleGrid[1][1] = 1;
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(obstacleGrid));
    }
}
