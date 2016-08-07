package com.leetcode.arrays;

/**
 * Created by Dhaval on 8/3/2016.
 *  Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]

 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.

 Method 1: exist():
 Use additional mattrix to keep track of visited cells.
 Recurrsively traverse each cell of the 2D array in top, down, left right direction
 keep an index which monitors the length of the string being formed till now and if it
 if the length == size of the target string then return true
 If any time the row and column index goes out of the defined boundries return false
 If the current word being picked is not equal to the word at the index in target return false
 set the current element as visited
 If the aggregate result of the recurssion is false then set the current element as unvisited again in the buffer grid

 Method 2: existElegant()
 Similar to the first method except that addition m*n space is saved by masking the element in the input grid
 This masking is performed by xor the character with 256.
 Note: This method can only handle inputs within the range of 0-256 ascii values
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;
        boolean[][] buffer = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist(board, buffer, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean existElegant(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (existElegant(board, word.toCharArray(), 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existElegant(char[][] board, char[] word, int index, int rowIndex, int colIndex) {

        if (index == word.length) return true;

        if (rowIndex < 0 || colIndex < 0 || rowIndex >= board.length || colIndex >= board[0].length) {
            return false;
        }
        if (board[rowIndex][colIndex] != word[index]) return false;

        board[rowIndex][colIndex] ^= 256; //masking

        boolean res = existElegant(board, word, index + 1, rowIndex + 1, colIndex) ||
                existElegant(board, word, index + 1, rowIndex, colIndex + 1) ||
                existElegant(board, word, index + 1, rowIndex - 1, colIndex) ||
                existElegant(board, word, index + 1, rowIndex, colIndex - 1);

        board[rowIndex][colIndex] ^= 256; //unmasking

        return res;
    }

    private boolean exist(char[][] board, boolean[][] buffer, String word, int index, int rowIndex,
                          int colIndex) {

        if (index >= word.length()) {
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        if (rowIndex < 0 || colIndex < 0 || rowIndex >= m || colIndex >= n) {
            return false;
        }
        if (buffer[rowIndex][colIndex]) {
            return false;
        }
        if (board[rowIndex][colIndex] != word.charAt(index)) {
            return false;
        }

        buffer[rowIndex][colIndex] = true;
        boolean res =  exist(board, buffer, word, index + 1, rowIndex + 1, colIndex) || exist(board,
                    buffer, word, index + 1, rowIndex, colIndex + 1)||
                    exist(board, buffer, word, index + 1, rowIndex -1 , colIndex )||
                    exist(board, buffer, word, index + 1, rowIndex, colIndex -1);

        if (!res) {
            buffer[rowIndex][colIndex] = false;
        }


        return res;
    }

    public static void main(String[] args) {

        char[][] grid = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(new WordSearch().existElegant(grid, "ABCB"));

    }
}
