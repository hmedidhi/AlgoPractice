package com.practice.algo.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule1210 {

	Map<Integer, List<Integer>> map = new HashMap<>();

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		int[] iEdges = new int[numCourses];
		Queue<Integer> queue = new LinkedList<>();

		iEdges = generateDS(prerequisites, iEdges);
		for (int i = 0; i < iEdges.length; i++) {
			if (iEdges[i] == 0)
				queue.add(i);
		}

		int index = 0;
		int[] order = new int[numCourses];
		while (!queue.isEmpty()) {
			int node = queue.poll();
			if (map.containsKey(node))
				for (int edge : map.get(node)) {
					iEdges[edge]--;
					if (iEdges[edge] == 0) {
						queue.add(edge);
					}
				}
			order[numCourses - index - 1] = node;
			index++;
		}

		if (index != numCourses)
			return new int[0];

		return order;

	}

	private int[] generateDS(int[][] prerequisites, int[] iEdges) {
		for (int i = 0; i < prerequisites.length; i++) {
			if (map.containsKey(prerequisites[i][0])) {
				List<Integer> lst = map.get(prerequisites[i][0]);
				lst.add(prerequisites[i][1]);
				map.put(prerequisites[i][0], lst);
			} else {
				List<Integer> lst = new LinkedList<Integer>();
				lst.add(prerequisites[i][1]);
				map.put(prerequisites[i][0], lst);
			}
			iEdges[prerequisites[i][1]]++;
		}
		return iEdges;
	}

	public static void main(String[] args) {
		int input[][] = { { 1, 0 } };
		int[][] input2 = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		System.out.println(new CourseSchedule1210().findOrder(4, input2));

	}

}
