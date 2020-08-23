package com.practice.algo.graphs;

public class IslandProblem {

	public int numIslands(char[][] grid) {
		int count = 0;
		if (grid.length == 0) {
			return count;
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					dfs(i, j, grid);
				}

			}
		}
		return count;
	}

	private void dfs(int i, int j, char[][] grid) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
			return;
		grid[i][j] = '0';
		dfs(i - 1, j, grid);
		dfs(i + 1, j, grid);
		dfs(i, j - 1, grid);
		dfs(i, j + 1, grid);

	}

	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		IslandProblem p = new IslandProblem();
		System.out.println(p.numIslands(grid));
	}

}
