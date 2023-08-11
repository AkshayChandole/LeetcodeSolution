package Trees.SubtreeOfAnotherTree;

// *******************************************************************************
// Optimal Solution using StringBuilder -

/**
 * Time Complexity - O(m + n) where m = number of nodes in subRoot and n = number of nodes in root.
 * Space Complexity - O(max(m,n))
 */
public class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder tree1 = new StringBuilder();
        StringBuilder tree2 = new StringBuilder();
        convertPreOrder(root, tree1);
        convertPreOrder(subRoot, tree2);
        if (tree1.indexOf(tree2.toString()) == -1) {
            return false;
        }
        return true;
    }

    private void convertPreOrder(TreeNode root, StringBuilder s) {
        if (root == null) {
            s.append(",#");
        } else {
            s.append("," + root.val);
            convertPreOrder(root.left, s);
            convertPreOrder(root.right, s);
        }
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
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

// *******************************************************************************
// Brute Force Solution using pre-order traversal and recursion -

/**
 * Time Complexity - O(m * n), Traversing on subtree 'subRoot' of size m for every n node of Tree 'root'.
 * Space Complexity - O(h) where h is the height of the tree 'root'.
 */
class Solution1 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;

        if (isIdentical(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // A utility function to check whether trees with roots as root1 and root2 are identical or not.
    public boolean isIdentical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if ((root1 == null || root2 == null)) return false;

        return (root1.val == root2.val && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right));
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
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
