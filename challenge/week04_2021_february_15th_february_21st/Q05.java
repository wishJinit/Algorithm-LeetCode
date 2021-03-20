package challenge.week04_2021_february_15th_february_21st;

// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3653/
// Validate Stack Sequences

import java.util.*;

public class Q05 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        final int LEN = pushed.length;
        Stack<Integer> stack = new Stack<>();

        int idx = 0;
        for (int value : popped) {
            while ((stack.isEmpty() || stack.peek() != value) && idx < LEN) {
                stack.push(pushed[idx++]);
            }
            while (!stack.isEmpty()) {
                if (stack.peek() == value) stack.pop();
                else break;
            }
        }

        return stack.isEmpty();
    }
}
