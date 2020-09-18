package com.practice.algo.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
	List<List<String>> soln = new LinkedList<List<String>>();

	public List<List<String>> solveNQueens(int n) {
		// Traverse thru the each row // Place all dots // validate for each row // then
		// clone the list for next set
		if (n == 1)
			soln.add(Arrays.asList("Q"));
		if (n < 4)
			return soln;
		for (int i = 0; i < n; i++) {
			char[][] lst = new char[n][n];
			fillList(lst, n, 0, i);
			backtracking(lst, n, 1);
		}
		return soln;
	}

	private void backtracking(char[][] lst, int n, int row) {
		if (row < n) {
			for (int i = 0; i < n; i++) {
				char[][] clonelist = cloneList(lst);
				if (lst[row][i] != 'Q' && lst[row][i] != '.') {
					fillList(lst, n, row, i);
					backtracking(lst, n, row + 1);
					lst = clonelist;
				}
			}
		} else {
			soln.add(printlist(lst));
		}
	}

	private char[][] cloneList(char[][] lst) {
		char[][] cloneList = new char[lst.length][lst.length];
		for (int i = 0; i < lst.length; i++) {
			for (int j = 0; j < lst.length; j++) {
				cloneList[i][j] = lst[i][j];
			}
		}
		return cloneList;
	}

	private List<String> printlist(char[][] lst) {
		List<String> result = new LinkedList<>();
		for (char[] charArr : lst) {
			result.add(String.copyValueOf(charArr));
		}
		return result;
	}

	private boolean fillList(char[][] lst, int n, int row, int coln) {
		lst[row][coln] = 'Q';

		// fill row
		for (int i = 0; i < coln; i++) {
			lst[row][i] = '.';
		}
		// fill row
		for (int i = coln + 1; i < n; i++) {
			lst[row][i] = '.';
		}

		// fill coln
		for (int i = 0; i < row; i++) {
			lst[i][coln] = '.';
		}

		// fill coln
		for (int i = row + 1; i < n; i++) {
			lst[i][coln] = '.';
		}

		// fill diagonal
		int i = row - 1, j = coln - 1;
		while (i >= 0 && j >= 0) {
			lst[i][j] = '.';
			i--;
			j--;
		}

		i = row + 1;
		j = coln + 1;
		while (i < n && j < n) {
			lst[i][j] = '.';
			i++;
			j++;
		}

		i = row - 1;
		j = coln + 1;
		while (i >= 0 && j < n) {
			lst[i][j] = '.';
			i--;
			j++;
		}

		i = row + 1;
		j = coln - 1;
		while (i < n && j >= 0) {
			lst[i][j] = '.';
			i++;
			j--;
		}

		return true;

	}

	public static void main(String[] args) {
		NQueens nq = new NQueens();
		System.out.println(nq.solveNQueens(5));
	}
}
