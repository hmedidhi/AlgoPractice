package com.practice.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {

	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> subsets(int[] nums) {
		result.add(new ArrayList<>());
		for (int num : nums)
			updateList(num);
		return result;
	}

	private void updateList(int num) {
		List<List<Integer>> newUpdatedList = new ArrayList<List<Integer>>();
		for (List<Integer> lst : result) {
			List<Integer> newList = new ArrayList<>();
			newList.addAll(lst);
			newList.add(num);
			newUpdatedList.add(newList);
		}
		result.addAll(newUpdatedList);
	}

	public static void main(String[] args) {

		int[] x = { 1, 2, 3 };
		new Subsets78().subsets(x);
	}

}
