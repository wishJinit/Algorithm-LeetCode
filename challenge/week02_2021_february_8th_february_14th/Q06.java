package challenge.week02_2021_february_8th_february_14th;

// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3638/
// Shortest Path in Binary Matrix

import java.util.*;

public class Q06 {
    private static class Point {
        int y, x, value;

        Point(int y, int x, int value) {
            this.y = y;
            this.x = x;
            this.value = value;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        final int DIRECTION_LEN = 8;
        int n = grid.length;
        boolean[][] map = new boolean[n][n];
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};

        if (grid[0][0] == 1) return -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) grid[i][j] = -1;
                else grid[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1));
        map[0][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            int y = p.y, x = p.x, value = p.value;
            grid[y][x] = Math.min(value, grid[y][x]);
            for (int z = 0; z < DIRECTION_LEN; z++) {
                int my = y + dy[z];
                int mx = x + dx[z];
                if (isValidPath(my, mx, grid, n, map)) {
                    q.add(new Point(my, mx, value + 1));
                    map[my][mx] = true;
                }
            }
        }

        grid[n - 1][n - 1] = (grid[n - 1][n - 1] == Integer.MAX_VALUE ? -1 : grid[n - 1][n - 1]);
        return grid[n - 1][n - 1];
    }

    private boolean isValidPath(int y, int x, int[][] grid, int n, boolean[][] map) {
        return (0 <= y && y < n) && (0 <= x && x < n) && grid[y][x] != -1 && !map[y][x];
    }
}
