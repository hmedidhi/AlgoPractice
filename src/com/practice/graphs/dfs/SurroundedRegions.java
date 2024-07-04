package com.practice.graphs.dfs;

public class SurroundedRegions {
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];


    }

    private boolean check4Directions(char[][] board, int i, int j) {
        if(board[i-1][j]=='X'&&board[i+1][j]=='X'&&board[i][j-1]=='X'&&board[i][j+1]=='X'){
            return true;
        }
        return false;
    }
}
