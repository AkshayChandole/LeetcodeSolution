package Graphs.CourseSchedule;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    /*
    Example 1:
        Input: numCourses = 2, prerequisites = [[1,0]]
        Output: true
     */
    @Test
    public void TestCase1() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        boolean expectedResult = true;

        evaluateSolution(numCourses, prerequisites, expectedResult);
    }

    /*
    Example 2:
        Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
        Output: false
     */
    @Test
    public void TestCase2() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        boolean expectedResult = false;

        evaluateSolution(numCourses, prerequisites, expectedResult);
    }

    private void evaluateSolution(int numCourses, int[][] prerequisites, boolean expectedResult) {
        Solution solution = new Solution();
        var actualResult = solution.canFinish(numCourses, prerequisites);

        assertEquals(expectedResult, actualResult);
    }
}
