package Trees.SubtreeOfAnotherTree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: root = [3,4,5,1,2], subRoot = [4,1,2]
    Output: true
     */
    @Test
    public void TestCase1() {
        Solution.TreeNode root = new Solution.TreeNode(3);
        root.left = new Solution.TreeNode(4);
        root.right = new Solution.TreeNode(5);
        root.left.left = new Solution.TreeNode(1);
        root.left.right = new Solution.TreeNode(2);

        Solution.TreeNode subRoot = new Solution.TreeNode(4);
        subRoot.left = new Solution.TreeNode(1);
        subRoot.right = new Solution.TreeNode(2);

        boolean expectedResult = true;

        evaluateSolution(root, subRoot, expectedResult);
    }

    /*
    Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
    Output: false
     */
    @Test
    public void TestCase2() {
        Solution.TreeNode root = new Solution.TreeNode(3);
        root.left = new Solution.TreeNode(4);
        root.right = new Solution.TreeNode(5);
        root.left.left = new Solution.TreeNode(1);
        root.left.right = new Solution.TreeNode(2);
        root.left.right.left = new Solution.TreeNode(0);

        Solution.TreeNode subRoot = new Solution.TreeNode(4);
        subRoot.left = new Solution.TreeNode(1);
        subRoot.right = new Solution.TreeNode(2);

        boolean expectedResult = false;

        evaluateSolution(root, subRoot, expectedResult);
    }

    private void evaluateSolution(Solution.TreeNode root, Solution.TreeNode subRoot, boolean expectedResult) {
        Solution solution = new Solution();
        boolean actualResult = solution.isSubtree(root, subRoot);

        assertEquals(expectedResult, actualResult);
    }
}
