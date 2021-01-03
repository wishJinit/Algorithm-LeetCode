package graph;

// https://leetcode.com/problems/all-paths-from-source-to-target/
// All Paths From Source to Target

import java.util.*;

public class Q797 {
    private int LEN;
    private List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LEN = graph.length;
        buildPath(graph, List.of(0), 0);
        return answer;
    }

    private void buildPath(int[][] graph, List<Integer> pathList, int label) {
        if (label == LEN - 1) {
            answer.add(pathList);
            return;
        }
        int[] connectNodes = graph[label];
        for (int connectNode : connectNodes) {
            List<Integer> path = new ArrayList<>(pathList);
            path.add(connectNode);
            buildPath(graph, path, connectNode);
        }
    }
}
