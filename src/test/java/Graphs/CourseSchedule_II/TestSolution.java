package Graphs.CourseSchedule_II;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestSolution {
    /*
    Example 1:
        Input: numCourses = 2, prerequisites = [[1,0]]
        Output: [0,1]
     */
    @Test
    public void TestCase1() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        int[] expectedResult = {0, 1};

        evaluateSolution(numCourses, prerequisites, expectedResult);
    }

    /*
    Example 2:
        Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
        Output: [0,2,1,3]
     */
    @Test
    public void TestCase2() {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}

        };
        int[] expectedResult = {0, 1, 2, 3};

        evaluateSolution(numCourses, prerequisites, expectedResult);
    }

    /*
    Example 3:
        Input: numCourses = 1, prerequisites = []
        Output: [0]
     */
    @Test
    public void TestCase3() {
        int numCourses = 1;
        int[][] prerequisites = {};
        int[] expectedResult = {0};

        evaluateSolution(numCourses, prerequisites, expectedResult);
    }

    private void evaluateSolution(int numCourses, int[][] prerequisites, int[] expectedResult) {
        Solution solution = new Solution();
        var actualResult = solution.findOrder(numCourses, prerequisites);

        assertArrayEquals(expectedResult, actualResult);
    }
}
