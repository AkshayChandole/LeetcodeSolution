package Trees.BalancedBinaryTree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: root = [3,9,20,null,null,15,7]
    Output: true
     */
    @Test
    public void TestCase1() {
        Solution.TreeNode root = new Solution.TreeNode(3);
        root.left = new Solution.TreeNode(9);
        root.right = new Solution.TreeNode(20);
        root.right.left = new Solution.TreeNode(15);
        root.right.right = new Solution.TreeNode(7);

        boolean expectedResult = true;

        evaluateSolution(root, expectedResult);

    }

    /*
    Input: root = [1,2,2,3,3,null,null,4,4]
    Output: false
     */
    @Test
    public void TestCase2() {
        Solution.TreeNode root = new Solution.TreeNode(1);
        root.left = new Solution.TreeNode(2);
        root.right = new Solution.TreeNode(2);
        root.left.left = new Solution.TreeNode(3);
        root.left.right = new Solution.TreeNode(3);
        root.left.left.left = new Solution.TreeNode(4);
        root.left.left.right = new Solution.TreeNode(4);

        boolean expectedResult = false;

        evaluateSolution(root, expectedResult);
    }

    /*
    Input: root = []
    Output: true
     */
    @Test
    public void TestCase3() {
        Solution.TreeNode root = null;
        boolean expectedResult = true;

        evaluateSolution(root, expectedResult);
    }

    private void evaluateSolution(Solution.TreeNode root, boolean expectedResult) {
        Solution solution = new Solution();
        boolean actualResult = solution.isBalanced(root);

        assertEquals(expectedResult, actualResult);
    }
}
