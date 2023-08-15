package HeapOrPriorityQueue.KClosestPointsToOrigin;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSolution {
    /**
     * Input: points = [[1,3],[-2,2]], k = 1
     *     Output: [[-2,2]]
     */
    @Test
    public void TestCase1(){
        int[][] points = new int[][]{{1,3}, {-2,2}};
        int k = 1;

        int[][] expectedResult = new int[][] {{-2,2}};

        evaluateSolution(points, k, expectedResult);
    }

    /**
     * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
     *     Output: [[3,3],[-2,4]]
     */
    @Test
    public void TestCase2(){
        int[][] points = new int[][]{{3,3},{5,-1},{-2,4}};
        int k = 2;

        int[][] expectedResult = new int[][]{{3,3},{-2,4}};

        evaluateSolution(points, k, expectedResult);
    }

    private void evaluateSolution(int[][] points, int k, int[][] expectedResult) {
        Solution solution = new Solution();
        int [][] actualResult = solution.kClosest(points, k);

        assertArrayEquals(expectedResult, actualResult);
    }

}