package Trees.InvertBinaryTree;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    /*
    Input: root = [4,2,7,1,3,6,9]
    Output: [4,7,2,9,6,3,1]
     */
    @Test
    public void TestCase1() {
        Solution.TreeNode root = new Solution.TreeNode(4);
        root.left = new Solution.TreeNode(2);
        root.right = new Solution.TreeNode(7);
        root.left.left = new Solution.TreeNode(1);
        root.left.right = new Solution.TreeNode(3);
        root.right.left = new Solution.TreeNode(6);
        root.right.right = new Solution.TreeNode(9);

        Solution solution = new Solution();
        Solution.TreeNode output = solution.invertTree(root);

        assertEquals(4, root.val);
        assertEquals(7, root.left.val);
        assertEquals(2, root.right.val);
        assertEquals(9, root.left.left.val);
        assertEquals(6, root.left.right.val);
        assertEquals(3, root.right.left.val);
        assertEquals(1, root.right.right.val);
    }

    /*
    Input: root = [2,1,3]
    Output: [2,3,1]
     */
    @Test
    public void TestCase2() {
        Solution.TreeNode root = new Solution.TreeNode(2);
        root.left = new Solution.TreeNode(1);
        root.right = new Solution.TreeNode(3);

        Solution solution = new Solution();
        Solution.TreeNode output = solution.invertTree(root);

        assertEquals(2, root.val);
        assertEquals(3, root.left.val);
        assertEquals(1, root.right.val);
    }

    /*
    Input: root = []
    Output: []
     */
    @Test
    public void TestCase3() {
        Solution.TreeNode root = new Solution.TreeNode();

        Solution solution = new Solution();
        Solution.TreeNode output = solution.invertTree(root);

        assertEquals(0, root.val);
        assertEquals(null, root.left);
        assertEquals(null, root.right);
    }

}
