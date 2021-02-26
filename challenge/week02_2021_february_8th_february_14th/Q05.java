package challenge.week02_2021_february_8th_february_14th;

// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3637/
// Number of Steps to Reduce a Number to Zero

public class Q05 {
    public int numberOfSteps(int num) {
        int cnt = 0;
        while (num > 0) {
            if (num % 2 == 0) num /= 2;
            else num -= 1;
            cnt++;
        }
        return cnt;
    }
}
