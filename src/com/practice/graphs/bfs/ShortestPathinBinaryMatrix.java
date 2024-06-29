package com.practice.graphs.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinBinaryMatrix {

    private static final int[][] directions =
            new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        boolean[][] visited =new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int row = temp[0];
            int col = temp[1];
            int distance = temp[2];
            if(row== grid.length-1&& col == grid[0].length-1)
                return distance;
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if(newRow<0||newCol<0|| newRow>= grid.length || newCol>= grid[0].length || grid[newRow][newCol]==1 || visited[newRow][newCol])
                    continue;
                visited[newRow][newCol] = true;
                queue.add(new int[]{newRow,newCol,distance+1});
            }
        }
        return -1;
    }


}
