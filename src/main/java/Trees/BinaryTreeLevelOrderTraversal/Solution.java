package Trees.BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// **********************************************************************
// Optimal Solution using DFS and queue -

/**
 * Time Complexity - O(n)  where n is the number of nodes in the tree. Each node is processed exactly once.
 * Space Complexity - O(n), where n is the maximum number of nodes on one level of the binary tree (maximum breadth).
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }
            result.add(currentLevel);
        }

        return result;
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

// **********************************************************************
// Brute force solution using DFS and recursion -

/**
 * Time Complexity - O(n^2)  ... This is because for each level of the tree, you're traversing the entire tree.
 * Space Complexity - O(n) for the recursion stack in the worst-case scenario.
 */
class Solution1 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int height = getHeight(root);

        for (int i = 1; i <= height; i++) {
            List<Integer> currentLevel = new ArrayList<>();
            getLevel(root, i, currentLevel);
            result.add(currentLevel);
        }

        return result;
    }

    private void getLevel(TreeNode node, int level, List<Integer> currentLevel) {
        if (node == null) return;

        if (level == 1) {
            currentLevel.add(node.val);
        } else {
            getLevel(node.left, level - 1, currentLevel);
            getLevel(node.right, level - 1, currentLevel);
        }
    }

    // function to calculate height of the tree
    private int getHeight(TreeNode node) {
        if (node == null) return 0;

        return 1 + Math.max(getHeight(node.left), getHeight((node.right)));
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
