package Trees.CountGoodNodesInBinaryTree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: root = [3,1,4,3,null,1,5]
    Output: 4
     */
    @Test
    public void TestCase1(){
        Solution.TreeNode root = new Solution.TreeNode(3);
        root.left = new Solution.TreeNode(1);
        root.right = new Solution.TreeNode(4);
        root.left.left = new Solution.TreeNode(3);
        root.right.left = new Solution.TreeNode(1);
        root.right.right = new Solution.TreeNode(5);

        int expectedResult = 4;

        evaluateSolution(root, expectedResult);
    }

    /*
    Input: root = [3,3,null,4,2]
    Output: 3
     */
    @Test
    public void TestCase2(){
        Solution.TreeNode root = new Solution.TreeNode(3);
        root.left = new Solution.TreeNode(3);
        root.left.left = new Solution.TreeNode(4);
        root.left.right = new Solution.TreeNode(2);

        int expectedResult = 3;

        evaluateSolution(root, expectedResult);
    }

    /*
    Input: root = [1]
    Output: 1
     */
    @Test
    public void TestCase3(){
        Solution.TreeNode root = new Solution.TreeNode(1);

        int expectedResult = 1;

        evaluateSolution(root, expectedResult);
    }

    private void evaluateSolution(Solution.TreeNode root, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.goodNodes(root);

        assertEquals(expectedResult, actualResult);
    }
}
