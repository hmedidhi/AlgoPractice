package com.practice.interview150.medium;

import java.util.HashSet;

public class ValidateSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] col = new HashSet[9];
        HashSet<Character>[] row = new HashSet[9];
        HashSet<Character>[] box = new HashSet[9];
        for (int r = 0; r < 9; r++) {
            row[r] = new HashSet<Character>();
            col[r] = new HashSet<Character>();
            box[r] = new HashSet<Character>();
        }
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                if (board[r][c] != '.')
                    continue;
                char val = board[r][c];

                if (row[r].contains(val))
                    return false;
                row[r].add(val);

                if (col[c].contains(val))
                    return false;
                col[c].add(val);

                int boxId = ((r / 3) * 3) + (c / 3);
                if (box[boxId].contains(val))
                    return false;
                box[boxId].add(val);
            }
        }
        return true;
    }
}
