package com.practice.algo.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueensRevisit {
	List<List<String>> soln = new LinkedList<List<String>>();
	int count= 0;

	public List<List<String>> solveNQueens(int n) {
		// Traverse thru the each row // Place all dots // validate for each row // then
		// clone the list for next set
		if (n == 1)
			soln.add(Arrays.asList("Q"));
		if (n < 4)
			return soln;

		char[][] lst = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				lst[i][j] = '.';
			}
		}

		for (int i = 0; i < n; i++) {
			lst[0][i] = 'Q';
			backtracking(lst, n, 1);
			lst[0][i] = '.';
		}
		return soln;
	}

	private void backtracking(char[][] lst, int n, int row) {
		if (row < n) {
			for (int i = 0; i < n; i++) {
				if (validate(lst, n, row, i)) {
					lst[row][i] = 'Q';
					backtracking(lst, n, row + 1);
					lst[row][i] = '.';
				}
			}
		} else {
			soln.add(printlist(lst));
			count++;
		}
	}

	private List<String> printlist(char[][] lst) {
		List<String> result = new LinkedList<>();
		for (char[] charArr : lst) {
			result.add(String.copyValueOf(charArr));
		}
		return result;
	}

	private boolean validate(char[][] lst, int n, int row, int coln) {

		// validate row
		for (int i = 0; i < n; i++) {
			if (lst[row][i] == 'Q')
				return false;
		}

		// validate coln
		for (int i = 0; i < n; i++) {
			if (lst[i][coln] == 'Q')
				return false;
		}

		// fill diagonal
		int i = row - 1, j = coln - 1;
		while (i >= 0 && j >= 0) {
			if (lst[i][j] == 'Q')
				return false;
			i--;
			j--;
		}

		i = row + 1;
		j = coln + 1;
		while (i < n && j < n) {
			if (lst[i][j] == 'Q')
				return false;
			i++;
			j++;
		}

		i = row - 1;
		j = coln + 1;
		while (i >= 0 && j < n) {
			if (lst[i][j] == 'Q')
				return false;
			i--;
			j++;
		}

		i = row + 1;
		j = coln - 1;
		while (i < n && j >= 0) {
			if (lst[i][j] == 'Q')
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		NQueensRevisit nq = new NQueensRevisit();
		System.out.println(nq.solveNQueens(5));
		System.out.println(nq.count);
	}
}
