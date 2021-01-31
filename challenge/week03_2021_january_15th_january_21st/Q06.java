package challenge.week03_2021_january_15th_january_21st;

// https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3610/
// Valid Parentheses

import java.util.*;

public class Q06 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        boolean check = true;
        for (char c : s.toCharArray()) {
            Character pb = getPartnerBracket(c);
            if (pb == null) stack.push(c);
            else {
                if (stack.isEmpty() || stack.peek() != pb) {
                    check = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        return (stack.isEmpty() && check);
    }

    private Character getPartnerBracket(char c) {
        if (c == ')') return '(';
        else if (c == '}') return '{';
        else if (c == ']') return '[';
        else return null;
    }
}
