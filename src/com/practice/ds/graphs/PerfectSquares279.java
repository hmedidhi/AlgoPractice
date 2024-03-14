package com.practice.ds.graphs;

import java.util.HashMap;
import java.util.Map;

public class PerfectSquares279 {

	public int numSquares(int n) {
		int x = (int) Math.sqrt(n);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i <= x; i++)
			map.put(i, i * i);

		return perfectSquare(map, n, 0);
	}

	private int perfectSquare(Map<Integer, Integer> map, int n, int sum) {
		if (sum > n)
			return Integer.MAX_VALUE;

		if (sum == n)
			return 0;
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
