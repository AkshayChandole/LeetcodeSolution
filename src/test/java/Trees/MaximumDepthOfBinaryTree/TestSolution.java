package Trees.MaximumDepthOfBinaryTree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: root = [3,9,20,null,null,15,7]
    Output: 3
     */
    @Test
    public void TestCase1(){
        Solution.TreeNode root = new Solution.TreeNode(3);
        root.left = new Solution.TreeNode(9);
        root.right = new Solution.TreeNode(20);
        root.right.left = new Solution.TreeNode(15);
        root.right.right = new Solution.TreeNode(7);

        int expectedResult = 3;

        evaluateSolution(root, expectedResult);
    }

    /*
    Input: root = [1,null,2]
    Output: 2
     */
    @Test
    public void TestCase2(){
        Solution.TreeNode root = new Solution.TreeNode(1);
        root.right = new Solution.TreeNode(2);

        int expectedResult = 2;

        evaluateSolution(root, expectedResult);
    }

    private void evaluateSolution(Solution.TreeNode root, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.maxDepth(root);

        assertEquals(expectedResult, actualResult);
    }
}
