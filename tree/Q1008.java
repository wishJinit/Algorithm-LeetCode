package tree;

// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
// Construct Binary Search Tree from Preorder Traversal

public class Q1008 {
    private class TreeNode {
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

    int idx = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return buildBinaryTree(Integer.MAX_VALUE, preorder);
    }

    private TreeNode buildBinaryTree(int root, int[] preorder) {
        int val = preorder[idx++];
        TreeNode left = null, right = null;
        if (idx < preorder.length && preorder[idx] < val)
            left = buildBinaryTree(Math.min(val, root), preorder);
        if (idx < preorder.length && preorder[idx] > val && preorder[idx] < root)
            right = buildBinaryTree(Math.max(val, root), preorder);
        return new TreeNode(val, left, right);
    }
}
