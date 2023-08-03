package BinarySearch.Search2DMatrix;

// ***************************************************************************
// Optimal Solution using 2D Coordinate Axis -

/**
 * Time Complexity - O(m + n)
 * Space Complexity - O(1)
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (m == 0 || matrix[0][0] > target || matrix[m - 1][n - 1] < target) return false;

        int i = m - 1;
        int j = 0;

        while (i >= 0 && j < n) {
            int num = matrix[i][j];
            if (num > target) {
                i--;
            } else if (num < target) {
                j++;
            } else if (num == target) {
                return true;
            }
        }

        return false;
    }
}

// ***************************************************************************
// Better Solution using Binary Search -

/**
 * Time Complexity - O(log(m*n))
 * Space Complexity - O(1)
 */
class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (m == 0 || matrix[0][0] > target || matrix[m - 1][n - 1] < target) return false;

        int start = 0;
        int end = (m * n) - 1;

        while (start <= end) {
            int mid = (start + (end - start) / 2);
            int number = matrix[mid / n][mid % n];
            if (number < target) {
                start = mid + 1;
            } else if (number > target) {
                end = end - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}

// ***************************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(n^2)
 * Space Complexity - O(1)
 */
class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }
}
