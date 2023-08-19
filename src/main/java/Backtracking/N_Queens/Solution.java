package Backtracking.N_Queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// ****************************************************************************************
// Optimal Solution using backtracking -

/**
 * Time Complexity - O(N!) - There are N possibilities for the first queen, N-1 for the second, and so on. However, you don't need to explore all possibilities since, for instance, after placing 2 queens, you'll know if it's possible to continue.
 * <p>
 * Space Complexity- O(N) - To keep track of the placement of queens.
 */
public class Solution {
    private final List<List<String>> result = new ArrayList<>();
    private int[] queens;

    public List<List<String>> solveNQueens(int n) {
        queens = new int[n];
        Arrays.fill(queens, -1);
        backtrack(0, n);
        return result;
    }

    private void backtrack(int row, int n) {
        if (row == n) {
            List<String> board = generateBoard(n);
            result.add(board);
            return;
        }

        for (int column = 0; column < n; column++) {
            if (!canPlace(row, column)) {
                continue;
            }

            queens[row] = column;
            backtrack(row + 1, n);

            // undo the choice for backtracking
            queens[row] = -1;
        }
    }

    private boolean canPlace(int row, int column) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevColumn = queens[prevRow];
            if (prevColumn == column || prevColumn - prevRow == column - row || prevColumn + prevRow == column + row) {
                return false;
            }
        }
        return true;
    }

    private List<String> generateBoard(int n) {
        List<String> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }

        return board;
    }
}
