package challenge.week02_2021_february_8th_february_14th;

// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3634/
// Convert BST to Greater Tree

public class Q02 {
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

    public TreeNode convertBST(TreeNode root) {
        getSumOfNodes(root, 0);
        return root;
    }

    private int getSumOfNodes(TreeNode node, int sum) {
        if (node == null) return 0;
        if (node.right == null) node.val += sum;
        else node.val += getSumOfNodes(node.right, sum);
        if (node.left == null) return node.val;
        else return getSumOfNodes(node.left, node.val);
    }
}
