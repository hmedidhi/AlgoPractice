package com.practice.interview150.medium;

public class Search2DMatrixII {

    boolean[][] temp;

    public boolean searchMatrix(int[][] matrix, int target) {
        temp = new boolean[matrix.length][matrix[0].length];
        return search(matrix, 0, 0,target);
    }

    private boolean search(int[][] matrix, int i, int j,int target) {
        if(matrix[i][j]==target)
            return true;
        temp[i][j] = true;
        boolean result = false;
        if(i+1<matrix.length&&!temp[i+1][j]&&matrix[i+1][j]<=target){
            result = search(matrix,i+1,j,target);
        }
        if(!result&&j+1<matrix[0].length&&!temp[i][j+1]&&matrix[i][j+1]<=target){
            result = search(matrix,i,j+1,target);
        }

        return result;
    }
}
