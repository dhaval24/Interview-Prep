package com.leetcode.arrays;

/**
 * Created by Dhaval on 11/8/2016.
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        return rowValidator(board) && colValidator(board) && squareValidator(board);
    }

    private boolean rowValidator(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0 ; i < row; i++) {
            boolean[] buffer = new boolean[10];
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '.') continue;
                if (board[i][j] - 48 > 0 && buffer[board[i][j] - 48]) return false;
                else {
                    buffer[board[i][j] - 48] = true;
                }
            }
        }
        return true;
    }

    private boolean colValidator(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0 ; i < col; i++) {
            boolean[] buffer = new boolean[10];
            for (int j = 0; j < row; j++) {
                if (board[j][i] == '.') continue;
                if (board[j][i] - 48 > 0 && buffer[board[j][i] - 48]) return false;
                else {
                    buffer[board[j][i] - 48] = true;
                }
            }
        }
        return true;
    }

    private boolean squareValidator(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i += 3) {
            for (int j = 0; j < col; j += 3) {
                boolean[] buffer = new boolean[10];
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j+3; l++) {
                        if (board[k][l] == '.') continue;
                        if (board[k][l] - 48 > 0 && buffer[board[k][l] - 48]) return false;
                        else {
                            buffer[board[k][l] - 48] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}
