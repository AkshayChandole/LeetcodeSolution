package HeapOrPriorityQueue.TaskScheduler;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    /*
    Input: tasks = ['A','A','A','B','B','B'], n = 2
    Output: 8
    */
    @Test
    public void TestCase1() {
        char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        int expectedResult = 8;

        evaluateSolution(tasks, n, expectedResult);
    }

    /*
    Input: tasks = ['A','A','A','B','B','B'], n = 0
    Output: 6
    */
    @Test
    public void TestCase2() {
        char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 0;
        int expectedResult = 6;

        evaluateSolution(tasks, n, expectedResult);
    }

    /*
    Input: tasks = ['A','A','A','A','A','A','B','C','D','E','F','G'], n = 2
    Output: 16
    */
    @Test
    public void TestCase3() {
        char[] tasks = new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int n = 2;
        int expectedResult = 16;

        evaluateSolution(tasks, n, expectedResult);
    }

    private void evaluateSolution(char[] tasks, int n, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.leastInterval(tasks, n);

        assertEquals(expectedResult, actualResult);
    }
}
