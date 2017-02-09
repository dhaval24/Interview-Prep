package com.leetcode.arrays;

/**
 * Created by Dhaval on 11/9/2016.
 */
public class MaximalSquare {

    public int maximalSquare(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return 0;

        int row = board.length;
        int col = board[0].length;


        int[][] buffer = new int[row][col];
        fillFirstRow(board, buffer);
        fillFirstCol(board, buffer);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (board[i][j] == '1') {
                    int min = Math.min(buffer[i][j-1], buffer[i-1][j]);
                    min = Math.min(min, buffer[i-1][j-1]);
                    buffer[i][j] = min + 1;

                }
                else {
                    buffer[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max, buffer[i][j]);
            }
        }
        return max * max;
    }

    private void fillFirstRow(char[][] board, int[][] buffer) {
        int col = board[0].length;
        for (int j = 0; j < col; j++) {
            buffer[0][j] = board[0][j]-48;

        }
    }

    private void fillFirstCol(char[][] board, int[][] buffer) {
        int row = board.length;
        for (int i = 1; i < row; i++) {
            buffer[i][0] = board[i][0]-48;
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','0','1'}, {'1','0','1','1','1'}};
        //char[][] board = {{'1','0'}};
        System.out.println(new MaximalSquare().maximalSquare(board));
    }
}
