package Trees.DiameterOfBinaryTree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: root = [1,2,3,4,5]
    Output: 3
     */
    @Test
    public void TestCase1() {
        Solution.TreeNode root = new Solution.TreeNode(1);
        root.left = new Solution.TreeNode(2);
        root.right = new Solution.TreeNode(3);
        root.left.left = new Solution.TreeNode(4);
        root.left.right = new Solution.TreeNode(5);

        int expectedResult = 3;
        evaluateSolution(root, expectedResult);
    }

    /*
    Input: root = [1,2]
    Output: 1
     */
    @Test
    public void TestCase2() {
        Solution.TreeNode root = new Solution.TreeNode(1);
        root.left = new Solution.TreeNode(2);

        int expectedResult = 1;
        evaluateSolution(root, expectedResult);
    }

    private void evaluateSolution(Solution.TreeNode root, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.diameterOfBinaryTree(root);

        assertEquals(expectedResult, actualResult);
    }
}
