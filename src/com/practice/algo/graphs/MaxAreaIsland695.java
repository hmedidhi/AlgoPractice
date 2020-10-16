package com.practice.algo.graphs;

public class MaxAreaIsland695 {

	public int maxAreaOfIsland(int[][] grid) {

		int maxArea = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					int area = dfs(grid, 0, i, j);
					if (maxArea < area)
						maxArea = area;
				}

			}
		}
		return maxArea;
	}

	private int dfs(int[][] grid, int tempArea, int i, int j) {
		if (i < 0 || j < 0 || j > grid[0].length - 1 || i > grid.length - 1 || grid[i][j] == 0) {
			return 0;
		}
		grid[i][j] = 0;
		return 1 + dfs(grid, tempArea + 1, i - 1, j) + dfs(grid, tempArea + 1, i + 1, j)
				+ dfs(grid, tempArea + 1, i, j - 1) + dfs(grid, tempArea + 1, i, j + 1);

	}

	public static void main(String[] args) {
		int[][] grid3 = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 1 } };
		int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		int[][] grid2 = { { 0, 0, 0, 0, 0, 0, 0, 0 } };
		int[][] grid4 = { { 1, 0, 1 }, { 1, 1, 1 }, { 0, 0, 1 } };
		System.out.println(new MaxAreaIsland695().maxAreaOfIsland(grid4));
	}

}
