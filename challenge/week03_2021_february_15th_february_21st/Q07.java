package challenge.week03_2021_february_15th_february_21st;

// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3647/
// Broken Calculator

public class Q07 {
    public int brokenCalc(int X, int Y) {
        int answer = 0;

        while (X < Y) {
            if (Y % 2 == 0) Y /= 2;
            else Y++;
            answer++;
        }

        return X - Y + answer;
    }
}
