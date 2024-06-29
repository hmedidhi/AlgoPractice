package com.practice.graphs.dfs;

public class NumberofIslands {

    private final int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        for (int[] direction : directions) {
            int newRow = i + direction[0];
            int newCol = j + direction[1];
            if(newRow>=0&&newCol>=0&&newRow<grid.length&&newCol< grid[0].length&& grid[newRow][newCol]=='1')
                dfs(grid,newRow,newCol);
        }
    }
}
