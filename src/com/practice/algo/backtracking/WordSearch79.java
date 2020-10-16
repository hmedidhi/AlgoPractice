package com.practice.algo.backtracking;

class WordSearch79 {

	public boolean exist(char[][] board, String word) {

		boolean[][] marker = new boolean[board.length][board[0].length];
		if (word.length() == 0)
			return false;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (searchWord(board, word, marker, 0, i, j))
					return true;
			}
		}
		return false;

	}

	private boolean searchWord(char[][] board, String word, boolean[][] marker, int location, int i, int j) {

		if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || marker[i][j])
			return false;

		if (word.charAt(location) == board[i][j]) {
			if (location == word.length() - 1)
				return true;
			marker[i][j] = true;
			location++;
			if (searchWord(board, word, marker, location, i + 1, j)
					|| searchWord(board, word, marker, location, i - 1, j)
					|| searchWord(board, word, marker, location, i, j + 1)
					|| searchWord(board, word, marker, location, i, j - 1))
				return true;
			else
				marker[i][j] = false;
		}
		return false;
	}

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } };

		System.out.println(new WordSearch79().exist(board, "ABCESEEEFS"));

	}

}
