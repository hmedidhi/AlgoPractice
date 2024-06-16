package com.practice.interview150.hard;

public class NQueensII {

    boolean[][] board;

    public int totalNQueens(int n) {
        board = new boolean[n][n];
        return queenHelper(0, n);
    }

    private int queenHelper(int row, int n) {
        if (row == n)
            return 1;
        int solution = 0;
        for (int column = 0; column < n; column++) {
            if (is_not_under_attack(row, column)) {
                board[row][column] = true;
                solution += queenHelper(row + 1, n);
                board[row][column] = false;
            }
        }
        return solution;
    }

    private boolean is_not_under_attack(int row, int column) {
        //validate column
        for(int i=row;i>=0;i--){
            if(board[i][column])
                return false;
        }

        //checking upper left diagonal
        for(int i=row,j=column;i>=0&&j>=0;i--,j--){
            if(board[i][j])
                return false;
        }

        //upper right diagonal
        for(int i=row,j=column;i>=0&&j<board[0].length;i--,j++){
            if(board[i][j])
                return false;
        }
        return true;
    }

}
