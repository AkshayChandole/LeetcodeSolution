package Trees.KthSmallestElementInBST;

import java.util.ArrayList;
import java.util.List;


// ***************************************************************************************
// Optimal Solution with In-order traversal with early stopping -

/**
 * Time Complexity - O(h + k), where h is the height of the tree. In the worst case (when k is the number of nodes in the tree), this becomes O(n).
 * Space Complexity - O(h), which corresponds to the stack space for the recursion (i.e., the height of the BST)
 */
public class Solution {

    int count = 0;
    int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return result;
    }

    private void inOrderTraversal(TreeNode node, int k) {
        if (node == null) return;

        inOrderTraversal(node.left, k);

        // Increment the count. If count is equal to k, then store the result.
        if (++count == k) {
            result = node.val;
            return;
        }

        inOrderTraversal(node.right, k);
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


// ***************************************************************************************
// Brute Force Solution with In-order traversal and List Storage -

/**
 * Time Complexity - O(n), where n is the number of nodes, as we need to traverse each node once
 * Space Complexity - O(n), because we're storing all the nodes in a list.
 */
class Solution1 {

    List<Integer> inOrderList = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root);
        return inOrderList.get(k - 1);
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) return;

        inOrderTraversal(node.left);
        inOrderList.add(node.val);
        inOrderTraversal(node.right);
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
