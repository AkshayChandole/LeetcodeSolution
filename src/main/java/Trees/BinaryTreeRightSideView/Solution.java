package Trees.BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// ******************************************************************************
// Optimal Solution using Breadth First Search (BFS) and One Queue -

/**
 * Time Complexity - O(n), where n is the number of nodes in the tree.
 * Space Complexity - O(n), due to the extra space required for the BFS queue.
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (i == size - 1) result.add(node.val);  // Rightmost node

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
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

        @Override
        public String toString() {
            return "Node: " + val;
        }
    }
}

// ******************************************************************************
// Better Solution using Breadth First Search (BFS) and Two Queues -

/**
 * Time Complexity - O(n), where n is the number of nodes in the tree. Each node is processed exactly once.
 * Space Complexity - O(n), to maintain two separate queues.
 */
class Solution2 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        if (root == null) return rightView;

        Queue<TreeNode> currentLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();

        currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            TreeNode node = currentLevel.poll();

            if (node.left != null) nextLevel.add(node.left);
            if (node.right != null) nextLevel.add(node.right);

            if (currentLevel.isEmpty()) {
                rightView.add(node.val);
                currentLevel = nextLevel;
                nextLevel = new LinkedList<>();
            }
        }

        return rightView;
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

// ******************************************************************************
// Brute Force Solution using Depth First Search (DFS) and recursion -

/**
 * Time Complexity - O(n^2) in the worst case because, for each node, we might search through the depth to see if it's the first node of its depth.
 * Space Complexity - O(n) for storing the result.
 */
class Solution1 {
    List<Integer> rightView = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return rightView;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) return;

        if (depth == rightView.size()) {
            rightView.add(node.val);
        }

        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
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
