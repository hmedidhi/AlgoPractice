package com.practice.interview150.medium;

public class WordSearch {

    boolean[][] temp;

    public boolean exist(char[][] board, String word) {
        temp = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(existUtils(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existUtils(char[][] board, String word, int index, int i, int j) {
        if (index == word.length())
            return true;
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1)
            return false;

        boolean result = false;
        if (word.charAt(index) == board[i][j]) {
            temp[i][j]= true;
            result =  existUtils(board, word, 1, i+1, j) ||existUtils(board, word, 1, i, j+1)
                    || existUtils(board, word, 1, i-1, j) ||existUtils(board, word, 1, i, j-1);
            temp[i][j]=false;
        }

        return result;
    }
}
