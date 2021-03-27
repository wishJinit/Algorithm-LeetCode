package challenge.y2021_week11;

// https://leetcode.com/problems/average-of-levels-in-binary-tree/
// Average of Levels in Binary Tree
// 참고 : https://leetcode.com/problems/average-of-levels-in-binary-tree/discuss/105107/Java-BFS-Solution

import java.util.*;

public class Q05 {
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

    private final Map<Integer, Long> valueMap = new HashMap<>();
    private final Map<Integer, Integer> cntMap = new HashMap<>();

    public List<Double> averageOfLevels(TreeNode root) {
        dfs(root, 0);

        List<Double> list = new ArrayList<>();
        for (int idx : valueMap.keySet()) {
            list.add(idx, (double) valueMap.get(idx) / cntMap.get(idx));
        }

        return list;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) return;

        valueMap.put(depth, valueMap.getOrDefault(depth, 0L) + node.val);
        cntMap.put(depth, cntMap.getOrDefault(depth, 0) + 1);
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
