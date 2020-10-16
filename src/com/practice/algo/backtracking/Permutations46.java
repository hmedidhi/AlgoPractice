package com.practice.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {

	private List<List<Integer>> outputs = new ArrayList<List<Integer>>();

	public List<List<Integer>> permute(int[] nums) {

		permutation(0, nums);
		return outputs;
	}

	private void swap(int[] nums, int i, int j) {
		int x = nums[i];
		nums[i] = nums[j];
		nums[j] = x;
	}

	void permutation(int location, int[] nums) {
		if (location == nums.length - 1) {
			List<Integer> output = new ArrayList<Integer>();
			for (int num : nums)
				output.add(num);
			outputs.add(output);
		} else {
			for (int i = location; i < nums.length; i++) {
				swap(nums, location, i);
				permutation(location + 1, nums);
				swap(nums, i, location);
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
