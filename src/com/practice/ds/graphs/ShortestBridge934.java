package com.practice.ds.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge934 {

	Queue<Node> queue = new LinkedList<>();

	class Node {
		int i, j;

		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}

	}

	public int shortestBridge(int[][] A) {
		boolean[][] marker = new boolean[A.length][A[0].length];
		boolean found = false;
		for (int i = 0; i < A.length; i++) {
			if (found)
				break;
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] == 1 && !marker[i][j]) {
					dfs(A, marker, i, j);
					found = true;
					break;
				}
			}
		}

		int val = 0;
		while (!queue.isEmpty()) {
			int c = queue.size();
			while (c > 0) {
				Node node = queue.poll();

				if (isvalid(A, node.i + 1, node.j, marker)) {
					if (A[node.i + 1][node.j] == 1)
						return val;
					queue.add(new Node(node.i + 1, node.j));
					marker[node.i + 1][node.j] = true;
				}

				if (isvalid(A, node.i - 1, node.j, marker)) {
					if (A[node.i - 1][node.j] == 1)
						return val;
					queue.add(new Node(node.i - 1, node.j));
					marker[node.i - 1][node.j] = true;
				}

				if (isvalid(A, node.i, node.j + 1, marker)) {
					if (A[node.i][node.j + 1] == 1)
						return val;
					queue.add(new Node(node.i, node.j + 1));
					marker[node.i][node.j + 1] = true;
				}

				if (isvalid(A, node.i, node.j - 1, marker)) {
					if (A[node.i][node.j - 1] == 1)
						return val;
					queue.add(new Node(node.i, node.j - 1));
					marker[node.i][node.j - 1] = true;
				}
				c--;
			}

			val++;
		}

		return val;
	}

	private boolean isvalid(int[][] a, int i, int j, boolean[][] marker) {
		if (i < 0 || j < 0 || i > a.length - 1 || j > a[0].length - 1 || marker[i][j])
			return false;
		return true;
	}

	private void dfs(int[][] a, boolean[][] marker, int i, int j) {
		if (i < 0 || j < 0 || i > a.length - 1 || j > a[0].length - 1 || marker[i][j] || a[i][j] == 0)
			return;
		marker[i][j] = true;
		queue.add(new Node(i, j));
		dfs(a, marker, i - 1, j);
		dfs(a, marker, i + 1, j);
		dfs(a, marker, i, j - 1);
		dfs(a, marker, i, j + 1);

	}

	public static void main(String[] args) {
		int[][] input = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 1 } };
		int[][] input3 = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 1 } };
		int[][] input2 = { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 },
				{ 1, 1, 1, 1, 1 } };
		int[][] input4 = { { 1, 1, 0, 0, 0 }, { 1, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 1, 1 },
				{ 0, 0, 0, 1, 1 } };
		int[][] input5 = { { 0, 0, 1, 0, 1 }, { 0, 1, 1, 0, 1 }, { 0, 1, 0, 0, 1 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		System.out.println(new ShortestBridge934().shortestBridge(input5));
	}

}
