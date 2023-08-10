package Trees.DiameterOfBinaryTree;

// *******************************************************************
// Optimal solution using post order traversal -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(1) + O(h) for recursive stack space where h is the height of the tree.
 */
public class Solution {

    private int diameter = -1;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }

    // helper function for post order traversal of tree and setting diameter variable
    private int dfs(TreeNode node) {
        if (node == null) return -1;
        int leftTreeDiameter = 1 + dfs(node.left);
        int rightTreeDiameter = 1 + dfs(node.right);
        diameter = Math.max(diameter, leftTreeDiameter + rightTreeDiameter);
        return Math.max(leftTreeDiameter, rightTreeDiameter);
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

// *******************************************************************
// Brute force solution -

/**
 * Time Complexity - O(n^2)
 * Space Complexity - O(1) + O(h) for recursive stack space where h is the height of the tree.
 */
class Solution1 {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int leftTreeHeight = height(root.left);
        int rightTreeHeight = height(root.right);

        int diameterOfLeftTree = diameterOfBinaryTree(root.left);
        int diameterOfRightTree = diameterOfBinaryTree(root.right);

        return Math.max(leftTreeHeight + rightTreeHeight, Math.max(diameterOfLeftTree, diameterOfRightTree));

    }

    // Utility function to find the height of the tree.
    private int height(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(height(root.left), height(root.right));
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