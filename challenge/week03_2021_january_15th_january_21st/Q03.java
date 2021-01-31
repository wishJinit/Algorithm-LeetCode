package challenge.week03_2021_january_15th_january_21st;

// https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3607/
// Count Sorted Vowel Strings

public class Q03 {
    private final int LEN = 5;
    private final int[] arr = new int[LEN + 1];

    public int countVowelStrings(int n) {
        if (n == 1) return LEN;

        for (int i = 1; i <= LEN; i++) {
            for (int j = LEN; j >= i; j--) {
                arr[j] += i;
            }
        }

        return calculate(n, LEN, 2);
    }

    private int calculate(int n, int idx, int deep) {
        if (n == deep) return arr[idx];

        int answer = 0;
        for (int i = 1; i <= idx; i++) {
            answer += calculate(n, i, deep + 1);
        }

        return answer;
    }
}
