package com.practice.ds.graphs;

public class FriendCircles537 {

	public int findCircleNum(int[][] M) {
		int count = 0;
		boolean[] visited = new boolean[M.length];
		for (int i = 0; i < M.length; i++) {
			if (!visited[i]) {
				count++;
				visited[i] = true;
				dfs(M, i, visited);
			}

		}
		return count;
	}

	private void dfs(int[][] m, int node, boolean[] visited) {
		for (int j = 0; j < m.length; j++) {
			if (m[node][j] == 1 && !visited[j]) {
				visited[j] = true;
				dfs(m, j, visited);
			}
		}
	}

	public static void main(String[] args) {
		int[][] m = { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } };
		System.out.println(new FriendCircles537().findCircleNum(m));
	}

}
