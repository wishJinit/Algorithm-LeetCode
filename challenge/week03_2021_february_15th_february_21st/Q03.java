package challenge.week03_2021_february_15th_february_21st;

// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3643/
// Container With Most Water

public class Q03 {
    public int maxArea(int[] height) {
        int len = height.length, max = 0;

        for (int i = 1; i < len; i++) {
            int h1 = height[i];
            for (int j = 0; j < i; j++) {
                int h2 = height[j];
                max = Math.max((i - j) * Math.min(h1, h2), max);
                if (h2 >= h1) break;
            }
        }
        return max;
    }
}
