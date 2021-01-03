package array;

// https://leetcode.com/problems/max-increase-to-keep-city-skyline/
// Max Increase to Keep City Skyline

import java.util.Arrays;

public class Q807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        final int LEN = grid.length;
        int[] VERTICAL_MAX = new int[LEN], HORIZONTAL_MAX = new int[LEN];
        for (int i = 0; i < LEN; i++) {
            HORIZONTAL_MAX[i] = Arrays.stream(grid[i]).max().orElse(-1);
            for (int[] g : grid) VERTICAL_MAX[i] = Math.max(VERTICAL_MAX[i], g[i]);
        }

        int answer = 0;
        for (int i = 0; i < LEN; i++) {
            for (int j = 0; j < LEN; j++) {
                answer += Math.min(HORIZONTAL_MAX[i], VERTICAL_MAX[j]) - grid[i][j];
            }
        }

        return answer;
    }
}
