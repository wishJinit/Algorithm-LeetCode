package challenge.week03_2021_february_15th_february_21st;

// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3642/
// Letter Case Permutation

import java.util.*;

public class Q02 {
    List<String> answer = new ArrayList<>();
    char[] chars;
    int len;
    int alphaCnt = 0;

    public List<String> letterCasePermutation(String S) {
        len = S.length();
        String lowerString = S.toLowerCase();
        chars = lowerString.toCharArray();
        answer.add(new String(chars));

        for (int i = 0; i < len; i++) {
            if (Character.isAlphabetic(chars[i])) alphaCnt++;
        }

        dfs(0, 1);

        return answer;
    }

    private void dfs(int idx, int convertAlphaCnt) {
        if (convertAlphaCnt > alphaCnt) return;

        for (int i = idx; i < len; i++) {
            if (Character.isAlphabetic(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                answer.add(new String(chars));
                dfs(i + 1, convertAlphaCnt + 1);
                chars[i] = Character.toLowerCase(chars[i]);
            }
        }
    }
}
