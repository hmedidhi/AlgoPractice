package com.practice.interview150.medium;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        int n = matrix.length;
        int i = 0;
        int j = 0;
        while (n > 0) {
            for (j = 0; j < matrix[0].length & n > 0; j++) {
                result.add(matrix[i][j]);
                n--;
            }
            for (i = 0; i < matrix.length & n > 0; i++) {
                result.add(matrix[i][j]);
                n--;
            }
        }
        return result;
    }
}
