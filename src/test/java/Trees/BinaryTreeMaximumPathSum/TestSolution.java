package Trees.BinaryTreeMaximumPathSum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: root = [1,2,3]
    Output: 6
     */
    @Test
    public void TestCase1() {
        Solution.TreeNode root = new Solution.TreeNode(1);
        root.left = new Solution.TreeNode(2);
        root.right = new Solution.TreeNode(3);

        int expectedResult = 6;

        evaluateSolution(root, expectedResult);
    }

    /*
    Input: root = [-10,9,20,null,null,15,7]
    Output: 42
     */
    @Test
    public void TestCase2() {
        Solution.TreeNode root = new Solution.TreeNode(-10);
        root.left = new Solution.TreeNode(9);
        root.right = new Solution.TreeNode(20);
        root.right.left = new Solution.TreeNode(15);
        root.right.right = new Solution.TreeNode(7);

        int expectedResult = 42;

        evaluateSolution(root, expectedResult);
    }

    /*
    Input: root = [2,-1]
    Output: 2
     */
    @Test
    public void TestCase3() {
        Solution.TreeNode root = new Solution.TreeNode(2);
        root.left = new Solution.TreeNode(-1);
        int expectedResult = 2;

        evaluateSolution(root, expectedResult);
    }

    private void evaluateSolution(Solution.TreeNode root, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.maxPathSum(root);

        assertEquals(expectedResult, actualResult);
    }
}
