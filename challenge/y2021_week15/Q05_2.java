package challenge.y2021_week15;

// https://leetcode.com/problems/word-subsets/
// Word Subsets
// 배열 사용

import java.util.*;

public class Q05_2 {
    private final int ALPHA_LEN = 26;

    public List<String> wordSubsets(String[] A, String[] B) {
        int[] alpha = new int[ALPHA_LEN];
        for (String b : B) {
            int[] arr = new int[ALPHA_LEN];
            for (char cb : b.toCharArray()) {
                arr[cb - 'a']++;
            }
            for (char cb : b.toCharArray()) {
                int idx = cb - 'a';
                alpha[idx] = Math.max(alpha[idx], arr[idx]);
            }
        }

        int cnt = Arrays.stream(alpha).map(o -> o > 0 ? 1 : 0).sum();

        List<String> answer = new ArrayList<>();
        for (String a : A) {
            if (checkStr(a, alpha, cnt)) answer.add(a);
        }

        return answer;
    }

    private boolean checkStr(String s, int[] alpha, int alphaCnt) {
        int cnt = 0;
        int[] arr = new int[ALPHA_LEN];
        System.arraycopy(alpha, 0, arr, 0, ALPHA_LEN);
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            arr[idx]--;
            if (arr[idx] == 0) cnt++;
        }
        return alphaCnt <= cnt;
    }
}
