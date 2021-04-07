package challenge.y2021_week14;

// https://leetcode.com/problems/construct-string-from-binary-tree/
// Construct String from Binary Tree

public class Q01 {
    static class TreeNode {
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

    public String tree2str(TreeNode t) {
        return dfs(t, 1);
    }

    private String dfs(TreeNode treeNode, int depth) {
        if (treeNode == null) return "";

        StringBuilder sb = new StringBuilder();
        if (depth != 1) sb.append("(");
        sb.append(treeNode.val);

        String l = dfs(treeNode.left, depth + 1);
        String r = dfs(treeNode.right, depth + 1);
        if (r.isEmpty()) {
            if (!l.isEmpty()) sb.append(l);
        } else {
            if (l.isEmpty()) sb.append("()");
            else sb.append(l);
            sb.append(r);
        }

        if (depth != 1) sb.append(")");
        return sb.toString();
    }
}
