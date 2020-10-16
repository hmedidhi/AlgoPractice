package com.practice.algo.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges994 {

	class Node {
		int i, j;

		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public int orangesRotting(int[][] grid) {

		Queue<Node> queue = new LinkedList<>();
		int[][] directions = { { -1, 0 }, { +1, 0 }, { 0, -1 }, { 0, +1 } };
		int count = 0;
		int fresh = 0;
		boolean[][] marker = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					queue.add(new Node(i, j));
					marker[i][j] = true;
				} else if (grid[i][j] == 0) {
					marker[i][j] = true;
				} else {
					fresh++;
				}
			}
		}
		if (fresh == 0)
			return 0;
		while (!queue.isEmpty()) {
			int c = queue.size();
			while (c-- > 0) {
				Node node = queue.poll();
				for (int[] dir : directions) {
					if (isValid(grid, node.i + dir[0], node.j + dir[1], marker)) {
						marker[node.i + dir[0]][node.j + dir[1]] = true;
						queue.add(new Node(node.i + dir[0], node.j + dir[1]));
						fresh--;
					}
				}
			}
			count++;
		}
		if (fresh != 0)
			return -1;
		return count - 1;
	}

	private boolean isValid(int[][] grid, int i, int j, boolean[][] marker) {
		if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || marker[i][j])
			return false;
		return true;
	}

	public static void main(String[] args) {
		int[][] grid1 = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
		int[][] grid2 = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		int[][] grid3 = { { 0, 2 } };
		System.out.println(new RottingOranges994().orangesRotting(grid3));
	}

}
