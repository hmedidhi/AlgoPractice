package com.practice.algo.graphs;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourcetoTarget797 {

	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

		if (graph.length < 1)
			return result;
		List<Integer> lst = new ArrayList<>();
		lst.add(0);
		findPaths(graph, 0, lst);
		return result;

	}

	private void findPaths(int[][] graph, int i, List<Integer> lst) {
		if (i == graph.length - 1) {
			List<Integer> subList = new ArrayList<>();
			subList.addAll(lst);
			result.add(subList);
			return;
		}
		for (int x : graph[i]) {
			lst.add(x);
			findPaths(graph, x, lst);
			lst.remove(lst.size() - 1);
		}
		return;

	}

	public static void main(String[] args) {
		AllPathsFromSourcetoTarget797 ps = new AllPathsFromSourcetoTarget797();
		int[][] graph = { { 1, 2 }, { 3 }, { 3 }, {} };
		System.out.println(ps.allPathsSourceTarget(graph));
	}

}
