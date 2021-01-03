package graph;

// https://leetcode.com/problems/maximum-binary-tree/submissions/
// Maximum Binary Tree

public class Q654 {

    class TreeNode {
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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) return null;
        int max = nums[start], maxIdx = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }
        TreeNode treeNode = new TreeNode(max);
        treeNode.left = buildTree(nums, start, maxIdx - 1);
        treeNode.right = buildTree(nums, maxIdx + 1, end);
        return treeNode;
    }
}
