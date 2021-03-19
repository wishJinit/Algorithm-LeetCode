package challenge.week04_2021_february_15th_february_21st;

// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3651/
// Score of Parentheses

import java.util.*;

public class Q03 {
    public int scoreOfParentheses(String S) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.add(0);
            } else {
                int sum = 0;
                while (!stack.isEmpty() && stack.peek() != 0) {
                    sum += stack.pop();
                }
                stack.pop();
                stack.add((sum == 0 ? 1 : sum * 2));
            }
        }

        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        return answer;
    }
}
