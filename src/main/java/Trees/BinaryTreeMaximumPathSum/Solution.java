package Trees.BinaryTreeMaximumPathSum;

// ***************************************************************
// Optimal Solution -

/**
 * Time Complexity - O(n), where n is the number of nodes. Each node is traversed only once.
 * Space Complexity - O(h), where h is the height of the tree, representing the recursion stack space.
 */

public class Solution {
    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return result;
    }

    private int maxSum(TreeNode node) {
        if (node == null) return 0;

        int leftSum = Math.max(0, maxSum(node.left));
        int rightSum = Math.max(0, maxSum(node.right));

        result = Math.max(result, node.val + leftSum + rightSum);

        return node.val + Math.max(leftSum, rightSum);
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
