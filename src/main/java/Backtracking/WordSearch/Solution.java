package Backtracking.WordSearch;

// ****************************************************************************************
// Optimal Solution using backtracking -

/**
 * Time Complexity - O(N * M * 4^L) - where N and M are the dimensions of the board, and L is the length of the word
 * Space Complexity - O(L) - this space is used by the recursion stack, where L is the length of the word.
 */
class Solution {
    private char[][] board;
    private int rows;
    private int cols;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (backtrack(row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int row, int col, String word, int index) {
        // Base case for the termination of backtracking.
        if (index >= word.length()) {
            return true;
        }

        // Check the boundaries and if the current cell matches the current character in the word.
        if (row < 0 || row == rows || col < 0 || col == cols || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark the choice before exploring further.
        board[row][col] = '#';

        // Explore the 4 possible directions.
        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};

        for (int d = 0; d < 4; d++) {
            if (backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1)) {
                return true;
            }
        }

        // Revert the choice for backtracking
        board[row][col] = word.charAt(index);
        return false;
    }
}