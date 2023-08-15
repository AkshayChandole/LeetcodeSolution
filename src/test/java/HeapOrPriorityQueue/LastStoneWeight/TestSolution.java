package HeapOrPriorityQueue.LastStoneWeight;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    /*
    Input: stones = [2,7,4,1,8,1]
    Output: 1
     */
    @Test
    public void TestCase1() {
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};
        int expectedResult = 1;
        evaluateSolution(stones, expectedResult);
    }

    /*
    Input: stones = [1]
    Output: 1
     */
    @Test
    public void TestCase2() {
        int[] stones = new int[]{1};
        int expectedResult = 1;

        evaluateSolution(stones, expectedResult);
    }

    private void evaluateSolution(int[] stones, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.lastStoneWeight(stones);

        assertEquals(expectedResult, actualResult);
    }


}
