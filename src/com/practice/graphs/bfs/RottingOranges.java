package com.practice.graphs.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int fruitsAvailable = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fruitsAvailable++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        if (fruitsAvailable == 0)
            return 0;
        int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int minutes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasRotten = false;
            for (int i = 0; i < size; i++) {
                int[] pair = queue.poll();
                int r = pair[0];
                int c = pair[1];
                for (int[] direction : directions) {
                    int newRow = r + direction[0];
                    int newCol = c + direction[1];
                    if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && !vis[newRow][newCol] && grid[newRow][newCol] == 1) {
                        hasRotten = true;
                        vis[newRow][newCol] = true;
                        fruitsAvailable--;
                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }
            if (hasRotten) {
                minutes++;
            }
        }
        return fruitsAvailable == 0 ? minutes : -1;
    }
}
