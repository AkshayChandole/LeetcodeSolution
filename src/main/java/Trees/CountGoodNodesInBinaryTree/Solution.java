package Trees.CountGoodNodesInBinaryTree;

// ******************************************************************************************
// Optimal Solution -

/**
 *  Time Complexity - O(n) where n is the number of nodes, as each node is visited once.
 *  Space Complexity - O(h), where h is the height of the tree, representing the recursion stack space.
 */
public class Solution {
    public int goodNodes(TreeNode root) {
        return calculateGoodNodes(root, Integer.MIN_VALUE);
    }

    public int calculateGoodNodes(TreeNode root, int maxValue) {
        if (root == null) return 0;

        int count = root.val >= maxValue ? 1 : 0;

        maxValue = Math.max(root.val, maxValue);
        count += calculateGoodNodes(root.left, maxValue);
        count += calculateGoodNodes(root.right, maxValue);

        return count;
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
