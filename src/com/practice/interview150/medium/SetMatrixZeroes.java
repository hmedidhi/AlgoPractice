package com.practice.interview150.medium;

import java.util.HashSet;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> ele = new HashSet<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    ele.add(i);
                }
            }
        }
        for(int x:ele.stream().toList()){
            for(int i=0;i<matrix.length;i++)
                matrix[i][x]=0;
            for(int i=0;i<matrix[0].length;i++)
                matrix[x][i]=0;
        }
    }
}
