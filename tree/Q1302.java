package tree;

// https://leetcode.com/problems/deepest-leaves-sum/
// Deepest Leaves Sum

import java.util.*;

public class Q1302 {
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

    private class Node {
        int value, deep;

        Node(int value, int deep) {
            this.value = value;
            this.deep = deep;
        }
    }

    List<Node> nodeOfDeepest = new ArrayList<>();

    public int deepestLeavesSum(TreeNode root) {
        int answer;
        getMaxDeep(0, root);
        int maxDeep = nodeOfDeepest
                .stream()
                .max(Comparator.comparingInt(o -> o.deep))
                .map(o->o.deep)
                .orElse(0);
        answer = nodeOfDeepest.stream().filter(o -> o.deep == maxDeep).mapToInt(o -> o.value).sum();
        return answer;
    }

    private void getMaxDeep(int deep, TreeNode treeNode) {
        if(treeNode == null) return;
        else if (treeNode.left == null && treeNode.right == null) {
            nodeOfDeepest.add(new Node(treeNode.val, deep));
            return;
        }
        getMaxDeep(deep + 1, treeNode.left);
        getMaxDeep(deep + 1, treeNode.right);
    }
}
