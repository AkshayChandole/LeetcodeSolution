package BinarySearch.Search2DMatrix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
    Output: true
     */
    @Test
    public void TestCase1(){
        int[][] matrix = new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        int target = 3;
        boolean expectedResult = true;
        evaluateSolution(matrix, target, expectedResult);
    }

    /*
    Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
    Output: false
     */
    @Test
    public void TestCase2(){
        int[][] matrix = new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        int target = 13;
        boolean expectedResult = false;
        evaluateSolution(matrix, target, expectedResult);
    }

    private void evaluateSolution(int[][] matrix, int target, boolean expectedResult) {
        Solution solution = new Solution();
        boolean actualResult = solution.searchMatrix(matrix, target);
        assertEquals(expectedResult, actualResult);
    }
}
