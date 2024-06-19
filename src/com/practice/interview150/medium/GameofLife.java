package com.practice.interview150.medium;

public class GameofLife {
    public void gameOfLife(int[][] board) {
        int[][] temp = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                temp[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int live_neighbours = checkLiveNeighbours(temp,i,j);
                if(live_neighbours<2 && board[i][j]==1)
                    board[i][j]=0;
                else if(live_neighbours==3 && board[i][j]==0)
                    board[i][j]=1;
                else if(live_neighbours>3 && board[i][j]==1)
                    board[i][j]=0;
            }
        }
    }

    private int checkLiveNeighbours(int[][] temp, int i, int j) {
        int lives=0;

        if(i-1>=0 && temp[i-1][j]==1)
            lives++;
        if(j-1>=0 && temp[i][j-1]==1)
            lives++;
        if(i-1>=0 && j-1>=0 && temp[i-1][j-1]==1)
            lives++;

        if(i+1< temp.length && temp[i+1][j]==1)
            lives++;
        if(j+1<temp[0].length && temp[i][j+1]==1)
            lives++;
        if(i+1< temp.length && j+1<temp[0].length && temp[i+1][j+1]==1)
            lives++;

        if(i-1>=0 && j+1<temp[0].length && temp[i-1][j+1]==1)
            lives++;
        if(i+1<temp.length && j-1>=0 && temp[i+1][j-1]==1)
            lives++;

        return lives;
    }
}
