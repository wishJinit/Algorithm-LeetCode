package math;

// https://leetcode.com/problems/stone-game/submissions/
// Stone Game

public class Q877 {
    public boolean stoneGame(int[] piles) {
        int startIdx = 0, endIdx = piles.length - 1;
        int sum = 0;

        while (startIdx < endIdx) {
            int startValue = piles[startIdx], endValue = piles[endIdx];
            if (startValue > endValue) {
                sum += startValue;
                startValue = piles[++startIdx];
            } else {
                sum += endValue;
                endValue = piles[--endIdx];
            }

            if (startValue < endValue) {
                sum -= startValue;
                startIdx++;
            } else {
                sum -= endValue;
                endIdx--;
            }
        }

        return (sum > 0);
    }
}
