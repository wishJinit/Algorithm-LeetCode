package challenge.week03_2021_february_15th_february_21st;

// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3645/
// Minimum Remove to Make Valid Parentheses

public class Q05 {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();

        int leftCnt = 0, rightCnt = 0;
        for (char c : chars) {
            switch (c) {
                case '(':
                    leftCnt++;
                    break;
                case ')':
                    if (leftCnt > rightCnt)
                        rightCnt++;
                    break;
            }
        }

        int maxParenthesesCnt = Math.min(leftCnt, rightCnt);
        leftCnt = 0;
        rightCnt = 0;
        for (char c : chars) {
            switch (c) {
                case '(':
                    if (leftCnt++ < maxParenthesesCnt) {
                        sb.append(c);
                    }
                    break;
                case ')':
                    if (leftCnt > rightCnt && rightCnt++ < maxParenthesesCnt) {
                        sb.append(c);
                    }
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }
}
