package challenge.week03_2021_february_15th_february_21st;

// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3641/
// The K Weakest Rows in a Matrix

import java.util.*;
import java.util.stream.IntStream;

public class Q01 {
    private static class Power {
        int index, value;

        Power(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        Power[] powers = new Power[m];
        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) cnt++;
            }
            powers[i] = new Power(i, cnt);
        }

        Arrays.sort(powers, (o1, o2) -> {
            if (o1.value == o2.value) return Integer.compare(o1.index, o2.index);
            else return Integer.compare(o1.value, o2.value);
        });

        return IntStream.range(0, k)
                .map(i -> powers[i].index)
                .toArray();
    }
}
