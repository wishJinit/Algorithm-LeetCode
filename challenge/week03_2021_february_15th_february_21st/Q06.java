package challenge.week03_2021_february_15th_february_21st;

// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3646/
// Roman to Integer

import java.util.*;

public class Q06 {
    private final Map<Character, Integer> romanMap = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int answer = 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        int[] values = new int[len];

        for (int i = 0; i < len; i++) {
            values[i] = romanMap.get(chars[i]);
        }

        for (int i = 0; i < len - 1; i++) {
            int cv1 = values[i], cv2 = values[i + 1];
            if (cv1 < cv2) {
                answer += cv2 - cv1;
                i++;
            } else {
                answer += cv1;
            }
        }

        if (len == 1 || values[len - 2] >= values[len - 1]) {
            answer += values[len - 1];
        }

        return answer;
    }
}
