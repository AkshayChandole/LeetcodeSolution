package Graphs.SurroundedRegions;

// ********************************************************************************
// Optimal Solution using depth first search -

/**
 * Time Complexity: O(M * N) where M and N are the dimensions of the board.
 * Space Complexity: O(M * N) for the recursion stack in the worst case.
 */
public class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        // Capture the un-surrounded regions at the top and bottom row ( O -> # )
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }

            if (board[n - 1][i] == 'O') {
                dfs(board, n - 1, i);
            }
        }

        // Capture the un-surrounded regions at the left and right columns ( O -> # )
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }

            if (board[i][m - 1] == 'O') {
                dfs(board, i, m - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Capture surrounded regions (O -> X)
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                // Un-capture un-surrounded regions (# -> 0)
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        int n = board.length;
        int m = board[0].length;

        if (row < 0 || row >= n || col < 0 || col >= m || board[row][col] != 'O') {
            return;
        }

        board[row][col] = '#';

        dfs(board, row + 1, col);   // bottom
        dfs(board, row - 1, col);   // up
        dfs(board, row, col - 1);   // left
        dfs(board, row, col + 1);   // right
    }
}
