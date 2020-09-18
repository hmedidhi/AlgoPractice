package com.practice.algo.backtracking;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateParentheses {

	List<String> result = new LinkedList<String>();

	public List<String> generateParenthesis(int n) {
		int open = 0, close = 0;
		if (n < 1) {
			return result.stream().collect(Collectors.toList());
		}
		generate(open, close, n, "");
		return result;
	}

	private void generate(int open, int close, int limit, String substr) {
		if (open > limit || close > limit || open - close < 0)
			return;
		if (open == limit && close == limit) {
			result.add(substr);
		}
		generate(open + 1, close, limit, substr + "(");
		generate(open, close + 1, limit, substr + ")");
	}

	public static void main(String args[]) {
		GenerateParentheses gp = new GenerateParentheses();
		System.out.println(gp.generateParenthesis(3));
	}
}
